package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TerrainTest {
	//@Test
	public void testTerrainConfigInvalidHeader01() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain(""));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}
	
	@Test
	public void testTerrainConfigInvalidHeader02() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain("a 1 1"));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}

	@Test
	public void testTerrainConfigInvalidHeader03() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain("a 1"));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}

	@Test
	public void testTerrainConfigInvalidHeader04() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain("1 1 1"));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}

	@Test
	public void testTerrainConfigInvalidHeader05() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain("12 1 h"));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}

	@Test
	public void testTerrainConfigInvalidHeader06() {
		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> new Terrain("1 n"));
		
		assertEquals("invalid.header.file", exception.getMessage());
	}

}
