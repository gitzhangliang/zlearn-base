package com.zl.extend;

/**
 * @author tzxx
 */
public class Sub extends Super implements Interface {
	public Sub() {
		System.out.println("sub");
	}
	@Override
	public void over(){
		System.out.println("subOver");
	}
	@Override
	public void over1(){
		System.out.println("subOver1");
	}
	public static void main(String[] args) {
		Sub s = new Sub();
		s.over();
		Super super1 = s;
		super1.over1();
		Interface f = (Interface) super1;
		f.print();
		System.out.println(super1 instanceof Sub);
	}
}
