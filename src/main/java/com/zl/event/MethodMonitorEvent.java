package com.zl.event;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tzxx
 * @date 2019/4/10.
 */
public class MethodMonitorEvent extends EventObject {
    long timestamp;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodMonitorEvent(Object source) {
        super(source);
        System.out.println("hahhahaha");
    }
}
interface MethodMonitorEventListener extends EventListener{
    void onMethodBegin(MethodMonitorEvent event);
    void onMethodEnd(MethodMonitorEvent event);
}

class MethodMonitorEventListenerImpl implements MethodMonitorEventListener{
    @Override
    public void onMethodBegin(MethodMonitorEvent event) {
        event.timestamp = System.currentTimeMillis();
        System.out.println("开始时间:"+ event.timestamp);

    }

    @Override
    public void onMethodEnd(MethodMonitorEvent event) {
        long duration  = System.currentTimeMillis() - event.timestamp;
        System.out.println("耗时:"+duration);
    }
}

class MethodMonitorEventPublisher{
    private List<MethodMonitorEventListener> listeners = new ArrayList<>();

    public void methodMonitor() throws InterruptedException {
        MethodMonitorEvent event = new MethodMonitorEvent(this);
        publishEvent("begin",event);
        TimeUnit.SECONDS.sleep(5);
        publishEvent("end",event);

    }

    private void publishEvent(String status, MethodMonitorEvent event) {
        List<MethodMonitorEventListener> copyListeners = new ArrayList<>(listeners);
        for (MethodMonitorEventListener listener : copyListeners) {
            if("begin".equals(status)){
                listener.onMethodBegin(event);
            }else {
                listener.onMethodEnd(event);
            }
        }

    }

    public void addEventListener(MethodMonitorEventListenerImpl methodMonitorEventListener) {
        listeners.add(methodMonitorEventListener);
    }
}
class Test{
    public static void main(String[] args) throws InterruptedException {
        MethodMonitorEventPublisher publisher = new MethodMonitorEventPublisher();
        publisher.addEventListener(new MethodMonitorEventListenerImpl());
        publisher.methodMonitor();
    }
}
