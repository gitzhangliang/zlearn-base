package com.zl.designmodel.statusmodel;

public class RedLight implements LightColor {

	@Override
	public void whetherTraffic(Trafficlight trafficlight) {
		System.out.println("不可通行");
		System.out.println("60秒过去了");
		trafficlight.setColor(new GreenLight());
		
	}

}
