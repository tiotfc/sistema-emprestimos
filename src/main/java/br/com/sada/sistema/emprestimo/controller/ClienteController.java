package br.com.sada.sistema.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.dto.ClienteEntradaDto;
import br.com.sada.sistema.emprestimo.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteServiceImpl clienteServiceImpl;

	public ClienteController(ClienteServiceImpl clienteServiceImpl) {
		super();
		this.clienteServiceImpl = clienteServiceImpl;
	}

	@PostMapping
	public Cliente salvar(@RequestBody @Valid ClienteEntradaDto clienteEntradaDto) {
		return clienteServiceImpl.salvar(clienteEntradaDto.toCliente());
	}
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteServiceImpl.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorID(@PathVariable int id) {
		return clienteServiceImpl.buscarPorId(id);
	}
	
}
