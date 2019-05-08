package com.zl.lambda;

public interface Add {
	int add(int a, int b);
}
class Q{
	 String name;

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Q q = new Q();
		q.setName("1");
		System.out.println(q.name);
	}
}