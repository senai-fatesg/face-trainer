package br.com.senai.fatesg.faceTrainer.persistencia;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.faceTrainer.entidade.Cobaia;

@Repository("cobaiaDao")
public class CobaiaDaoJpa extends PersistenciaJpa<Cobaia> implements CobaiaDao {

	private static final long serialVersionUID = 1L;

	@Override
	public Boolean isExistPorEmail(Cobaia cobaia) {
		Query query = em.createQuery("Select count(co) from Cobaia co WHERE co.email =:email");
		query.setParameter("email", cobaia.getEmail());
	
		Long total = (Long) query.getSingleResult();
		if(total>0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public Cobaia consultarPoEmail(Cobaia cobaia) {

		return null;
		
	}

}
