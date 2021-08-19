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

import br.com.sada.sistema.emprestimo.assemblers.ContaAssembler;
import br.com.sada.sistema.emprestimo.model.Conta;
import br.com.sada.sistema.emprestimo.model.dto.ContaEntradaDto;
import br.com.sada.sistema.emprestimo.service.ContaServiceImpl;

@RestController
@RequestMapping("/contas")
public class ContaController {

	private ContaServiceImpl contaServiceImpl;
	private ContaAssembler contaAssembler;

	public ContaController(ContaServiceImpl contaServiceImpl, ContaAssembler contaAssembler) {
		super();
		this.contaServiceImpl = contaServiceImpl;
		this.contaAssembler = contaAssembler;
	}

	@PostMapping
	public Conta salvar(@RequestBody @Valid ContaEntradaDto contaEntradaDto) {
		return contaServiceImpl.salvar(contaEntradaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable int id) {
		return ResponseEntity.ok(contaAssembler.toModel(contaServiceImpl.buscarPorId(id)));
	}
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable int id) {
		contaServiceImpl.deletar(id);
	}
}
