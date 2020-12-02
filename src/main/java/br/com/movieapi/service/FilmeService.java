package br.com.movieapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieapi.model.Filme;
import br.com.movieapi.repository.FilmeRepository;
import br.com.movieapi.service.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> listAllFilme() {
		return filmeRepository.findAll();
		
	}
	
	public Filme findFilme(Integer id) {
		Optional<Filme> filme = filmeRepository.findById(id);
		return filme.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + " Tipo: " 
		+ Filme.class.getName()));
	}
	
	public Filme insert(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public void delete(Integer id) {
		findFilme(id);
		filmeRepository.deleteById(id);
	}
	
	public Filme update(int id, Filme filme) {
		Filme filmeSalvo = findFilme(id);
		BeanUtils.copyProperties(filme, filmeSalvo, "id");
		return filmeRepository.save(filme);
	}
	
}
