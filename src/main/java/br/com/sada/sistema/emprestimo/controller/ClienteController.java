package br.com.sada.sistema.emprestimo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.emprestimo.assemblers.ClienteAssembler;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.dto.ClienteDto;
import br.com.sada.sistema.emprestimo.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteServiceImpl clienteServiceImpl;
	private ClienteAssembler clienteAssembler;

	public ClienteController(ClienteServiceImpl clienteServiceImpl, ClienteAssembler clienteAssembler) {
		super();
		this.clienteServiceImpl = clienteServiceImpl;
		this.clienteAssembler = clienteAssembler;
	}

	@PostMapping
	public Cliente salvar(@RequestBody @Valid ClienteDto clienteEntradaDto) {
		return clienteServiceImpl.salvar(clienteEntradaDto);
	}
	
	@GetMapping
	public ResponseEntity<?> listarTodos(){
		return ResponseEntity.ok(clienteAssembler.toCollectionModel(clienteServiceImpl.listarTodos()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorID(@PathVariable int id) {
		return ResponseEntity.ok(clienteAssembler.toModel(clienteServiceImpl.buscarPorId(id)));
	}
	
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable int id) {
		clienteServiceImpl.deletar(id);
	}
	
}
