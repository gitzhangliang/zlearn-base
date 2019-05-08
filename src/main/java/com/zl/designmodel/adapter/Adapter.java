package com.zl.designmodel.adapter;

/**适配器模式
 * 适配器模式的核心角色，其它两个角色都是已经存在的角色，而适配器角色是需要新建立的，
 * 它的职责非常简单，把源角色转换成目标角色，怎么转换?通过继承或类关联的方式
 * @author tzxx
 * @date 2019/4/30.
 */
public class Adapter implements V110 {
    private V220 v220;
    Adapter(){
        v220 = new V220();
    }
    @Override
    public void work(){
        v220.work();
    }

}

/**
 * 目标接口 该角色定义把其它类转换为何种接口，也就是我们的期望接口
 */

interface V110{
    void work();
}
/**
 * 需要被适配 你想把谁转换成目标角色
 */
class V220{
    void work(){
        System.out.println("220v");
    }
}

class Client{
    public static void main(String[] args) {
        V110 v110 = new Adapter();
        v110.work();
    }

}

