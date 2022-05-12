package com.nasa.sonda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nasa.sonda.model.DirectionEnum;
import com.nasa.sonda.model.Position;
import com.nasa.sonda.model.Sonda;

public class SondaServiceTest {
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndTurnLeft() {
		SondaService service = new SondaService();
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		sonda.setPosition(new Position(1, 2));
		
		sonda = service.executeMoves(sonda, "LM");
		
		assertEquals(sonda.getDirection(), DirectionEnum.WEST);
		assertEquals(sonda.getDirection(), DirectionEnum.WEST);
		assertEquals(0, sonda.getPosition().getX());
		assertEquals(2, sonda.getPosition().getY());
	}
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndMultipleMoves() {
		SondaService service = new SondaService();
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		sonda.setPosition(new Position(1, 2));
		
		sonda = service.executeMoves(sonda, "LMLMLMLMM");
		
		assertEquals(sonda.getDirection(), DirectionEnum.NORTH);
		assertEquals(1, sonda.getPosition().getX());
		assertEquals(3, sonda.getPosition().getY());
	}
	
}
