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

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ErroDto getErro(IllegalArgumentException ex) {
		//String message2 = message.getMessage(null, LocaleContextHolder.getLocale());
		//return new ErroDto(null, message2);
		return new ErroDto(null, ex.getMessage());
	}
}
