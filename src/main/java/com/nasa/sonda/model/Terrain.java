package com.nasa.sonda.model;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Terrain {
	private int limitX;
	
	private int limitY;
	
	public Terrain(String header) {
		if (header.split(" ").length != 2) {
			throw new RuntimeException("invalid.header.file");
		}
		
		if (!StringUtils.isNumericSpace(header)) {
			throw new RuntimeException("invalid.header.file");
		}

		this.limitX = Integer.parseInt(header.split(" ")[0]);
		this.limitY = Integer.parseInt(header.split(" ")[1]);
	}
}
