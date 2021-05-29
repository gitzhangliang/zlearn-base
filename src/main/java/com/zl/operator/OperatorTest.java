package com.zl.operator;

import org.junit.Test;

/**
 * @author zhangliang
 * @date 2020/6/2.
 */
public class OperatorTest {

    @Test
    public void r3(){
        System.out.println(35>>1);
        System.out.println(35>>16);
        System.out.println(35>>19);
        System.out.println(35>>32);
        System.out.println(35>>33);

        System.out.println(35>>>1);
        System.out.println(35>>>16);
        System.out.println(35>>>19);
        System.out.println(35>>>32);
        System.out.println(35>>>33);
    }
}
