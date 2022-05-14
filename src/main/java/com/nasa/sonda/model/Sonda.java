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
	
	private String commands;

	public Sonda(String line) {
		this.position = new Position(Character.getNumericValue(line.charAt(0)), Character.getNumericValue(line.charAt(2)));
		this.direction = DirectionEnum.valueOfSymbol(line.charAt(4));
	}
	
	public Sonda(Position position, DirectionEnum direction, Terrain terrain) {
		this.position = position;
		this.direction = direction;
		this.terrain = terrain;
	}
	
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
	
	public void executeMoves() {
		this.commands.chars().forEach(c -> {
			if (c == 'L') {
				this.updateDirection(this.getDirection().left());
			}
			else if (c == 'R') {
				this.updateDirection(this.getDirection().right());
			}
			else if (c == 'M') {
				this.move();
			}
		});
	}

	public String getFinalPosition() {
		return String.format("%s %s %s", this.position.getX(), this.position.getY(), this.direction.getSymbol());
	}
}
