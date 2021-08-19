package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Conta;

public class ContaDto extends RepresentationModel<ContaDto> {

	private Cliente cliente;
	private String agencia;
	private String numero;
	private BigDecimal saldo;

	public ContaDto(Cliente cliente, String agencia, String numero, BigDecimal saldo) {
		this.cliente = cliente;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
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

	public static ContaDto toContaDto(Conta conta) {
		return new ContaDto(conta.getCliente(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());
	}
	
	public Conta toConta() {
		return new Conta(agencia, numero, saldo);
	}

}
