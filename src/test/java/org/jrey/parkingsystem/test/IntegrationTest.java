package org.jrey.parkingsystem.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.jrey.parkingsystem.Car;
import org.jrey.parkingsystem.InputParser;
import org.jrey.parkingsystem.ParkingSystem;
import org.junit.Test;

public class IntegrationTest {
	@Test
	public void testCase1() {
		String input = "5,5:RFLFRFLF";		
		InputParser parser = new InputParser(input);
		ParkingSystem ps = new ParkingSystem();
		
		Car orig = new Car(parser.getXPos(),parser.getYPos());
		
		Car fnCar = orig.calculateFinalPosition(orig.getXLoc(), orig.getYLoc(), parser.getCommands());
		fnCar.setSymbol('f');
		ps.placeCar(fnCar);
		
		assertThat(fnCar.getPosition()).isEqualTo("7,7");
		
		ps.display();
	}
	
	@Test
	public void testCase2() {
		String input = "6,6:FFLFFLFFLFF";		
		InputParser parser = new InputParser(input);
		ParkingSystem ps = new ParkingSystem();
		
		Car orig = new Car(parser.getXPos(),parser.getYPos());
		
		Car fnCar = orig.calculateFinalPosition(orig.getXLoc(), orig.getYLoc(), parser.getCommands());
		fnCar.setSymbol('f');
		ps.placeCar(fnCar);
		
		assertThat(fnCar.getPosition()).isEqualTo("6,6");
		
		ps.display();
	}
	
	@Test
	public void testCase3() {
		String input = "5,5:FLFLFFRFFF";		
		InputParser parser = new InputParser(input);
		ParkingSystem ps = new ParkingSystem();
		
		Car orig = new Car(parser.getXPos(),parser.getYPos());
		
		Car fnCar = orig.calculateFinalPosition(orig.getXLoc(), orig.getYLoc(), parser.getCommands());
		fnCar.setSymbol('f');
		ps.placeCar(fnCar);
		
		assertThat(fnCar.getPosition()).isEqualTo("4,1");
		
		ps.display();
	}

}
