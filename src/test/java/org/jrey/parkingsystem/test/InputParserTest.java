package org.jrey.parkingsystem.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jrey.parkingsystem.Command;
import org.jrey.parkingsystem.InputParser;
import org.junit.Test;

public class InputParserTest {
	
	@Test
	public void testParser1() {
		String input = "5,5:RFLFRFLF";		
		InputParser parser = new InputParser(input);
		
		assertThat(parser.getXPos()).isEqualTo(5);
		assertThat(parser.getYPos()).isEqualTo(5);
		
		List<Command> commands = new ArrayList<>();
		commands.add(Command.RIGHT);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		commands.add(Command.RIGHT);
		commands.add(Command.FORWARD);
		commands.add(Command.LEFT);
		commands.add(Command.FORWARD);
		
		assertThat(parser.getCommands()).containsExactlyElementsOf(commands);
	}
	
	@Test
	public void testParser2() {
		String input = "6,6:FFLFFLFFLFF";		
		InputParser parser = new InputParser(input);
		
		assertThat(parser.getXPos()).isEqualTo(6);
		assertThat(parser.getYPos()).isEqualTo(6);
		
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
		
		assertThat(parser.getCommands()).containsExactlyElementsOf(commands);
	}
	
	@Test
	public void testParser3() {
		String input = "5,5:FLFLFFRFFF";		
		InputParser parser = new InputParser(input);
		
		assertThat(parser.getXPos()).isEqualTo(5);
		assertThat(parser.getYPos()).isEqualTo(5);
		
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
		
		assertThat(parser.getCommands()).containsExactlyElementsOf(commands);
	}
	

}
