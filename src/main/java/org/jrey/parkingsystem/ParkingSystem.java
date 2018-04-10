package org.jrey.parkingsystem;

public class ParkingSystem {
	ParkingSlot[][] slot = new ParkingSlot[15][15];
	
	public ParkingSystem() {
		for(int x=0;x<slot.length;x++) {
			for(int y=0;y<slot[0].length;y++) {
				slot[x][y] = new ParkingSlot();
			}
		}
	}
	
	public void display() {
		for(int y=slot[0].length-1; y>=0; y--) {
			if(y+1<10) {
				System.out.print(" ");
			}
			System.out.print(y+1);
			for(int x=0;x<slot.length;x++) {
				System.out.print("|");
				System.out.print(slot[x][y].viewSlot());
			}
			System.out.println("|");
			
			
		}
		System.out.print("  ");
		for(int x=0;x<slot.length;x++) {
			System.out.print(" ");
			System.out.print(x+1);
			if(x+1<10) {
				System.out.print(" ");
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public void placeCar(Car car) {
		slot[car.getXLoc()-1][car.getYLoc()-1].setCar(car);
	}
	
	public String viewSlot(int y, int x) {
		return slot[x-1][y-1].viewSlot();
	}
	
	public static void main(String[] args) {
		String input = "5,5:FLFLFFRFFF";		
		InputParser parser = new InputParser(input);
		ParkingSystem ps = new ParkingSystem();
		
		Car orig = new Car(parser.getXPos(),parser.getYPos());
		orig.setSymbol('o');
		ps.placeCar(orig);
		
		Car fnCar = orig.calculateFinalPosition(orig.getXLoc(), orig.getYLoc(), parser.getCommands());
		fnCar.setSymbol('f');
		ps.placeCar(fnCar);
		
		
		ps.display();
	}
}
