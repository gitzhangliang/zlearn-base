package com.zl.enumtest;

public enum Operation {
	/**
	 *
	 */
	 加("+") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x+y;
		}
	},减("-") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x-y;
		}
	},乘("*") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x*y;
		}
	},除("/") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x/y;
		}
	};
	private final String symbol;
	
	Operation(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	abstract double apply(double x,double y);
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return symbol;
	}

}
