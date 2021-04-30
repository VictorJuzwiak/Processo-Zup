package br.com.zup.zupapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.zupapi.modelo.Usuario;

public class UsuarioDto {
	private long id;
	private String nome;

	public UsuarioDto() {

	}

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();

	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuario) {

		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
