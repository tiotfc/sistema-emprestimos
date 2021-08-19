package br.com.sada.sistema.emprestimo.assemblers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.sada.sistema.emprestimo.controller.ClienteController;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.dto.ClienteDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;

@Component
public class ClienteAssembler extends RepresentationModelAssemblerSupport<Cliente, ClienteDto>{

	public ClienteAssembler() {
		super(ClienteController.class, ClienteDto.class);
	}

	@Override
	public ClienteDto toModel(Cliente cliente) {
		ClienteDto clienteDto = ClienteDto.toClienteDto(cliente);
		clienteDto.add(getLinkClienteId(cliente.getId()));
		return clienteDto;
	}
	
	@Override
	public CollectionModel<ClienteDto> toCollectionModel(Iterable<? extends Cliente> entities) {
		return super.toCollectionModel(entities).add(getLinkClientes());
	}

	private Link getLinkClienteId(Integer id) {
		return linkTo(methodOn(ClienteController.class).buscarPorID(id)).withSelfRel();
	}

	private Link getLinkClientes() {
		return linkTo(methodOn(ClienteController.class).listarTodos()).withRel("clientes");
	}
}
