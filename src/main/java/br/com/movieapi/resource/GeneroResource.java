package br.com.movieapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.movieapi.model.Genero;
import br.com.movieapi.service.GeneroService;

@RestController
@RequestMapping("generos")
public class GeneroResource {

	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/todos")
	public List<Genero> listAllGeneros() {
		return generoService.listAllGenero();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> find(@PathVariable Integer id) {
		Genero genero = generoService.findGenero(id);
		return ResponseEntity.ok().body(genero);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert (@RequestBody Genero genero) {
		genero = generoService.insert(genero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(genero.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		generoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genero> update(@PathVariable Integer id, @RequestBody Genero genero) {
		try {
			Genero generoSalvo = generoService.update(id, genero);
			return ResponseEntity.ok(generoSalvo);
			} catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
