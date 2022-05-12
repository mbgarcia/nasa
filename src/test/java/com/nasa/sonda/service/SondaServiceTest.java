package com.nasa.sonda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nasa.sonda.model.DirectionEnum;
import com.nasa.sonda.model.Sonda;

public class SondaServiceTest {
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndTurnLeft() {
		SondaService service = new SondaService();
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		
		sonda = service.executeMoves(sonda, "LM");
		
		assertEquals(sonda.getDirection(), DirectionEnum.WEST);
	}
	
	@Test
	public void movingSondaWhenDirectionIsNorthAndMultipleMoves() {
		SondaService service = new SondaService();
		
		Sonda sonda = new Sonda();
		sonda.setDirection(DirectionEnum.NORTH);
		
		sonda = service.executeMoves(sonda, "LMLMLMLMM");
		
		assertEquals(sonda.getDirection(), DirectionEnum.NORTH);
	}
	
}
