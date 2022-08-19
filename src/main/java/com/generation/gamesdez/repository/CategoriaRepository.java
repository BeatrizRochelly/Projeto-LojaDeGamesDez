package com.generation.gamesdez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gamesdez.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel,Long>{

	public  List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
}
