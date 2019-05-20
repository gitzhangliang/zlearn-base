package com.zl.design_model.strategymodel;

/**
 * @author tzxx
 */
public class BicycleStrategy implements TravelStrategy {

	@Override
	public void go() {
		System.out.println("30km/h");
		
	}

}
