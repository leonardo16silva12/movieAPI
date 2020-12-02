package br.com.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieapi.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
