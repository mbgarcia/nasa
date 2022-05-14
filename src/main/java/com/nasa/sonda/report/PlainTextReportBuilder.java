package com.nasa.sonda.report;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlainTextReportBuilder {
	private String reportName;
	
	private List<String> report = new LinkedList<>();;
	
	public PlainTextReportBuilder() {}
	
	public void addAll(List<String> rows) {
		report.addAll(rows);
	}

	public List<String> getLines() {
		return report;
	}
	
	public byte[] exportarArquivo() {
		try (ByteArrayOutputStream byteOutput = new ByteArrayOutputStream()){
			StringBuilder content = new StringBuilder();
			
			for (String linha: this.getLines()) {
				content.append(linha).append("\n");
			}
			
			byteOutput.write(content.toString().getBytes());
			
			return byteOutput.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException("error.plain.text.export", e);
		}
	}
	
}
