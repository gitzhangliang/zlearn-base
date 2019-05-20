package com.zl.design_model.observermodel;

public class GameFans extends Fans {

	@Override
	public void Update(String message) {
		System.out.println(message);
	}

}