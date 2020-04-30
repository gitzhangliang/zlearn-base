package com.zl.design_model.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @date 2020/4/21.
 */
public class PeopleProxy implements InvocationHandler {
     Map<String,Op> map = new HashMap<>();
    PeopleProxy(){
        map.put("run",new Run());
        map.put("talk",new Talk());
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         map.get(method.getName()).op();
        return null;
    }
    interface Op{
      void op();
    }
    class Run implements Op{
        @Override
        public void op(){
            System.out.println("run");
        }
    }
    class Talk implements Op{
        @Override
        public void op(){
            System.out.println("talk");
        }
    }
}
