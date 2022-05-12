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
		position.setX(direction.movingX() + position.getX());
		position.setY(direction.movingY() + position.getY());
	}

}
