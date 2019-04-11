package com.zl.designmodel.strategymodel;

/**策略模式
 * @author tzxx
 */
public class Test {

	public static void main(String[] args) {
		Travel travel  = new Travel();
		travel.setStrategy(new AirPlanelStrategy());
		travel.travel();
		travel.setStrategy(new BicycleStrategy());
		travel.travel();
		travel.setStrategy(new TrainStrategy());
		travel.travel();
	}

}
