package com.nasa.sonda.model;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

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
		if (line != null && line.split(" ").length == 3) {
			String[] parts = line.split(" ");
			
			if (StringUtils.isNumeric(parts[0]) && StringUtils.isNumeric(parts[1]) ) {
				this.position = new Position(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}
			
			this.direction = DirectionEnum.valueOfSymbol(parts[2].charAt(0));
		}
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

	public boolean isValid() {
		return this.position != null && this.direction != null && Pattern.matches("[LRM]+", this.commands);
	}
}
