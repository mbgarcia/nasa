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

	public void updateDirection(DirectionEnum newDirection) {
		this.direction = newDirection;
	}

	public void move() {
		switch (direction) {
			case NORTH:
				position.setY(position.getY() + 1);
				break;
			case SOUTH:
				position.setY(position.getY() - 1);
				break;
			case WEST:
				position.setX(position.getX() - 1);
				break;
			case EAST:
				position.setX(position.getX() + 1);
				break;
		}
	}

}
