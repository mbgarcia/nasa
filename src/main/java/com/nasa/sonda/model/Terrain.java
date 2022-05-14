package com.nasa.sonda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Terrain {
	private int limitX;
	
	private int limitY;
	
	public Terrain(String header) {
		this.limitX = header.charAt(0);
		this.limitY = header.charAt(2);
	}
}
