package br.com.zup.zupapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.zupapi.modelo.Endereco;
import br.com.zup.zupapi.modelo.Usuario;
import br.com.zup.zupapi.repository.UsuarioRepository;

public class EnderecoForm {
	@NotNull
	@NotEmpty
	private String logradouro;
	@NotNull
	private Integer numero;
	@NotNull
	private String complemento;
	@NotNull
	@NotEmpty
	private String bairro;
	@NotNull
	@NotEmpty
	private String cidade;
	@NotNull
	@NotEmpty
	@Length(max = 2 , min = 2)
	private String uf;
	@NotNull
	@NotEmpty
	private String cep;
	@NotNull
	private Long idUsuario;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Endereco converter(UsuarioRepository usuarioRepository , Usuario usuario) {
		return new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep, usuario);
	}

}
