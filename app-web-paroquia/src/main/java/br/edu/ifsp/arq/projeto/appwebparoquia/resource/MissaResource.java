package br.edu.ifsp.arq.projeto.appwebparoquia.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Missa;
import br.edu.ifsp.arq.projeto.appwebparoquia.repository.MissaRepository;
import br.edu.ifsp.arq.projeto.appwebparoquia.service.MissaService;

@RestController
@RequestMapping("/missas")
public class MissaResource {

	@Autowired
	private MissaRepository missaRepository;
	
	@Autowired
	private MissaService missaService;
	
	@GetMapping
	public List<Missa> listar(){		
		return missaRepository.findAll();		
	}
	
	
	@GetMapping("/{diaSemana}")
	public ResponseEntity<Missa> buscarPeloDia(@PathVariable String dia){
		Optional<Missa> missa = missaRepository.findById(dia);
		if(missa.isPresent()) {
			return ResponseEntity.ok(missa.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MISSA') and #oauth2.hasScope('write')")
	public Missa salvar(@Valid @RequestBody Missa missa ) {
		return missaRepository.save(missa);
	}
	
		
	@DeleteMapping("/{diaSemana}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String diaSemana) {
		missaRepository.deleteById(diaSemana);
	}
	
	@PutMapping("/{diaSemana}")
	public ResponseEntity<Missa> atualizar(@PathVariable String diaSemana, @RequestBody @Valid Missa missa){
		Missa missaSalvo = missaService.atualizar(diaSemana, missa);
		return ResponseEntity.ok(missaSalvo);
	}
	
}
