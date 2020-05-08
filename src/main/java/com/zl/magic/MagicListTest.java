package com.zl.magic;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangliang
 * @date 2020/5/7.
 */
public class MagicListTest {
    static List<MagicList> magicLists;
    static {
        magicLists = new ArrayList<>();
        magicLists.add(new MagicList(new BigDecimal("1"),new BigDecimal("11"),111,"1111",1));
        magicLists.add(new MagicList(new BigDecimal("2"),new BigDecimal("22"),222,"2222",2));
    }
    @Test
    public void t1(){

        MagicList magicList = MagicListSupport.mapperSum(MagicList.class,magicLists, MagicList::getAa, MagicList::getBb);
        System.out.println(magicList.getAa());
        System.out.println(magicList.getBb());
    }
    @Test
    public void t11(){
        MagicList magicList = MagicListSupport.mapperSum2(magicLists,MagicList.class, BigDecimal.class, Integer.class);
        System.out.println(magicList.getAa());
        System.out.println(magicList.getBb());
        System.out.println(magicList.getCc());
        System.out.println(magicList.getDd());
        System.out.println(magicList.getEe());
    }

    @Test
    public void t3(){
        List<BigDecimal> aas = magicLists.stream().map(MagicList::getAa).collect(Collectors.toList());
        BigDecimal aSum = CalculateUtil.add(aas);
        List<BigDecimal> bbs = magicLists.stream().map(MagicList::getBb).collect(Collectors.toList());
        BigDecimal bSum = CalculateUtil.add(bbs);
        MagicList magicList = new MagicList();
        magicList.setAa(aSum);
        magicList.setBb(bSum);
        System.out.println(magicList.getAa());
        System.out.println(magicList.getBb());
    }

}
