package com.zl.lambda;

import java.util.function.Function;

public class Something<F> {
	 F s;

	public Something() {
	}

	public Something(F s) {
		this.s = s;
	}

	public F getS() {
		return s;
	}

	public void setS(F s) {
		this.s = s;
	}

	public String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
    public static void main(String[] args) {
    	Something<String> something = new Something("qwe");
    	something.aVoid1(something::startsWith);
//    	Converter<String, String> converter = something::startsWith;
//    	String converted = converter.convert("Java");
//    	System.out.println(converted);
	}

	public <T>void aVoid(Converter<F,T> c){
		System.out.println(c.convert(this.getS()));
	}
	public <T>void aVoid1(Function<F,T> c){
		System.out.println(c.apply(s));
	}
}