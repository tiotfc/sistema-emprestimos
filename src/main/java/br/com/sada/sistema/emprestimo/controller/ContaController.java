package br.com.sada.sistema.emprestimo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.emprestimo.model.Conta;
import br.com.sada.sistema.emprestimo.model.dto.ContaEntradaDto;
import br.com.sada.sistema.emprestimo.service.ContaServiceImpl;

@RestController
@RequestMapping("/contas")
public class ContaController {

	private ContaServiceImpl contaServiceImpl;

	public ContaController(ContaServiceImpl clienteServiceImpl) {
		super();
		this.contaServiceImpl = clienteServiceImpl;
	}

	@PostMapping
	public Conta salvar(@RequestBody @Valid ContaEntradaDto contaEntradaDto) {
		return contaServiceImpl.salvar(contaEntradaDto);
	}
	
	@GetMapping("/{id}")
	public Conta buscarPorId(@PathVariable int id) {
		return contaServiceImpl.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable int id) {
		contaServiceImpl.deletar(id);
	}
}
