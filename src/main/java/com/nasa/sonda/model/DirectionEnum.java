package com.nasa.sonda.model;

public enum DirectionEnum {
	NORTH('N') {
		@Override
		public DirectionEnum left() {
			return WEST;
		}

		@Override
		public DirectionEnum right() {
			return EAST;
		}

		@Override
		public int movingX() {
			return 0;
		}

		@Override
		public int movingY() {
			return 1;
		}
	}, 
	
	WEST('W') {
		@Override
		public DirectionEnum left() {
			return SOUTH;
		}

		@Override
		public DirectionEnum right() {
			return NORTH;
		}

		@Override
		public int movingX() {
			return -1;
		}

		@Override
		public int movingY() {
			return 0;
		}
	},
	
	SOUTH('S') {
		@Override
		public DirectionEnum left() {
			return EAST;
		}

		@Override
		public DirectionEnum right() {
			return WEST;
		}

		@Override
		public int movingX() {
			return 0;
		}

		@Override
		public int movingY() {
			return -1;
		}
	},
	
	EAST('E') {
		@Override
		public DirectionEnum left() {
			return NORTH;
		}

		@Override
		public DirectionEnum right() {
			return SOUTH;
		}

		@Override
		public int movingX() {
			return 1;
		}

		@Override
		public int movingY() {
			return 0;
		}
	};
	
	private char symbol = 0;

	DirectionEnum(char symbol) {
		this.symbol = symbol;
	}
	
	public static DirectionEnum valueOfSymbol(char symbol) {
		for (DirectionEnum e: DirectionEnum.values()) {
			if (e.symbol == symbol) {
				return e;
			}
		}
		
		return null;
	}

	public abstract DirectionEnum left();

	public abstract DirectionEnum right();
	
	public abstract int movingX();
	
	public abstract int movingY();

	public char getSymbol() {
		return symbol;
	}
}
