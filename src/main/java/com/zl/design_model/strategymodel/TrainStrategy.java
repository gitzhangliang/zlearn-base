package com.zl.design_model.strategymodel;

/**
 * @author tzxx
 */
public class TrainStrategy implements TravelStrategy {

	@Override
	public void go() {
		System.out.println("300km/h");
		
	}

}
