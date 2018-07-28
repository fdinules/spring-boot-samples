package com.example.message.library;

import java.io.Serializable;

public class Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5726842115017424500L;
	String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
