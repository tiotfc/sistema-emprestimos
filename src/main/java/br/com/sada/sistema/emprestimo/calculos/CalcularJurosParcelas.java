package br.com.sada.sistema.emprestimo.calculos;
import java.math.BigDecimal;

public class CalcularJurosParcelas {

	public static BigDecimal calculaJurosAoMes(BigDecimal juroAoAno) {
		return juroAoAno.divide(new BigDecimal(12));
	}
	
	public static BigDecimal calcularParcelaComJuros(BigDecimal valorParcela, BigDecimal juroAoAno) {
		return valorParcela.multiply(calculaJurosAoMes(juroAoAno).add(new BigDecimal(1)));
	}
	
	public static BigDecimal calcularValorMaximoParcela(BigDecimal salario, BigDecimal limite) {
		return salario.multiply(limite).divide(new BigDecimal(100));
	}
	
}
