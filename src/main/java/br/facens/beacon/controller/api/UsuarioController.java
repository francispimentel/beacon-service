package br.facens.beacon.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.beacon.model.UsuarioModel;
import br.facens.beacon.repository.UsuarioRepository;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<UsuarioModel> buscarTodos() {
		return usuarioRepository.findAll();
	}

	@GetMapping("{id}")
	public UsuarioModel buscarPorId(@PathVariable("id") Long id) {
		return usuarioRepository.findOne(id);
	}
}