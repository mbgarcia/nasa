package com.nasa.sonda.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PositionTest {
	
	@Test
	public void whenDirectionIsNorthAndDoMove() {
		Position p = new Position(1, 2);
		Sonda sonda = new Sonda(p, DirectionEnum.NORTH);
		sonda.move();
		assertEquals(sonda.getPosition().getX(), 1);
		assertEquals(sonda.getPosition().getY(), 3);
	}
}
