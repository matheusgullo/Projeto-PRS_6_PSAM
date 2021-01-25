package br.edu.ifsp.arq.projeto.appwebparoquia.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Paroquia;
import br.edu.ifsp.arq.projeto.appwebparoquia.repository.ParoquiaRepository;

public class ParoquiaService {

	@Autowired
	private ParoquiaRepository paroquiaRepository;
	
	public Paroquia atualizar(Long codigo, Paroquia paroquia) {
		Paroquia paroquiaSalvo = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(paroquia, paroquiaSalvo, "codigo");
		return this.paroquiaRepository.save(paroquiaSalvo);
	}

	private Paroquia buscarPessoaPeloCodigo(Long codigo) {
		Paroquia paroquiaSalvo = this.paroquiaRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return paroquiaSalvo;
	}

}
