package com.generation.gamesdez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesdez.model.CategoriaModel;
import com.generation.gamesdez.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired 
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/categoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getByName(@PathVariable String nomeCategoria) {
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping 
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel nomeCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeCategoria));
		
	}
	
	@PutMapping 
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel tema) {
		return ResponseEntity.ok(repository.save(tema));
		
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
		
	}

}
