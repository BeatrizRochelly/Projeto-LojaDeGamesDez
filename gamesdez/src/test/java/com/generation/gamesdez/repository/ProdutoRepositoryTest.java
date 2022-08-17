package com.generation.gamesdez.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.gamesdez.model.ProdutoModel;
import com.generation.gamesdez.model.UsuarioModel;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@BeforeAll
	void start() {

			produtoRepository.deleteAll();
			produtoRepository.save(new ProdutoModel (0L, "Jogo princesa", 30.89, true, "jogo legal e fácil de jogar"));
	}
	
	@Test
	@DisplayName("Retorna 1 nomeProduto princesa")
	public void deveRetornarUmUsuario() {

		Optional<UsuarioModel> nomeProduto = produtoRepository.findByNomeProduto("princesa");

		assertTrue(nomeProduto.get().getUsuario().equals("princesa"));
	}
	
	@Test
	void testandoProduto() {
		assertsEquals(2, 1 + 1);
		
	}

	private void assertsEquals(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	public class ProdutoValidador {

		@Test
	    public void validar(ProdutoModel produtoModel) {
	        if (produtoModel.getPreco() <= 0 && (produto.getStatus() == null || produtoModel.getStatus() == ProdutoStatus.ATIVO)) {
	            throw new ProdutoAtivadoSemPrecoException();
	        }

	

	
	
	
	

}
