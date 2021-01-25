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

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Paroquia;
import br.edu.ifsp.arq.projeto.appwebparoquia.repository.ParoquiaRepository;
import br.edu.ifsp.arq.projeto.appwebparoquia.service.ParoquiaService;



@RestController
@RequestMapping("/paroquia")
public class ParoquiaResource {

	@Autowired
	private ParoquiaRepository paroquiaRepository;
		
	@Autowired
	private ParoquiaService paroquiaService;
		
	@GetMapping("/{codigo}")
	public ResponseEntity<Paroquia> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Paroquia> paroquia = paroquiaRepository.findById(codigo);
		if(paroquia.isPresent()) {
			return ResponseEntity.ok(paroquia.get());
		}
		return ResponseEntity.notFound().build();
	}
		
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PAROQUIA') and #oauth2.hasScope('read')")
	public List<Paroquia> listar(){		
		return paroquiaRepository.findAll();		
	}
		
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PAROQUIA') and #oauth2.hasScope('write')")
	public Paroquia salvar(@Valid @RequestBody Paroquia paroquia ) {
		return paroquiaRepository.save(paroquia);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PAROQUIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Paroquia> buscarPeloCpf(@PathVariable Long codigo){
		Optional<Paroquia> paroquia = paroquiaRepository.findById(codigo);
		if(paroquia.isPresent()) {
			return ResponseEntity.ok(paroquia.get());
		}
		return ResponseEntity.notFound().build();
	}
		
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		paroquiaRepository.deleteById(codigo);
	}
		
	@PutMapping("/{diaSemana}")
	public ResponseEntity<Paroquia> atualizar(@PathVariable Long codigo, @RequestBody @Valid Paroquia paroquia){
		Paroquia paroquiaSalvo = paroquiaService.atualizar(codigo, paroquia);
		return ResponseEntity.ok(paroquiaSalvo);
	}
}
