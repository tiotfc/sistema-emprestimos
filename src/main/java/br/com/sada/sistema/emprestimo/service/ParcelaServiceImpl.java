package br.com.sada.sistema.emprestimo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.emprestimo.calculos.CalcularJurosParcelas;
import br.com.sada.sistema.emprestimo.model.Parcela;
import br.com.sada.sistema.emprestimo.model.Proposta;
import br.com.sada.sistema.emprestimo.repository.ParcelaRepository;

@Service
public class ParcelaServiceImpl {

	private ParcelaRepository parcelaRepository;

	public ParcelaServiceImpl(ParcelaRepository parcelaRepository) {
		super();
		this.parcelaRepository = parcelaRepository;
	}

	public List<Parcela> salvar(List<Parcela> listaParcelas) {
		return parcelaRepository.saveAll(listaParcelas);
//		Proposta proposta = propostaServiceImpl.buscarPorId(parcelaEntradaDto.getIdProposta());
//		parcelaEntradaDto.getListaParcelas().stream().forEach(parcela -> {
//			Parcela novaParcela = parcela.toParcela();
//			novaParcela.setProposta(proposta);
//			parcelaRepository.save(novaParcela);
//		});
//		return null;
	}

	public Parcela buscarPorId(int id) {
		return parcelaRepository.findById(id).get();
	}
	
	public void deletar(int id) {
		parcelaRepository.delete(buscarPorId(id));
	}
	
	public List<Parcela> gerarParcelas(Proposta proposta) {
		
		List<Parcela> listaParcelas = new ArrayList<>();
		LocalDate dataAtual = LocalDate.now();
		BigDecimal valorParcela = CalcularJurosParcelas.calcularParcelaComJuros(proposta.getValor().divide(new BigDecimal(proposta.getQtdParcelas())) , proposta.getTaxaJuros());
		
		for (int i = 0; i < proposta.getQtdParcelas() ; i++) {
			
			listaParcelas.add(new Parcela(i, valorParcela, dataAtual.plusMonths(i), "ABERTA", proposta));
		}
		return listaParcelas;
	}
}
