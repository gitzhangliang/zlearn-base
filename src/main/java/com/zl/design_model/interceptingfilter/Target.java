package com.zl.design_model.interceptingfilter;

public class Target {
   public void execute(String request){
      System.out.println("Executing request: " + request);
   }
}