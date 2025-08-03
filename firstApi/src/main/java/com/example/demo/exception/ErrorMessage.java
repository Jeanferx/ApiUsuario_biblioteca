package com.example.demo.exception;

import java.util.List;

public class ErrorMessage {
	private List<String> messages;

	public ErrorMessage() {
	}
	
	public ErrorMessage(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
}
