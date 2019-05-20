package com.zl.design_model.statusmodel;

public class GreenLight implements LightColor{

	@Override
	public void whetherTraffic(Trafficlight trafficlight) {
		System.out.println("可通行");
		System.out.println("60秒过去了");
		trafficlight.setColor(new RedLight());		
	}

}
