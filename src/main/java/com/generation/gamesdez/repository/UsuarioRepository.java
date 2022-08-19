package com.generation.gamesdez.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.gamesdez.model.UsuarioModel;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModel, Long> {

		public Optional<UsuarioModel> findByUsuario(String usuario);
		
		public List <UsuarioModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);	
		}

/*O public Optional<UsuarioModel> findByUsuario(String usuario);
equivale a SELECT * FROM tb_usuario WHERE usuario = "usuario"; no SQL.
*/
