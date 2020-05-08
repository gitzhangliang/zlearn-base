package com.zl.magic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhangliang
 * @date 2020/5/7.
 */
public class MagicListSupport {
    private MagicListSupport(){}
    public static <T> T mapperSum(Class<T> clazz,List<T> list, IFunction<? super T, ? extends BigDecimal>... mappers){
       try{
           List<BigDecimal> data;
           T o = clazz.newInstance();
           for (IFunction<? super T, ? extends BigDecimal> mapper : mappers) {
               data = list.stream().map(mapper).filter(Objects::nonNull).collect(Collectors.toList());
               BigDecimal add = CalculateUtil.add(data);
               String setMethod = setMethod(mapper);
               Method method = clazz.getMethod(setMethod,BigDecimal.class);
               method.invoke(o,add);
           }
           return o;
       }catch (Exception e){
           throw new IllegalArgumentException();
       }

    }
    private static <T> String setMethod(IFunction<? super T, ? extends BigDecimal> func){
        String implMethodName = func.getImplMethodName();
        String substring = implMethodName.substring(3);
        return "set"+substring;
    }

    public static <T,E extends Number> T mapperSum2(List<T> list,Class<T> clazz,Class<?>... tarClasses){
        try{
            List<Class<?>> classes = Arrays.asList(tarClasses);
            Field[] declaredFields = clazz.getDeclaredFields();
            T o = clazz.newInstance();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Class<?> type = declaredField.getType();
                if (classes.contains(type)) {
                    String fieldName = declaredField.getName();
                    fieldName = firstLetterToUpper(fieldName);
                    Method method = clazz.getMethod("get"+fieldName);
                    List<E> data = new ArrayList<>();
                    for (T t : list) {
                        E e = (E)method.invoke(t);
                        data.add(e);
                    }
                    E add = NumberUtil.add(data);
                    String setMethodName =  "set"+fieldName;
                    Method setMethod = clazz.getMethod(setMethodName,type);
                    setMethod.invoke(o,add);
                }
            }
            return o;
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

    }
    private static String firstLetterToUpper(String str){
        char[] array = str.toCharArray();
        array[0] -= 32;
        return String.valueOf(array);
    }
}

