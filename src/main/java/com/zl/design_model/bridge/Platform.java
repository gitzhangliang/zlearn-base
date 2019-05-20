package com.zl.design_model.bridge;

/**桥接模式：用于把抽象部分与实现部分解耦，使得二者可以独立变化
 * 解释：实现系统可能有多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来让他们独立变化，减少他们之间的耦合
 * 类比本例：手机可以按照【操作系统】分类，也可以按照【手机品牌】分类，将这两者分离，减少耦合
 * @author tzxx
 * @date 2019/4/30.
 */
public interface Platform {
    void execute();
}

class AndroidPlatform implements Platform{
    @Override
    public void execute() {
        System.out.println("i am android");
    }
}

class IosPlatform implements Platform{
    @Override
    public void execute() {
        System.out.println("i am ios");
    }
}

abstract class PhoneBrand{
    protected Platform platform;
    public PhoneBrand(Platform platform){
        this.platform = platform;
    }
    abstract void run();
}

class HuaWei extends PhoneBrand{

    public HuaWei(Platform platform) {
        super(platform);
    }

    @Override
    void run() {
        platform.execute();
    }
}

class Iphone extends PhoneBrand{

    public Iphone(Platform platform) {
        super(platform);
    }

    @Override
    void run() {
        platform.execute();
    }
}

class Client{
    public static void main(String[] args) {
        HuaWei huaWei = new HuaWei(new AndroidPlatform());
        Iphone iphone = new Iphone(new IosPlatform());
        huaWei.run();
        iphone.run();
    }
}
