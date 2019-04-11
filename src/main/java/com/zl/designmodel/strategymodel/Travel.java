package com.zl.designmodel.strategymodel;

/**
 * @author tzxx
 */
public class Travel {
	private TravelStrategy strategy;

	public TravelStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(TravelStrategy strategy) {
		this.strategy = strategy;
	}

	public void travel() {
		strategy.go();
	}
}
