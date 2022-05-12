package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionEnumTest {
	
	@Test
	public void whenDirectionIsNorthAndTurnLeft() {
		DirectionEnum origin = DirectionEnum.NORTH;
		DirectionEnum actual = origin.left();
		
		assertEquals(DirectionEnum.WEST, actual);
	}
}

