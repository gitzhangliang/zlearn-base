package com.zl.exception;

/**
 * @author tzxx
 */
public class Test {
	public static void f(){
		int i = 5/0;
		System.out.println(i);
	}

	public static void h(){
			f();

	}
	public static void g(){
		h();
		System.out.println(111);


	}

	public static void main(String[] args) {
		g();
		System.out.println(222);
	}
}
