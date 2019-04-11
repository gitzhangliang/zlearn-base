package com.zl.enumtest;

/**
 * @author tzxx
 */
public class EnumTest {
	public  void enum1() {
		for (Operation op : Operation.values()) {
			System.out.println(op.apply(2, 4)+"-"+op.ordinal());
		}
	}
	public  void enum2() {
		double x = 2;
		double y = 4;
		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f=%f%n", x,op,y,op.apply(x, y));
		}
	}
	 
}
