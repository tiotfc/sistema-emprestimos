package br.com.sada.sistema.emprestimo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.exceptions.StatusInvalidoPropostaException;
import br.com.sada.sistema.emprestimo.garantias.ValidaGarantiaPatrimonio;
import br.com.sada.sistema.emprestimo.garantias.ValidaGarantiaSalario;
import br.com.sada.sistema.emprestimo.garantias.ValidaGarantiaTempoServico;
import br.com.sada.sistema.emprestimo.garantias.interfaces.ValidarGarantias;
import br.com.sada.sistema.emprestimo.model.Proposta;
import br.com.sada.sistema.emprestimo.model.dto.PropostaEnradaDto;
import br.com.sada.sistema.emprestimo.repository.PropostaRepository;

@Service
public class PropostaServiceImpl {

	private PropostaRepository propostaRepository;
	private ClienteServiceImpl clienteServiceImpl;
	private ParcelaServiceImpl parcelaServiceImpl;

	public PropostaServiceImpl(PropostaRepository propostaRepository, ClienteServiceImpl clienteServiceImpl,
			ParcelaServiceImpl parcelaServiceImpl) {
		super();
		this.propostaRepository = propostaRepository;
		this.clienteServiceImpl = clienteServiceImpl;
		this.parcelaServiceImpl = parcelaServiceImpl;
	}

	public Proposta salvar(PropostaEnradaDto propostaEntradaDto) {
		Proposta proposta = propostaEntradaDto.toProposta();
		proposta.setCliente(clienteServiceImpl.buscarPorId(propostaEntradaDto.getIdCliente()));
		
		List<ValidarGarantias> listGarantias = new ArrayList<>();
		listGarantias.add(new ValidaGarantiaPatrimonio());
		listGarantias.add(new ValidaGarantiaSalario());
		listGarantias.add(new ValidaGarantiaTempoServico());
		GarantiasServiceImpl garantiasServiceImpl = new GarantiasServiceImpl(listGarantias);
		
		Proposta propostaAprovada=null;
		if (garantiasServiceImpl.validarGarantiasCliente(proposta.getCliente(), proposta)) {
			propostaAprovada = propostaRepository.save(proposta);
		}
		
		return propostaAprovada;
	}

	public Proposta buscarPorId(int id) {
		return propostaRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		propostaRepository.delete(buscarPorId(id));
	}
	
	public Proposta contratarProposta(int id) {
		Proposta proposta = propostaRepository.findById(id).get();
		
		if (!proposta.getStatus().equals("PENDENTE")) {
			throw new StatusInvalidoPropostaException("Estado da proposta é diferente de PENDENTE");
		}
		
		proposta.setDataContratacao(LocalDate.now());
		proposta.setStatus("EFETIVADA");
		parcelaServiceImpl.salvar(parcelaServiceImpl.gerarParcelas(proposta));
		
		return propostaRepository.save(proposta);
	}
}
