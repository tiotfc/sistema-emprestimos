package br.com.sada.sistema.emprestimo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal valor;
	private BigDecimal taxaJuros;
	private Integer qtdParcelas;
	private LocalDate dataContratacao;
	private String status;
	@ManyToOne
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy = "proposta")
	private List<Parcela> parcelas;
	

	public Integer getId() {
		return id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public String getStatus() {
		return status;
	}

}
