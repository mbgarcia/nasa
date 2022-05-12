package com.nasa.sonda.model;

import lombok.Data;

@Data
public class Sonda {
	private DirectionEnum direction;

	public void updateDirection(DirectionEnum newDirection) {
		this.direction = newDirection;
	}
}
