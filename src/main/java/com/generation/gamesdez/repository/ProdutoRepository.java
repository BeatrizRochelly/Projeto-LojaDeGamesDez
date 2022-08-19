package com.generation.gamesdez.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.gamesdez.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findAllByNomeProdutoContainingIgnoreCase(@Param ("nomeProduto") String nomeProduto);
	
	public List<ProdutoModel> findAllByProdutoNovo(@Param ("produtoNovo") boolean produtoNovo);

	public List<ProdutoModel> findAllByPrecoBetween(@Param ("inicio") BigDecimal inicio, @Param ("fim") BigDecimal fim);
}
