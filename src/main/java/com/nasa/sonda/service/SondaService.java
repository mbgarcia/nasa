package com.nasa.sonda.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nasa.sonda.model.Sonda;
import com.nasa.sonda.model.Terrain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SondaService {
	public List<String> exploreTerrain(InputStream file) throws Exception {
		log.info("Deploy of sondas! Success!!! Starting material collecting.");
		
		var sondas = prepareExploration(file);
		
		List<String> resultadoExploracao = new ArrayList<>();
		
		log.info("Starting sonda explorer.");
		
		for (Sonda sonda: sondas) {
			sonda.executeMoves();
			resultadoExploracao.add(sonda.getFinalPosition());
		}
		
		if (sondas.size() == 0) {
			log.info("All sondas were rejected.");
			
			resultadoExploracao.add("All sondas were rejected.");
		}
		
		log.info("Mission completed.");
		
		return resultadoExploracao;
	}

	private List<Sonda> prepareExploration(InputStream file) throws Exception {
		log.info("Preparing sondas to explore!!!");
		List<Sonda> sondas = new ArrayList<>();
		
		try {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
				var header = br.readLine();
				
				var terrain = new Terrain(header);
				
				String line = null;
				while ((line = br.readLine()) != null) {
					var sonda = new Sonda(line);
					sonda.setTerrain(terrain);
					sonda.setCommands(br.readLine());
					if (sonda.isValid()) {
						sondas.add(sonda);
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR ON IMPORTING SONDA FILE", e);
			throw new Exception(e);
		}
		
		log.info("Everything is fine with sondas. :-)");
		
		return sondas;
	}
}
