package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SondaTest {
	
	@Test
	public void init() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		
		assertEquals(1, sonda.getPosition().getX());
		assertEquals(2, sonda.getPosition().getY());
		assertEquals('N', sonda.getDirection().getSymbol());
	}
	
	@Test
	public void getFinalPosition() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		assertEquals("1 2 N", sonda.getFinalPosition());
	}
}
