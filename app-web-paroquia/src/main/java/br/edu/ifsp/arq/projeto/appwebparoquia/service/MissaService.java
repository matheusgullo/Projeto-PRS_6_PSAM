package br.edu.ifsp.arq.projeto.appwebparoquia.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Missa;
import br.edu.ifsp.arq.projeto.appwebparoquia.repository.MissaRepository;

@Service
public class MissaService {
	@Autowired
	private MissaRepository missaRepository;
	
	public Missa atualizar(String diaSemana, Missa missa) {
		Missa missaSalvo = buscarMissaDia(diaSemana);
		BeanUtils.copyProperties(missa, missaSalvo, "diaSemana");
		return this.missaRepository.save(missaSalvo);
	}
		
	private Missa buscarMissaDia(String diaSemana) {
		Missa missaSalvo = this.missaRepository.findById(diaSemana).orElseThrow(()-> new EmptyResultDataAccessException(1));
		return missaSalvo;
	}
}
