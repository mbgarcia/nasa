package com.nasa.sonda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sonda {
	private Position position;
	
	private DirectionEnum direction;
	
	private Terrain terrain;

	public void updateDirection(DirectionEnum newDirection) {
		this.direction = newDirection;
	}

	public void move() {
		int x = direction.movingX() + position.getX();
		
		if (x > terrain.getLimitX() || x < 0) {
			x = position.getX();
		}
		
		int y = direction.movingY() + position.getY();
		
		if (y > terrain.getLimitY() || x < 0) {
			y = position.getY();
		}

		position.setX(x);
		position.setY(y);
	}

}
