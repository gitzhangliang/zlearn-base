package com.zl.lambda;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Test1 {
	
	
    public  void main1() {
		int num =1;
    	Converter<String, Integer> converter = (from) -> Integer.valueOf(from+num);
    	Integer converted = converter.convert("123");
    	System.out.println(converted);    // 123
	}
	
    public  void main2() {
		Add i = (a,b)->a+b;
		Add i1 = (a,b)->a-b;
    	System.out.println(i.add(3, 4));
    	System.out.println(i1.add(3, 4));// 123
    	System.out.println(i.add(3, 4));
	}
	
    public  void main3() {
		Add i = (a,b)->a+b;
		Add i1 = (a,b)->a-b;
		validate((a,b)->a-b);
    	System.out.println(i.add(3, 4));
    	System.out.println(i1.add(3, 4));// 123
	}
	private void validate(Add add){
		System.out.println(add.add(3, 4));
	}
	
    public void main4(){
    	String[] atp = {"Rafael Nadal", "Novak Djokovic",  
    		       "Stanislas Wawrinka",  
    		       "David Ferrer","Roger Federer",  
    		       "Andy Murray","Tomas Berdych",  
    		       "Juan Martin Del Potro"};  
    		List<String> players =  Arrays.asList(atp);  
    		  
    		// 以前的循环方式  
//    		for (String player : players) {  
//    		     System.out.print(player + "; ");  
//    		}  
//    		  
//    		// 使用 lambda 表达式以及函数操作(functional operation)  
//    		players.forEach((player) -> System.out.print(player + "; "));  
    		   
    		// 在 Java 8 中使用双冒号操作符(double colon operator)  
    		players.forEach(System.out::println);
    }
	
	public void Predicate(){
		Predicate<String> predicate = (s) -> s.length() > 0;
		 
		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false
		 
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		 
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}
	
	public void function(){
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		 
		backToString.apply("123");
	}
	
	public void consumer(){
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
	}
	
	public void filter(){
	List<String> stringCollection = new ArrayList<>();
	stringCollection.add("ddd2");
	stringCollection.add("aaa2");
	stringCollection.add("bbb1");
	stringCollection.add("aaa1");
	stringCollection.add("bbb3");
	stringCollection.add("ccc");
	stringCollection.add("bbb2");
	stringCollection.add("ddd1");
	stringCollection = stringCollection
    .stream()
    .filter((s) -> s.startsWith("a")).collect(Collectors.toList());
	System.out.println(stringCollection.size()+"++");

	}
	
	public void maps(){
		Map<Integer, String> map = new HashMap<>();
		 
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, val) -> System.out.println(id+"--"+val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33
		 
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false
		 
		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true
		 
		map.computeIfAbsent(3, num -> "bam");
		map.get(3);
		
	}
	
	public void time(){
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println(millis);
		System.out.println(System.currentTimeMillis());
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant); 
		System.out.println(legacyDate);
		
		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids
		 
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		 
		System.out.println(now1.isBefore(now2));  // false
		 
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		 
		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239
		
		DateTimeFormatter germanFormatter =
			    DateTimeFormatter
			        .ofLocalizedDate(FormatStyle.MEDIUM)
			        .withLocale(Locale.GERMAN);
			 
			LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
			System.out.println(xmas); 
	}
	
	
	public void filterewr(){

	List<String> stringCollection = new ArrayList<>();
	stringCollection.add("ddd2");
	stringCollection.add("aaa2");
	List<String> stringCollection1 = new ArrayList<>();
	stringCollection1.add("ddd2");
	stringCollection1.add("aaa2");
	List<String> stringCollection2 = new ArrayList<>();
	stringCollection2.add("ddd2");
	stringCollection2.add("aaa22");
	System.out.println(stringCollection.containsAll(stringCollection));
	System.out.println(stringCollection.containsAll(stringCollection1));
	System.out.println(stringCollection.containsAll(stringCollection2));
	}


	
}
