package com.nasa.sonda.exceptions;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nasa.sonda.controller.BaseRestController;
import com.nasa.sonda.general.BundleReader;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApplicationErrorMessage> onException(Exception e, WebRequest request) {
		logger.error(e.getMessage(), e);
		
		ApplicationErrorMessage erro = criarMensagemRetornoTo(true, e, "error.generic.message");
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}


	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ApplicationErrorMessage> onBusinessException(BusinessException e, WebRequest request) {
		logger.error(e.getMessage(), e);
		
		ApplicationErrorMessage erro = criarMensagemRetornoTo(true, e, e.getMessage());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}

	private static ApplicationErrorMessage criarMensagemRetornoTo(boolean isLightWeigth, Throwable excecao, String codMensagem, Object... args) {
        String detalhe = BundleReader.getText(codMensagem, args);
        
        ApplicationErrorMessage mensagemRetornoTo = new ApplicationErrorMessage();
        mensagemRetornoTo.setCodigo(codMensagem);
        mensagemRetornoTo.setMessage(detalhe);
        mensagemRetornoTo.setDataHora(LocalDateTime.now());
        
        String stackTracer = excecao == null ? StringUtils.EMPTY : ExceptionUtils.getStackTrace(excecao);

        mensagemRetornoTo.setStackTrace(isLightWeigth ? null : stackTracer);
        
        return mensagemRetornoTo;
    }
}
