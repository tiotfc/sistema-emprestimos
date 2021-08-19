package br.com.sada.sistema.emprestimo.garantias.interfaces;

import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Proposta;

public interface ValidarGarantias {

	void validar(Cliente cliente, Proposta proposta);

}
