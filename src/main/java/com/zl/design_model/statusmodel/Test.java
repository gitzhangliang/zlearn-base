package com.zl.design_model.statusmodel;

/**状态模式
 * 在以下任一情况下使用状态模式

 * 1 对象的行为取决于其状态，并且必须根据该状态在运行时更改其行为
 * 2 操作具有依赖于对象状态的大型多部分条件语句。此状态通常由一个或多个枚举常量表示。
 *通常，几个操作将包含相同的条件结构。State模式将条件的每个分支放在一个单独的类中。
 *这使您可以将对象的状态视为一个对象，它可以独立于其他对象而变化。
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
