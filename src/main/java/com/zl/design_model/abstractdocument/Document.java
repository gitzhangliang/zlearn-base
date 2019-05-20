package com.zl.design_model.abstractdocument;

import java.util.*;

/**适用性
 *使用抽象文档模式时
 *需要动态添加新属性(动态添加新属性 以 接口形式体现，并给出获取该属性的方法)
 *你想要一种灵活的方式来组织树状结构中的域
 *你想要更松散耦合的系统
 * @author tzxx
 * @date 2019/4/26.
 */
public interface Document {
    void put(String key,Object value);
    Object get(String key);
}
abstract class AbstractDocument implements Document{
    private final Map<String,Object> properties;
    AbstractDocument(Map<String,Object> map){
        this.properties = map;
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key,value);
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }
}

class Cart{
    Collection c;
}

interface HasCart extends Document{
    String cart = "cart";
    default Cart getCart(){
        return ( Cart ) get(cart);
    }
}

interface HasGoods extends Document{
    String goods = "goods";
    default String getGoods(){
        return ( String ) get(goods);
    }
}

interface HasVip extends Document{
    String vip = "vip";
    default Optional<String> getVip(){
        return Optional.ofNullable(( String ) get(vip));
    }
}

class WebShop extends AbstractDocument implements HasCart,HasGoods,HasVip{
    WebShop(Map<String,Object> map){super(map);}

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>(16);
        Cart cart = new Cart();
        List<Object> list = new ArrayList<>();
        list.add("鞋");
        list.add("帽");
        cart.c = list;
        map.put(HasCart.cart,cart);
        map.put(HasGoods.goods,"goods");
        map.put(HasVip.vip,"心悦会员");

        WebShop shop = new WebShop(map);
        shop.getCart().c.forEach(System.out::println);
        System.out.println(shop.getGoods());
        System.out.println(shop.getVip().orElse("hehe"));

    }
}