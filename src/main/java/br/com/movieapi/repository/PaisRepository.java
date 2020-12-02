package br.com.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieapi.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{

}
