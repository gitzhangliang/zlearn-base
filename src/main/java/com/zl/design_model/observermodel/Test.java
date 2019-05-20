package com.zl.design_model.observermodel;

/**观察者模式
 * @author tzxx
 */
public class Test {

	public static void main(String[] args) {
		GameFans fan1 = new GameFans();
		GameFans fan2 = new GameFans();
		GameAnchor ga = new GameAnchor();
		ga.addFans(fan1);
		ga.addFans(fan2);
		ga.startLive("开始直播啦");
		ga.removeFans(fan2);
		ga.startLive("我来了");

	}

}
