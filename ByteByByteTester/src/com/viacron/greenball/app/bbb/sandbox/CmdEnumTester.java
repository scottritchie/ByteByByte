package com.viacron.greenball.app.bbb.sandbox;

import java.util.HashMap;
import java.util.Map;

interface Command {
	void runCommand();
}

public class CmdEnumTester {

	private enum CmdEnum {
		CMD1(0, new Command() {public void runCommand() {}});
		
		int id;
		Command cmd;
		
		CmdEnum(int id, Command cmd) {
			this.id = id;
			this.cmd = cmd;
		}
		
		public Command getCmd() {
			return this.getCmd();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Map<Character, Command> methodMap = new HashMap<Character, Command>();

		methodMap.put('h', new Command() {
			public void runCommand() {
				System.out.println("help");
			};
		});

		methodMap.put('t', new Command() {
			public void runCommand() {
				System.out.println("teleport");
			};
		});

		char cmd = 'h';
		methodMap.get(cmd).runCommand(); // prints "Help"

		cmd = 't';
		methodMap.get(cmd).runCommand(); // prints "teleport"
		

	}
}