package br.com.sada.sistema.emprestimo.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.sada.sistema.emprestimo.controller.ContaController;
import br.com.sada.sistema.emprestimo.model.Conta;
import br.com.sada.sistema.emprestimo.model.dto.ContaDto;

@Component
public class ContaAssembler extends RepresentationModelAssemblerSupport<Conta, ContaDto>{

	public ContaAssembler() {
		super(ContaController.class, ContaDto.class);
	}

	@Override
	public ContaDto toModel(Conta cliente) {
		ContaDto contaDto = ContaDto.toContaDto(cliente);
		contaDto.add(getLinkContaId(cliente.getId()));
		return contaDto;
	}

	private Link getLinkContaId(Integer id) {
		return linkTo(methodOn(ContaController.class).buscarPorId(id)).withSelfRel();
	}

}
