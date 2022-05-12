package com.nasa.sonda.service;

import com.nasa.sonda.model.Sonda;

public class SondaService {

	public Sonda executeMoves(Sonda sonda, String moves) {
		moves.chars().forEach(c -> {
			if (c == 'L') {
				sonda.updateDirection(sonda.getDirection().left());
			}
			else if (c == 'R') {
				sonda.updateDirection(sonda.getDirection().right());
			}
			else if (c == 'M') {
				sonda.move();
			}
		});
		return sonda;
	}
}
