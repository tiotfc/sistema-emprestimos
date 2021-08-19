package br.com.sada.sistema.emprestimo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.dto.ClienteDto;
import br.com.sada.sistema.emprestimo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvar(ClienteDto clienteEntradaDto) {
		return clienteRepository.save(clienteEntradaDto.toCliente());
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(int id) {
		return clienteRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		clienteRepository.delete(buscarPorId(id));
	}
	
}
