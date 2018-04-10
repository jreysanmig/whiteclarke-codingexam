package org.jrey.parkingsystem;

public enum Direction {
	NORTH,EAST,SOUTH,WEST;
	
	public Direction getNextRight() {
		switch(this) {
			case NORTH: return EAST;
			case EAST: return SOUTH;
			case SOUTH: return WEST;
			case WEST: return NORTH;
			default: return this;
		}
	}
	
	public Direction getNextLeft() {
		switch(this) {
			case NORTH: return WEST;
			case EAST: return NORTH;
			case SOUTH: return EAST;
			case WEST: return SOUTH;
			default: return this;
		}
	}
}
