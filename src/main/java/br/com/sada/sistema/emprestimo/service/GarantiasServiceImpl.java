package br.com.sada.sistema.emprestimo.service;

import java.util.List;

import br.com.sada.sistema.emprestimo.garantias.interfaces.ValidarGarantias;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Proposta;

public class GarantiasServiceImpl {
	
	private List<ValidarGarantias> garantias;
	
	public GarantiasServiceImpl(List<ValidarGarantias> garantias) {
		this.garantias = garantias;
	}

	public boolean validarGarantiasCliente(Cliente cliente, Proposta proposta) {
		this.garantias.forEach(v -> v.validar(cliente, proposta));
		
		return true;
	}
}
