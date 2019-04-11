package com.zl.exception;

/**
 * @author tzxx
 */
public class TestPrintStackTrace {
	public static void f() throws Exception {
		throw new Exception("出问题啦！");
	}

	public static void g() throws Exception {
		f();
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
}