package br.com.sada.sistema.emprestimo.exceptions;

public class NaoTemGarantiaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoTemGarantiaException(String message) {
		super(message);
	}
	
}
