package br.com.sada.sistema.emprestimo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String agencia;
	private String numero;
	private BigDecimal saldo;
	@ManyToOne
	private Cliente cliente;

	public Conta() {
	}

	public Conta(String agencia, String numero, BigDecimal saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
