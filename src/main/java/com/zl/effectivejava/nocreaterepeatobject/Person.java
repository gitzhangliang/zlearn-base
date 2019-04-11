package com.zl.effectivejava.nocreaterepeatobject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author tzxx
 */

public enum Person {
	//
	INSTANCE;
	private final Date birthDate = new Date();
	public void isBabyBoomer(){
		Calendar calendar =Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2017, 3, 31, 10, 15, 30);
		Date boomerStart = calendar.getTime();
		calendar.set(2019, 4, 3, 14, 13, 20);
		Date boomerEnd = calendar.getTime();
		boolean b = birthDate.compareTo(boomerStart)>=0 && birthDate.compareTo(boomerEnd)<0;
		System.out.println(b);
	}
	public static void main(String[] args) {
		Person.INSTANCE.isBabyBoomer();
	}
	
}
