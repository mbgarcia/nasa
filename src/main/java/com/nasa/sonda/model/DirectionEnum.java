package com.nasa.sonda.model;

public enum DirectionEnum {
	NORTH {
		@Override
		public DirectionEnum left() {
			return WEST;
		}
	}, 
	
	WEST {
		@Override
		public DirectionEnum left() {
			return SOUTH;
		}
	},
	
	SOUTH {
		@Override
		public DirectionEnum left() {
			return EAST;
		}
	},
	
	EAST {
		@Override
		public DirectionEnum left() {
			return NORTH;
		}
	};

	public abstract DirectionEnum left(); 
}
