package br.com.sada.sistema.emprestimo.error.handler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.sada.sistema.emprestimo.exceptions.NaoTemGarantiaException;
import br.com.sada.sistema.emprestimo.exceptions.StatusInvalidoPropostaException;

@RestControllerAdvice
public class ControllerAdvice {

	@Autowired
	private MessageSource message;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public List<ErroDto> getErro(MethodArgumentNotValidException ex) {
		List<ErroDto> erros = ex.getFieldErrors().stream().map(e -> {
			String mensagem = message.getMessage(e, LocaleContextHolder.getLocale());
			return new ErroDto(e.getField(), mensagem);
		}).collect(Collectors.toList());
		return erros;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {IllegalArgumentException.class, EntityNotFoundException.class} )
	public ErroDto getErro(Exception ex) {
		//String message2 = message.getMessage(null, LocaleContextHolder.getLocale());
		//return new ErroDto(null, message2);
		return new ErroDto(null, ex.getMessage());
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {NoSuchElementException.class} )
	public MensagemResposta getNaoEncontrado(Exception ex) {
		return new MensagemResposta("Registro não encontrado!");
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {NaoTemGarantiaException.class, StatusInvalidoPropostaException.class } )
	public MensagemResposta getErroFuncional(Exception ex) {
		return new MensagemResposta(ex.getMessage());	
	}
}
