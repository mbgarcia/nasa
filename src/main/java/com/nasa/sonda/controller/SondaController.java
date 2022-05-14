package com.nasa.sonda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nasa.sonda.report.PlainTextReportBuilder;
import com.nasa.sonda.service.SondaService;

@RestController
@RequestMapping("/sondas")
public class SondaController extends BaseRestController{
	
	@Autowired
	private SondaService sondaService;
	
	@PostMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> doTerrainExplorer(@RequestParam(value = "input", required = true) MultipartFile file) throws Exception {
		var arquivo = sondaService.exploreTerrain(file.getInputStream());
		
		PlainTextReportBuilder builder = new PlainTextReportBuilder();
		builder.setReportName("MISSIONRESULT");
		
		builder.addAll(arquivo);
		
		return exportarArquivo(builder);
	}
}
