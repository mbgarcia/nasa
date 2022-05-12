package com.nasa.sonda.model;

public enum DirectionEnum {
	NORTH {
		@Override
		public DirectionEnum left() {
			return WEST;
		}

		@Override
		public DirectionEnum right() {
			return EAST;
		}
	}, 
	
	WEST {
		@Override
		public DirectionEnum left() {
			return SOUTH;
		}

		@Override
		public DirectionEnum right() {
			return NORTH;
		}
	},
	
	SOUTH {
		@Override
		public DirectionEnum left() {
			return EAST;
		}

		@Override
		public DirectionEnum right() {
			return WEST;
		}
	},
	
	EAST {
		@Override
		public DirectionEnum left() {
			return NORTH;
		}

		@Override
		public DirectionEnum right() {
			return SOUTH;
		}
	};

	public abstract DirectionEnum left();

	public abstract DirectionEnum right(); 
}
