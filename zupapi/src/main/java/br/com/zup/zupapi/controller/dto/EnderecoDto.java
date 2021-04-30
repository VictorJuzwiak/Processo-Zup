package br.com.zup.zupapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.zupapi.modelo.Endereco;

public class EnderecoDto {
	private Long id;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String erroCadastro;

	public EnderecoDto(Endereco endereco) {
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
		this.cep = endereco.getCep();
		this.id = endereco.getId();
	}
	
	public EnderecoDto(String erroCadastro) {
		super();
		this.erroCadastro = erroCadastro;
	}



	public Long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}
	

	public String getErroCadastro() {
		return erroCadastro;
	}

	public static List<EnderecoDto> converter(List<Endereco> endereco) {
		return endereco.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}

}
