package org.jrey.parkingsystem;

public class ParkingSlot {
	private Car car;
	
	public void setCar(Car car) {
		this.car = car;
	}

	public String viewSlot() {
		if(isEmpty()) {
			return "__";
		} else {
			return car.displayCar();
		}
	}
	
	public void clear() {
		this.car = null;
	}
	
	public boolean isEmpty() {
		return car==null;
	}
}
