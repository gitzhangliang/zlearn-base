package com.zl.innerclass.anonymity;
/**
 * @author tzxx
 */
public class Outer3 {
	Inner inner = new Inner("Inner", "gz") {
		
		@Override
		String getName() {
			// TODO Auto-generated method stub
			return "a";
		}
	};
	Inner inner2 = new Inner("Inner", "gz") {
		
		@Override
		String getName() {
			// TODO Auto-generated method stub
			return "b";
		}
	};
    @SuppressWarnings("unused")
	public static void main(String[] args) { 
        Outer3 outer = new Outer3(); 
    } 
 

} 
 
abstract class Inner1 { 
    Inner1(String name, String city) { 
        System.out.println(city); 
    } 
 
    abstract String getName(); 
    public void print(){
    	System.out.println(getName());
    }
} 