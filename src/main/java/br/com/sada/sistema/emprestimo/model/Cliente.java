package br.com.sada.sistema.emprestimo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private BigDecimal salario;
	private LocalDate dataContratacao;
	private BigDecimal patrimonio;
	private String cpf;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Conta> conta = new ArrayList<>();
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Proposta> proposta = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String nome, BigDecimal salario, LocalDate dataContratacao, BigDecimal patrimonio, String cpf,
			List<Conta> conta, List<Proposta> proposta) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.patrimonio = patrimonio;
		this.cpf = cpf;
		this.conta = conta;
		this.proposta = proposta;
	}

	public Integer getId() {
		return id;
	}

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

	public void adicionaConta(Conta conta) {
		conta.setCliente(this);
		this.conta.add(conta);
	}

	public void adicionaProposta(Proposta proposta) {
		this.proposta.add(proposta);
	}
}
