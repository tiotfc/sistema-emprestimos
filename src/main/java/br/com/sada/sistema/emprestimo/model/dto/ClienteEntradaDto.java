package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sada.sistema.emprestimo.model.Cliente;

public class ClienteEntradaDto {

	private String nome;
	private BigDecimal salario;
	private LocalDate dataContratacao;
	private BigDecimal patrimonio;
	private String cpf;

	public String getNome() {
		return nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public BigDecimal getPatrimonio() {
		return patrimonio;
	}

	public String getCpf() {
		return cpf;
	}

	public Cliente toCliente() {
		return new Cliente(nome, salario, dataContratacao, patrimonio, cpf, null, null);
	}

}
