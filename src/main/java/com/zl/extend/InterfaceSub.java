package com.zl.extend;

/**
 * @author tzxx
 */
public class InterfaceSub implements Interface {
	private final int a=2;
	public static void main(String[] args) {
		InterfaceSub s = new InterfaceSub();
		System.out.println(s.a);
		s.print();
	}
}
