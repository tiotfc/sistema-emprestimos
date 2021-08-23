package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sada.sistema.emprestimo.model.Proposta;

public class PropostaEnradaDto {

	private int idCliente;
	private BigDecimal valor;
	private BigDecimal taxaJuros;
	private Integer qtdParcelas;
	private String status;
	
	public int getIdCliente() {
		return idCliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public String getStatus() {
		return status;
	}

	public Proposta toProposta() {
		return new Proposta(valor, taxaJuros, qtdParcelas, LocalDate.now(), status, null, null);
	}

}
