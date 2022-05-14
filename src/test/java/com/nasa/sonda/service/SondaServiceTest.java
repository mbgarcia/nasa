package com.nasa.sonda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nasa.sonda.model.DirectionEnum;
import com.nasa.sonda.model.Position;
import com.nasa.sonda.model.Sonda;
import com.nasa.sonda.model.Terrain;

public class SondaServiceTest {
	private Terrain terrain = new Terrain(5, 5);
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndTurnLeft() {
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		sonda.setPosition(new Position(1, 2));
		sonda.setTerrain(terrain);
		sonda.setCommands("LM");
		
		sonda.executeMoves();
		
		assertEquals(sonda.getDirection(), DirectionEnum.WEST);
		assertEquals(sonda.getDirection(), DirectionEnum.WEST);
		assertEquals(0, sonda.getPosition().getX());
		assertEquals(2, sonda.getPosition().getY());
	}
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndMultipleMoves() {
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		sonda.setPosition(new Position(1, 2));
		sonda.setTerrain(terrain);
		sonda.setCommands("LMLMLMLMM");
		
		sonda.executeMoves();
		
		assertEquals(sonda.getDirection(), DirectionEnum.NORTH);
		assertEquals(1, sonda.getPosition().getX());
		assertEquals(3, sonda.getPosition().getY());
	}
	
	@Test
	public void anotherMovingSondaWhenDirectionIsNorthAndMultipleMoves() {
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.EAST);
		sonda.setPosition(new Position(3, 3));
		sonda.setTerrain(terrain);
		sonda.setCommands("MMRMMRMRRM");
		
		sonda.executeMoves();
		
		assertEquals(sonda.getDirection(), DirectionEnum.EAST);
		assertEquals(5, sonda.getPosition().getX());
		assertEquals(1, sonda.getPosition().getY());
	}
	
}
