package br.com.movieapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieapi.model.Pais;
import br.com.movieapi.repository.PaisRepository;
import br.com.movieapi.service.exceptions.ObjectNotFoundException;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository paisRepository;
	
	public List<Pais> listAllPais() {
		return paisRepository.findAll();
		
	}
	
	public Pais findPais(Integer id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + " Tipo: " 
		+ Pais.class.getName()));
	}
	
	public Pais insert(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public void delete(Integer id) {
		findPais(id);
		paisRepository.deleteById(id);
	}
	
	public Pais update(int id, Pais pais) {
		Pais paisSalvo = findPais(id);
		BeanUtils.copyProperties(pais, paisSalvo, "id");
		return paisRepository.save(pais);
	}
	

}
