package br.edu.ifsp.arq.projeto.appwebparoquia.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Paroquia;
import br.edu.ifsp.arq.projeto.appwebparoquia.repository.ParoquiaRepository;

@Service
public class ParoquiaService {

	@Autowired
	private ParoquiaRepository paroquiaRepository;
	
	public Paroquia atualizarParoquia(Long codigo, Paroquia paroquia) {
		Paroquia paroquiaSalvo = buscarParoquiaPeloCodigo(codigo);
		BeanUtils.copyProperties(paroquia, paroquiaSalvo, "codigo");
		return this.paroquiaRepository.save(paroquiaSalvo);
	}

	private Paroquia buscarParoquiaPeloCodigo(Long codigo) {
		Paroquia paroquiaSalvo = this.paroquiaRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return paroquiaSalvo;
	}

}
