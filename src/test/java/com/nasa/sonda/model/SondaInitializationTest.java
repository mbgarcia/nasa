package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class SondaInitializationTest {
	
	@Test
	public void init() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		
		assertEquals(1, sonda.getPosition().getX());
		assertEquals(2, sonda.getPosition().getY());
		assertEquals('N', sonda.getDirection().getSymbol());
	}
	
	@Test
	public void validSonda() {
		String line = "14 20 N";
		var sonda = new Sonda(line);
		
		assertEquals(14, sonda.getPosition().getX());
		assertEquals(20, sonda.getPosition().getY());
		assertEquals('N', sonda.getDirection().getSymbol());
	}

	@Test
	public void invalidSonda01() {
		String line = null;
		var sonda = new Sonda(line);
		
		assertNull(sonda.getPosition());
		assertNull(sonda.getDirection());
	}

	@Test
	public void invalidSonda02() {
		String line = "a";
		var sonda = new Sonda(line);
		
		assertNull(sonda.getPosition());
		assertNull(sonda.getDirection());
	}

	@Test
	public void invalidSonda03() {
		String line = "a 2 N";
		var sonda = new Sonda(line);
		
		assertNull(sonda.getPosition());
		assertEquals('N', sonda.getDirection().getSymbol());
	}

	@Test
	public void invalidSonda04() {
		String line = "a 2 TQ TT";
		var sonda = new Sonda(line);
		
		assertNull(sonda.getPosition());
		assertNull(sonda.getDirection());
	}

	@Test
	public void invalidSonda05() {
		String line = "10 2 T";
		var sonda = new Sonda(line);
		
		assertEquals(10, sonda.getPosition().getX());
		assertEquals(2, sonda.getPosition().getY());
		assertNull(sonda.getDirection());
	}

	@Test
	public void getFinalPosition() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		assertEquals("1 2 N", sonda.getFinalPosition());
	}
}
