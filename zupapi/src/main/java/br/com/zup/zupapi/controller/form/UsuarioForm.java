package br.com.zup.zupapi.controller.form;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.zupapi.modelo.Usuario;

public class UsuarioForm {
	@NotEmpty
	@NotNull
	private String nome;
	@NotEmpty
	@NotNull
	private String email;
	@NotEmpty
	@NotNull
	private String cpf;
	@NotEmpty
	@NotNull
	private String dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario converter() {
		LocalDate  dataDeNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Usuario(nome, email, cpf, dataDeNascimento);
	}

}
