package com.zl.design_model.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**责任链模式:使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
 * 将这个对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止
 *
 * 责任链模式不是必须有FilterChain，完全可以在每个filter中设置下一个filter(类似于FilterChain中i++,......)
 * @author tzxx
 * @date 2019/4/28.
 */

public interface Filter {
    void doFilter(String req, String resp,FilterChain chain);
}

class ManagerFilter implements Filter{
    @Override
    public void doFilter(String req, String resp, FilterChain chain) {
        req+="\t领导处理完成\n";
        chain.doFilter(req,resp);

    }
}
class CoderFilter implements Filter{
    @Override
    public void doFilter(String req, String resp, FilterChain chain) {
        req+="\t码农处理完成\n";
        chain.doFilter(req,resp);

    }
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();
    int index = 0;
    void addFilter(Filter filter){
        filters.add(filter);
    }
    void doFilter(String req, String resp){
        if(index == filters.size()){
            System.out.println(req);
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(req,resp,this);
    }
}

class Test{
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.addFilter(new ManagerFilter());
        chain.addFilter(new CoderFilter());
        chain.doFilter("请假结果：\n","");
    }
}


