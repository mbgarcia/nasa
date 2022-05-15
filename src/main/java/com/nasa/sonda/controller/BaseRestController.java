package com.nasa.sonda.controller;

import java.io.ByteArrayInputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.nasa.sonda.report.PlainTextReportBuilder;



public class BaseRestController {
	protected ResponseEntity<?> exportarArquivo(PlainTextReportBuilder builder) {
		byte[] excel = builder.exportarArquivo();
		
		return exportarArquivo(excel, builder.getReportName());
	}
	
	protected ResponseEntity<?> exportarArquivo(byte[] arquivo, String nomeArquivo) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(arquivo);
		InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentLength(arquivo.length);
		responseHeaders.setContentType(MediaType.valueOf("text/plain"));
	    responseHeaders.setContentDisposition(ContentDisposition.parse("attachment; filename=\"" + nomeArquivo + ".txt\""));

		return new ResponseEntity<InputStreamResource> (inputStreamResource, responseHeaders, HttpStatus.OK);
	}
}
