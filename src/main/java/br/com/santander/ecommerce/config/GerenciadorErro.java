package br.com.santander.ecommerce.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GerenciadorErro {

	@Autowired
	private MessageSource mensagem;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDto> badRequestError(MethodArgumentNotValidException exception){
		return exception.getFieldErrors().stream().map(e->{
			String msg  = mensagem.getMessage(e, LocaleContextHolder.getLocale());
			return new ErroDto(e.getField(),msg);
		}).collect(Collectors.toList());
	}
}
