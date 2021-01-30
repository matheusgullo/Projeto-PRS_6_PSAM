package br.edu.ifsp.arq.projeto.appwebparoquia.resource;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public List<Missa> listarMissa(){		
		return missaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Missa> buscarMissaPeloId(@PathVariable Integer id){
		Optional<Missa> missa = missaRepository.findById(id);
		if(missa.isPresent()) {
			return ResponseEntity.ok(missa.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MISSA') and #oauth2.hasScope('write')")
	public Missa salvarMissa(@Valid @RequestBody Missa missa ) {
		return missaRepository.save(missa);
	}
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerMissa(@PathVariable Integer id) {
		missaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Missa> atualizarMissa(@PathVariable Integer id, @RequestBody @Valid Missa missa){
		Missa missaSalvo = missaService.atualizarMissa(id, missa);
		return ResponseEntity.ok(missaSalvo);
	}
	
}
