package br.com.sada.sistema.emprestimo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.emprestimo.model.Proposta;
import br.com.sada.sistema.emprestimo.model.dto.PropostaEnradaDto;
import br.com.sada.sistema.emprestimo.service.PropostaServiceImpl;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	private PropostaServiceImpl propostaServiceImpl;

	public PropostaController(PropostaServiceImpl propostaServiceImpl) {
		super();
		this.propostaServiceImpl = propostaServiceImpl;
	}

	@PostMapping
	public Proposta salvar(@RequestBody @Valid PropostaEnradaDto propostaEntradaDto) {
		return propostaServiceImpl.salvar(propostaEntradaDto);
	}
	
	@GetMapping("/{id}")
	public Proposta buscarPorId(@PathVariable int id) {
		return propostaServiceImpl.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable int id) {
		propostaServiceImpl.deletar(id);
	}
	
	@GetMapping("/contratar/{id}")
	public Proposta contratar(@PathVariable int id) {
		return propostaServiceImpl.contratarProposta(id);
	}
}
