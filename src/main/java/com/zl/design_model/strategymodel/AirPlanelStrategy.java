package com.zl.design_model.strategymodel;

/**
 * @author tzxx
 */
public class AirPlanelStrategy implements TravelStrategy {

	@Override
	public void go() {
		System.out.println("800km/h");
		
	}

}
