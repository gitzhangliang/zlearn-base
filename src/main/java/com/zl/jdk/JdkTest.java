package com.zl.jdk;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


public class JdkTest {
	private static final Random random = new Random();
	public void math(){
		int maxInt = 4;
		System.out.println(Math.abs(random.nextInt())%maxInt);
	}
	public void math2(){
		int n = 2*(Integer.MAX_VALUE/3);
		int low = 0;
		for(int i = 0;i<1000000;i++){
			if(randoms(n)<(n/2)){
				low++;
			}
		}
		System.out.println(low);
		
	}
	
	public static int randoms(int n){
		return Math.abs(random.nextInt())%n;
	}
	public void math3(){
		int maxInt = 4;
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE)%maxInt);
	}
	public void math4(){
		int maxInt = 4;
		System.out.println(random.nextInt(maxInt));
	}
	public void map(){
		Map<String, String> m = new LinkedHashMap<>();
		m.put("/home/**", null);
		m.put("/**", null);
		m.put("/a", null);
		m.forEach((k,v)->System.out.println(k+":"+v));
	}
}
