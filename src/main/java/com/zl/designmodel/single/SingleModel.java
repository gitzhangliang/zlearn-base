package com.zl.designmodel.single;

/**
 * @author tzxx
 * @date 2019/3/29.
 */
public class SingleModel {
    private volatile static SingleModel singleModel = null;
    private SingleModel(){
    }
    public static SingleModel getInstance(){
        if(singleModel == null){
            synchronized (SingleModel.class){
                if(singleModel == null){
                    singleModel =  new SingleModel();
                }
            }
        }
        return singleModel;
    }

//    private static class SingleModelInner{
//        private static SingleModel singleModel = new SingleModel();
//    }
//
//    public static SingleModel getInstance1(){
//        return SingleModelInner.singleModel;
//    }
}


