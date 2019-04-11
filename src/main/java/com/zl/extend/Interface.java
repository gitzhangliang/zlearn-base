package com.zl.extend;

/**
 * @author tzxx
 */
public interface Interface {
	int a=1;

	/**
	 * print
	 */
	default void print(){
		System.out.println(a);
	}
}
