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
	
	@Test
	public void whenDirectionIsSouthAndTurnRight() {
		DirectionEnum origin = DirectionEnum.NORTH;
		DirectionEnum actual = origin.right();
		
		assertEquals(DirectionEnum.EAST, actual);
	}
	
	@Test
	public void parserSymbol() {
		assertEquals(DirectionEnum.NORTH, DirectionEnum.valueOfSymbol('N'));
		assertEquals(DirectionEnum.SOUTH, DirectionEnum.valueOfSymbol('S'));
		assertEquals(DirectionEnum.WEST, DirectionEnum.valueOfSymbol('W'));
		assertEquals(DirectionEnum.EAST, DirectionEnum.valueOfSymbol('E'));
		
	}
	
}

