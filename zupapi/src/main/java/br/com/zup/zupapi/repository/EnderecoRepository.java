package br.com.zup.zupapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.zupapi.modelo.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByUsuarioId(Long idUsuario);

}
