package br.com.sada.sistema.emprestimo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.emprestimo.model.Parcela;
import br.com.sada.sistema.emprestimo.service.ParcelaServiceImpl;

@RestController
@RequestMapping("/parcelas")
public class ParcelaController {

	private ParcelaServiceImpl parcelaServiceImpl;

	public ParcelaController(ParcelaServiceImpl parcelaServiceImpl) {
		super();
		this.parcelaServiceImpl = parcelaServiceImpl;
	}

	
	@GetMapping("/{id}")
	public Parcela buscarPorId(@PathVariable int id) {
		return parcelaServiceImpl.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable int id) {
		parcelaServiceImpl.deletar(id);
	}
}
