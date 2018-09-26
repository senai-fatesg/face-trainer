package br.com.senai.fatesg.faceTrainer.persistencia;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.senai.fatesg.faceTrainer.entidade.Cobaia;

public interface CobaiaDao extends Persistencia<Cobaia>{

	Boolean isExistPorEmail(Cobaia cobaia);
	
	Cobaia consultarPoEmail(Cobaia cobaia);
	
}
