package com.zl.designmodel.strategymodel;

/**
 * @author tzxx
 */
public class TrainStrategy implements TravelStrategy {

	@Override
	public void go() {
		System.out.println("300km/h");
		
	}

}
