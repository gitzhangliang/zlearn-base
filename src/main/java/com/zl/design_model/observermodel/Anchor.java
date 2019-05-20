package com.zl.design_model.observermodel;

import java.util.ArrayList;
import java.util.List;

public abstract class Anchor {
	private List<Fans> fansList = new ArrayList<>();
	
	public void addFans(Fans fans){
		fansList.add(fans);
	}
	
	public void removeFans(Fans fans){
		fansList.remove(fans);
	}
	
	public void notifyFans(String message){
		for (Fans fans : fansList) {
			fans.Update(message);
		}
	}

	public List<Fans> getFansList() {
		return fansList;
	}

	public void setFansList(List<Fans> fansList) {
		this.fansList = fansList;
	}
	
}
