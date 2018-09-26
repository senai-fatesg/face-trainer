package br.com.senai.fatesg.faceTrainer.controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CaptureEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.faceTrainer.entidade.Cobaia;
import br.com.senai.fatesg.faceTrainer.persistencia.CobaiaDao;

@Named("CobaiaControl")
@Scope("conversation")
public class CobaiaControl {

	private Cobaia cobaia = new Cobaia();

	@Autowired
	private CobaiaDao cobaiaDao;

	private String filename;

	private Boolean podeFotografar = false;
	
	private Boolean isBtnFinalizarAtivo = false;
	
	private Integer countMinFoto = 0;
	
	private static String PAGINA_INICIAL ="index.xhtml";
	
	

	public void confirmar(ActionEvent evt) {
		try {

			if (validaCobaia(this.cobaia)) {

				if (cobaiaDao.isExistPorEmail(cobaia)) {

					this.setPodeFotografar(true);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Info", "Usuario Já Cadastrado pode Aproveitar para tirar Fotos."));
				} else {

					cobaiaDao.alterar(cobaia);
					this.setPodeFotografar(true);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Info", "Salvo Com Sucesso, Tire fotos a vontade !"));

				}
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não Foi Possivel Salvar."));
		}
	}

	private Boolean validaCobaia(Cobaia cobaia2) {

		if (cobaia2.getNome().equals(null) || cobaia2.getNome().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Nome Obrigatorio."));
			return false;

		} else if (cobaia2.getSobreNome().equals(null) || cobaia2.getSobreNome().equals("")) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Sobrenome Obrigatorio."));
			return false;

		} else if (cobaia2.getEmail().equals(null) || cobaia2.getEmail().equals("")) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email Obrigatorio."));
			return false;

		} else {

			return true;
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void finalizar(ActionEvent evt){
		
		this.cobaia = new Cobaia();
		RequestContext.getCurrentInstance().execute("document.getElementById('menutopo').click();");
		
		
	}

	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);

		String fileName = this.cobaia.getNome() + "_" + this.cobaia.getSobreNome() + "_" + String.valueOf(i);
		fileName.replace(" ", "_");

		return fileName;
	}

	public String getFilename() {
		return filename;
	}

	public void oncapture(CaptureEvent captureEvent) {
		filename = getRandomImageName();
		byte[] data = captureEvent.getData();

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		String newFileName = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "fotos"
				+ File.separator + "treinamento" + File.separator + filename + ".jpeg";

		FileImageOutputStream imageOutput;
		
		if(getCountMinFoto() < 5){
			this.countMinFoto += 1 ;
		}else{
			isBtnFinalizarAtivo = true; 
		}
		
		
		try {
		
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		
		} catch (IOException e) {
			throw new FacesException("Error in writing captured image.", e);
		}
	}

	private List<Cobaia> cobaias = new ArrayList<Cobaia>();

	public List<Cobaia> getCobaias() {
		return cobaias;
	}

	public void setCobaias(List<Cobaia> cobaias) {
		this.cobaias = cobaias;
	}

	public Cobaia getCobaia() {
		return cobaia;
	}

	public void setCobaia(Cobaia cobaia) {
		this.cobaia = cobaia;
	}

	public Boolean getPodeFotografar() {
		return podeFotografar;
	}

	public void setPodeFotografar(Boolean podeFotografar) {
		this.podeFotografar = podeFotografar;
	}

	public Boolean getIsBtnFinalizarAtivo() {
		return isBtnFinalizarAtivo;
	}

	public void setIsBtnFinalizarAtivo(Boolean isBtnFinalizarAtivo) {
		this.isBtnFinalizarAtivo = isBtnFinalizarAtivo;
	}

	public Integer getCountMinFoto() {
		return countMinFoto;
	}

	public void setCountMinFoto(Integer countMinFoto) {
		this.countMinFoto = countMinFoto;
	}

}
