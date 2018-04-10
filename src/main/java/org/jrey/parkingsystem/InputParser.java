package org.jrey.parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	private String input;
	private int xPos;
	private int yPos;
	private List<Command> commands;
	
	public String getInput() {
		return input;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public InputParser(String input) {
		this.input = input;
		
		String[] posComms = this.input.split(":");
		
		String[] positions = posComms[0].split(",");
		this.xPos = Integer.parseInt(positions[0]);
		this.yPos = Integer.parseInt(positions[1]);
		
		String comms = posComms[1];
		commands = new ArrayList<Command>();
		for(int i=0;i<comms.length();i++) {
			switch(comms.charAt(i)) {
				case 'R' : commands.add(Command.RIGHT); break;
				case 'L' : commands.add(Command.LEFT); break;
				case 'F' : commands.add(Command.FORWARD); break;
			}
		}
	}
	
}
