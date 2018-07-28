package com.example.message.library;

public class SpecificCommand extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222511927607755235L;
	String commandSpecificId;

	public void setCommandSpecificId(String commandSpecificId) {
		this.commandSpecificId = commandSpecificId;
	}

	public String getCommandSpecificId() {
		return commandSpecificId;
	}
}
