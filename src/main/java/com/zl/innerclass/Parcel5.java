package com.zl.innerclass;
/**局部内部类 定义在作用域内
 * @author tzxx
 */

public class Parcel5 {
    private void internalTracking(boolean b) { 
        if (b) { 
            class TrackingSlip { 
                private String id; 
                TrackingSlip(String s) { 
                    id = s; 
                } 
                String getSlip() { 
                    return id; 
                } 
            } 
            TrackingSlip ts = new TrackingSlip("slip"); 
            @SuppressWarnings("unused")
			String s = ts.getSlip(); 
        } 
    } 
 
    public void track() { 
        internalTracking(true); 
    } 
 
    public static void main(String[] args) { 
        Parcel5 p = new Parcel5(); 
        p.track(); 
    } 
} 