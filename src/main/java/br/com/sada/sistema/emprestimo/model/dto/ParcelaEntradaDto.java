package br.com.sada.sistema.emprestimo.model.dto;

import java.util.List;

public class ParcelaEntradaDto {

	private int idProposta;
	private List<ParcelaDto> listaParcelas;
	
	public int getIdProposta() {
		return idProposta;
	}
	public List<ParcelaDto> getListaParcelas() {
		return listaParcelas;
	}
	
}
