package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;

import br.com.sada.sistema.emprestimo.model.Conta;

public class ContaEntradaDto {

	private int idCliente;
	private String agencia;
	private String numero;
	private BigDecimal saldo;
	
	public int getIdCliente() {
		return idCliente;
	}

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
