package br.com.sada.sistema.emprestimo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.model.Parcela;
import br.com.sada.sistema.emprestimo.model.Proposta;
import br.com.sada.sistema.emprestimo.model.dto.ParcelaEntradaDto;
import br.com.sada.sistema.emprestimo.repository.ParcelaRepository;

@Service
public class ParcelaServiceImpl {

	private ParcelaRepository parcelaRepository;
	private PropostaServiceImpl propostaServiceImpl;

	public ParcelaServiceImpl(ParcelaRepository parcelaRepository, PropostaServiceImpl propostaServiceImpl) {
		super();
		this.parcelaRepository = parcelaRepository;
		this.propostaServiceImpl = propostaServiceImpl;
	}

	public List<Parcela> salvar(ParcelaEntradaDto parcelaEntradaDto) {
		Proposta proposta = propostaServiceImpl.buscarPorId(parcelaEntradaDto.getIdProposta());
		parcelaEntradaDto.getListaParcelas().stream().forEach(parcela -> {
			Parcela novaParcela = parcela.toParcela();
			novaParcela.setProposta(proposta);
			parcelaRepository.save(novaParcela);
		});
//		return buscaPorProposta(proposta);
		return null;
	}

	public Parcela buscarPorId(int id) {
		return parcelaRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		parcelaRepository.delete(buscarPorId(id));
	}
}
