package br.com.sada.sistema.emprestimo.service;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.model.Proposta;
import br.com.sada.sistema.emprestimo.model.dto.PropostaEnradaDto;
import br.com.sada.sistema.emprestimo.repository.PropostaRepository;

@Service
public class PropostaServiceImpl {

	private PropostaRepository propostaRepository;
	private ClienteServiceImpl clienteServiceImpl;	
	
	public PropostaServiceImpl(PropostaRepository propostaRepository, ClienteServiceImpl clienteServiceImpl) {
		super();
		this.propostaRepository = propostaRepository;
		this.clienteServiceImpl = clienteServiceImpl;
	}

	public Proposta salvar(PropostaEnradaDto propostaEntradaDto) {
		Proposta proposta = propostaEntradaDto.toProposta();
		proposta.setCliente(clienteServiceImpl.buscarPorId(propostaEntradaDto.getIdCliente()));
		return propostaRepository.save(proposta);
	}

	public Proposta buscarPorId(int id) {
		return propostaRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		propostaRepository.delete(buscarPorId(id));
	}
}
