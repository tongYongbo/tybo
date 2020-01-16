package com.wn.version;

import java.io.Serializable;

public class Info implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sender;
	private String message;

	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Info(String sender, String message) {
		super();
		this.sender = sender;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Info [sender=" + sender + ", message=" + message + "]";
	}

}
