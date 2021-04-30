package br.com.zup.zupapi.controller;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.zupapi.controller.dto.EnderecoDto;
import br.com.zup.zupapi.controller.form.EnderecoForm;
import br.com.zup.zupapi.modelo.Endereco;
import br.com.zup.zupapi.modelo.Usuario;
import br.com.zup.zupapi.repository.EnderecoRepository;
import br.com.zup.zupapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;


	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Usuario> usuario = usuarioRepository.findById(form.getIdUsuario());
		if (!usuario.isPresent()) {
			return ResponseEntity.badRequest().body(new EnderecoDto("Nenhum usuario encontrado com esse ID"));
		}
		Endereco endereco = form.converter(usuarioRepository , usuario.get());
		enderecoRepository.save(endereco);

		URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}

	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<EnderecoDto>> listarPorUsuario(@PathVariable Long id) {
		List<Endereco> enderecos = enderecoRepository.findByUsuarioId(id);
		if (enderecos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(EnderecoDto.converter(enderecos));
	}
}
