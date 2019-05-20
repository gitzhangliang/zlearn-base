package com.zl.design_model.statusmodel;

public class Trafficlight {
	private LightColor color;
	
	public Trafficlight() {
		// TODO Auto-generated constructor stub
	}
	public LightColor getColor() {
		return color;
	}

	public void setColor(LightColor color) {
		this.color = color;
	}

	public void whetherTraffic() {
		color.whetherTraffic(this);
	}

}
