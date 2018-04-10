package org.jrey.parkingsystem.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.jrey.parkingsystem.Car;
import org.jrey.parkingsystem.ParkingSystem;
import org.junit.Test;

public class ParkingSystemTest {
	@Test
	public void testParkingSystem() {
		ParkingSystem ps = new ParkingSystem();
		Car tc = new Car(10,14);
		tc.setSymbol('t');
		ps.placeCar(tc);
		
		assertThat(ps.viewSlot(14, 10)).isEqualTo("tN");
		
		Car uc = new Car(1,8);
		uc.setSymbol('u');
		ps.placeCar(uc);
		
		assertThat(ps.viewSlot(8, 1)).isEqualTo("uN");
		
		ps.display();
	}

}
