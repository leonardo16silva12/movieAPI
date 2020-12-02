package br.com.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieapi.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
