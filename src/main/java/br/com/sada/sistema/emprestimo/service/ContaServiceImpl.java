package br.com.sada.sistema.emprestimo.service;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.model.Conta;
import br.com.sada.sistema.emprestimo.model.dto.ContaEntradaDto;
import br.com.sada.sistema.emprestimo.repository.ContaRepository;

@Service
public class ContaServiceImpl {

	private ContaRepository contaRepository;
	private ClienteServiceImpl clienteServiceImpl;	
	
	public ContaServiceImpl(ContaRepository contaRepository, ClienteServiceImpl clienteServiceImpl) {
		super();
		this.contaRepository = contaRepository;
		this.clienteServiceImpl = clienteServiceImpl;
	}

	public Conta salvar(ContaEntradaDto contaEntradaDto) {
		Conta conta = contaEntradaDto.toConta();
		conta.setCliente(clienteServiceImpl.buscarPorId(contaEntradaDto.getIdCliente()));
		return contaRepository.save(conta);
	}

	public Conta buscarPorId(int id) {
		return contaRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		contaRepository.delete(buscarPorId(id));
	}
}
