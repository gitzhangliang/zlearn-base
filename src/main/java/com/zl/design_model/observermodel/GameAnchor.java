package com.zl.design_model.observermodel;

public class GameAnchor extends Anchor {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void startLive(String message) {
		notifyFans(message);;		
	}

}
