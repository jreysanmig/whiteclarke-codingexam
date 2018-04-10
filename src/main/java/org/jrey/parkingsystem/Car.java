package org.jrey.parkingsystem;

import java.util.List;

public class Car {
	private char symbol;
	private int xLoc;
	private int yLoc;
	Direction direction;
	
	public Car() {
		this.direction = Direction.NORTH;
		this.symbol = '_';
	}
	
	public Car(int x, int y) {
		this();
		this.xLoc = x;
		this.yLoc = y;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getXLoc() {
		return xLoc;
	}

	public int getYLoc() {
		return yLoc;
	}

	public void right() {
		direction = direction.getNextRight();
	}
	
	public void left() {
		direction = direction.getNextLeft();
	}
	
	public void forward() {
		switch(this.direction) {
			case NORTH:	this.yLoc++; break;
			case SOUTH: this.yLoc--; break;
			case EAST: this.xLoc++; break;
			case WEST: this.xLoc--; break;
			default: //do nothing
		}
	}
	
	public Car calculateFinalPosition(int x, int y, List<Command> commands) {
		Car virtualCar = new Car(x,y);
		for(Command command : commands) {
			switch(command) {
				case FORWARD: virtualCar.forward(); break;
				case LEFT: virtualCar.left(); break;
				case RIGHT: virtualCar.right(); break;			
			}
		}
		return virtualCar;
	}
	
	/**
	 * following the expected result
	 * @return y,x
	 */
	public String getPosition() {
		return getYLoc() + "," + getXLoc();
	}
	
	public String displayCar() {
		return "" + this.getSymbol()+this.getDirection().charAt(0);
	}
	
	public String getDirection() {
		return this.direction.toString();
	}
	
}
