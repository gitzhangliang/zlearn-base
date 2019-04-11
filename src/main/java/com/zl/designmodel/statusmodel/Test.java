package com.zl.designmodel.statusmodel;

/**状态模式
 * @author tzxx
 */
public class Test {
	public static void main(String[] args) {
		Trafficlight trafficlight = new Trafficlight();
		trafficlight.setColor(new RedLight());
		trafficlight.whetherTraffic();
		trafficlight.whetherTraffic();
		trafficlight.whetherTraffic();
		trafficlight.whetherTraffic();

	}
}
