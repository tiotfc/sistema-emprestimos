package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;

import br.com.sada.sistema.emprestimo.model.Conta;

public class ContaEntradaDto {

	private String agencia;
	private String numero;
	private BigDecimal saldo;

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public Conta toConta() {
		return new Conta(agencia, numero, saldo);
	}
}
