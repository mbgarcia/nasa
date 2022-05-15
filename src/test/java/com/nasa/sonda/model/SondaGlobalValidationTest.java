package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SondaGlobalValidationTest {
	
	@Test
	public void validSonda() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		sonda.setCommands("LRM");
		
		assertTrue(sonda.isValid());
	}
	
	@Test
	public void validSonda02() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		sonda.setCommands("L");
		
		assertTrue(sonda.isValid());
	}

	@Test
	public void invalidSonda01() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		sonda.setCommands("LRT");
		
		assertFalse(sonda.isValid());
	}

	@Test
	public void invalidSonda02() {
		String line = "1 2 N";
		var sonda = new Sonda(line);
		sonda.setCommands("");
		
		assertFalse(sonda.isValid());
	}

	@Test
	public void invalidSonda03() {
		String line = "1 N";
		var sonda = new Sonda(line);
		sonda.setCommands("");
		
		assertFalse(sonda.isValid());
	}

	@Test
	public void invalidSonda04() {
		String line = "1 5 Y";
		var sonda = new Sonda(line);
		sonda.setCommands("");
		
		assertFalse(sonda.isValid());
	}
}
