package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sada.sistema.emprestimo.model.Parcela;

public class ParcelaDto {

	private Integer numero;
	private BigDecimal valor;
	private LocalDate dataParcela;
	private String status;

	public Integer getNumero() {
		return numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getDataParcela() {
		return dataParcela;
	}

	public String getStatus() {
		return status;
	}

	public Parcela toParcela() {
		return new Parcela(numero, valor, dataParcela, status, null);
	}
	
}
