package com.tutrit.tgbot.example.constants;

public enum ChatBotCommands {
	START("/start"),
	GET_ORDER_STATUS("/getOrderStatus");

	private String command;

	ChatBotCommands(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
