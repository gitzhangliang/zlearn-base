package com.zl.magic;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangliang
 * @date 2020/5/7.
 */
public class NumberUtil {
    private NumberUtil() {
    }

    public static <T extends Number> T add(List<T> numbs) {
        if (numbs == null || numbs.isEmpty()) {
            return null;
        }
        Class<? extends Number> aClass = numbs.get(0).getClass();
        if (isBaseTypePackaging(aClass) || aClass.isPrimitive()) {
            Integer sumInteger = 0;
            Long sumLong = 0L;
            for (T numb : numbs) {
                if (numb == null) {
                    continue;
                }
                if (aClass.isAssignableFrom(Integer.class)) {
                    sumInteger += numb.intValue();
                } else if (aClass.isAssignableFrom(Long.class)) {
                    sumLong += numb.longValue();
                }
            }
            if (aClass.isAssignableFrom(Integer.class)) {
                return ( T ) sumInteger;
            } else if (aClass.isAssignableFrom(Long.class)) {
                return ( T ) sumLong;
            }
            return null;
        } else if (aClass.isAssignableFrom(BigDecimal.class)) {
            BigDecimal count = new BigDecimal("0.00");
            for (T numb : numbs) {
                if (numb == null) {
                    continue;
                }
                BigDecimal num = ( BigDecimal ) numb;
                count = count.add(num);
            }
            return ( T ) count;
        }
        return null;
    }

    /**
     * 是否是基本类型的包装类
     *
     * @param c 对象class类型
     * @return boolean true 是 ,false 否
     */
    private static boolean isBaseTypePackaging(Class c) {
        return c.equals(java.lang.Integer.class) || c.equals(java.lang.Byte.class) || c.equals(java.lang.Long.class) || c.equals(java.lang.Double.class) || c.equals(java.lang.Float.class) || c.equals(java.lang.Character.class) || c.equals(java.lang.Short.class) || c.equals(java.lang.Boolean.class);
    }
}
