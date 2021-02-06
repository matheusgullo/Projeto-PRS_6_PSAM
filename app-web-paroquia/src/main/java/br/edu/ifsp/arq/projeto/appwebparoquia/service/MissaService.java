package br.edu.ifsp.arq.projeto.appwebparoquia.service;

import java.util.List;

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
	
	public Missa atualizarMissa(Integer id, Missa missa) {
		Missa missaSalvo = buscarMissaId(id);
		BeanUtils.copyProperties(missa, missaSalvo, "id");
		return this.missaRepository.save(missaSalvo);
	}
		
	private Missa buscarMissaId(Integer id) {
		Missa missaSalvo = this.missaRepository.findById(id).orElseThrow(()-> new EmptyResultDataAccessException(1));
		return missaSalvo;
	}
	
}
