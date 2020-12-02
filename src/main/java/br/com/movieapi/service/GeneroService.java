package br.com.movieapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieapi.model.Genero;
import br.com.movieapi.repository.GeneroRepository;
import br.com.movieapi.service.exceptions.ObjectNotFoundException;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> listAllGenero() {
		return generoRepository.findAll();
		
	}
	
	public Genero findGenero(Integer id) {
		Optional<Genero> genero = generoRepository.findById(id);
		return genero.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + " Tipo: " 
		+ Genero.class.getName()));
	}
	
	public Genero insert(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public void delete(Integer id) {
		findGenero(id);
		generoRepository.deleteById(id);
	}
	
	public Genero update(int id, Genero genero) {
		Genero generoSalvo = findGenero(id);
		BeanUtils.copyProperties(genero, generoSalvo, "id");
		return generoRepository.save(genero);
	}

}
