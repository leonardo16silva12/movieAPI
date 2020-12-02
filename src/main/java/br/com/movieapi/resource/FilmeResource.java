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

import br.com.movieapi.model.Filme;
import br.com.movieapi.service.FilmeService;

@RestController
@RequestMapping("filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping("/todos")
	public List<Filme> listAllFilmes() {
		return filmeService.listAllFilme();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> find(@PathVariable Integer id) {
		Filme filme = filmeService.findFilme(id);
		return ResponseEntity.ok().body(filme);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert (@RequestBody Filme filme) {
		filme = filmeService.insert(filme);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		filmeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> update(@PathVariable Integer id, @RequestBody Filme filme) {
		try {
			Filme filmeSalvo = filmeService.update(id, filme);
			return ResponseEntity.ok(filmeSalvo);
			} catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
