package br.com.zup.zupapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.zupapi.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	 Optional<Usuario> findById(Long id);

}
