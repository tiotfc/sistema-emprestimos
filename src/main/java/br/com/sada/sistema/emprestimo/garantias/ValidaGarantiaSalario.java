package br.com.sada.sistema.emprestimo.garantias;

import java.math.BigDecimal;

import br.com.sada.sistema.emprestimo.calculos.CalcularJurosParcelas;
import br.com.sada.sistema.emprestimo.exceptions.NaoTemGarantiaException;
import br.com.sada.sistema.emprestimo.garantias.interfaces.ValidarGarantias;
import br.com.sada.sistema.emprestimo.model.Cliente;
import br.com.sada.sistema.emprestimo.model.Proposta;

public class ValidaGarantiaSalario implements ValidarGarantias {

	public void validar(Cliente cliente, Proposta proposta) {
		
		BigDecimal valorTotalParcela = CalcularJurosParcelas.calcularParcelaComJuros(proposta.getValor().divide(new BigDecimal(proposta.getQtdParcelas())) , proposta.getTaxaJuros());
		BigDecimal valorMaximoParcela = CalcularJurosParcelas.calcularValorMaximoParcela(cliente.getSalario(), new BigDecimal(15));
		
		if (valorMaximoParcela.compareTo(valorTotalParcela) < 1) {
			throw new NaoTemGarantiaException("O valor da parcela é maior que 15% do valor do salário do cliente");
		}

	}
//
//public static void main(String[] args) {
//	BigDecimal bd1 = new BigDecimal(3);
//	BigDecimal bd2 = new BigDecimal(2);
//	
//	System.out.println(bd1.compareTo(bd2)); 
//}

}
