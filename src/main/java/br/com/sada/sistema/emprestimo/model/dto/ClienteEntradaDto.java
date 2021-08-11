package br.com.sada.sistema.emprestimo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Conta;

public class ClienteEntradaDto {

	private String nome;
	private BigDecimal salario;
	private LocalDate dataContratacao;
	private BigDecimal patrimonio;
	private String cpf;
	private List<ContaEntradaDto> listaContas;

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

	public List<ContaEntradaDto> getListaContas() {
		return listaContas;
	}

	public Cliente toCliente() {
		Cliente cliente = new Cliente(nome, salario, dataContratacao, patrimonio, cpf, null, null);
		listaContas.stream().forEach(i -> {
			cliente.adicionaConta(new Conta(i.getAgencia(), i.getNumero(), i.getSaldo()));
		});
		return cliente;
	}

}
