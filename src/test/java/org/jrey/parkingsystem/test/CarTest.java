package org.jrey.parkingsystem.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jrey.parkingsystem.Car;
import org.jrey.parkingsystem.Command;
import org.junit.Test;

public class CarTest {
	
	@Test
	public void testCarMovement() {
		Car car = new Car(5,5);
		
		assertThat(car.getPosition()).isEqualTo("5,5");
		
		car.right();
		assertThat(car.getDirection()).isEqualTo("EAST");
		assertThat(car.getPosition()).isEqualTo("5,5");
		
		car.forward();
		assertThat(car.getPosition()).isEqualTo("5,6");
		
		car.left();
		assertThat(car.getDirection()).isEqualTo("NORTH");
		assertThat(car.getPosition()).isEqualTo("5,6");
		
		car.forward();
		assertThat(car.getPosition()).isEqualTo("6,6");
		
	}
	
	@Test
	public void testCarFinalPosition1() {
		Car car = new Car();
		List<Command> commands = new ArrayList<>();
		commands.add(Command.RIGHT);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.RIGHT);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		
		Car fnCar = car.calculateFinalPosition(5, 5, commands);
		assertThat(fnCar.getPosition()).isEqualTo("7,7");
	}
	
	@Test
	public void testCarFinalPosition2() {
		Car car = new Car();
		List<Command> commands = new ArrayList<>();
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		
		Car fnCar = car.calculateFinalPosition(6, 6, commands);
		assertThat(fnCar.getPosition()).isEqualTo("6,6");
	}
	
	@Test
	public void testCarFinalPosition3() {
		Car car = new Car();
		List<Command> commands = new ArrayList<>();
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		commands.add(Command.RIGHT);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		commands.add(Command.FORWARD);
		
		Car fnCar = car.calculateFinalPosition(5, 5, commands);
		assertThat(fnCar.getPosition()).isEqualTo("4,1");
	}

}
