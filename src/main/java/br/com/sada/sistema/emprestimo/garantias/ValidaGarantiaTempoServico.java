package br.com.sada.sistema.emprestimo.garantias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.sada.sistema.emprestimo.exceptions.NaoTemGarantiaException;
import br.com.sada.sistema.emprestimo.garantias.interfaces.ValidarGarantias;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Proposta;

public class ValidaGarantiaTempoServico implements ValidarGarantias {

	
	public void validar(Cliente cliente, Proposta proposta) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataContratacao = cliente.getDataContratacao();
		
		long mesesDeServico = ChronoUnit.MONTHS.between(dataContratacao, dataAtual);
		
		if(mesesDeServico <= 3) {
			throw new NaoTemGarantiaException("O tempo de serviço deste cliente é menor que 3 meses");
		}
		
	}
	
}
