package br.com.sada.sistema.emprestimo.garantias;

import br.com.sada.sistema.emprestimo.exceptions.NaoTemGarantiaException;
import br.com.sada.sistema.emprestimo.garantias.interfaces.ValidarGarantias;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Proposta;

public class ValidaGarantiaPatrimonio implements ValidarGarantias {
	
	public void validar(Cliente cliente, Proposta proposta) {
		
		if(cliente.getPatrimonio().compareTo(proposta.getValor()) < 1) {
			throw new NaoTemGarantiaException("O patrimônio do cliente é menor que o valor total do emprestimo");
		}
		
	}
//	
//	public static void main(String[] args) {
//		BigDecimal bd1 = new BigDecimal(3);
//		BigDecimal bd2 = new BigDecimal(2);
//		
//		System.out.println(bd1.compareTo(bd2)); 
//	}

}
