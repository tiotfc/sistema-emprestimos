package br.com.sada.sistema.emprestimo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private BigDecimal valor;
	private LocalDate dataParcela;
	private String status;
	@ManyToOne
	@JsonIgnore
	private Proposta proposta;

	public Parcela() {
	}

	public Parcela(Integer numero, BigDecimal valor, LocalDate dataParcela, String status, Proposta proposta) {
		super();
		this.numero = numero;
		this.valor = valor;
		this.dataParcela = dataParcela;
		this.status = status;
		this.proposta = proposta;
	}

	public Integer getId() {
		return id;
	}

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

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

}
