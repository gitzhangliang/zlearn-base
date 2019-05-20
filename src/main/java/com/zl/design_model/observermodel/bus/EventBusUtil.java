package com.zl.design_model.observermodel.bus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * @author tzxx
 */
public class EventBusUtil {

	private static EventBusUtil bus = new EventBusUtil();
	
	public static EventBusUtil getBus() {
		return bus;
	}
	
	private final EventBus eventBus;
	private static final ThreadLocal<Throwable> exceptionLocal = new ThreadLocal<>();
	
	private EventBusUtil() {
		eventBus = new EventBus(new SubscriberExceptionHandler() {
			
			@Override
			public void handleException(Throwable exception, SubscriberExceptionContext context) {
				// TODO Auto-generated method stub
				exceptionLocal.set(exception);
			}
		});
	}
	
	public<T> void register(T listener) {
		eventBus.register(listener);
	}
	
	public<T> void unregister(T listener) {
		eventBus.unregister(listener);
	}
	
	public<T> void post(T event) {
		eventBus.post(event);
		if(exceptionLocal.get() != null) {
			exceptionLocal.get().printStackTrace();
			throw new RuntimeException(exceptionLocal.get()); 
		}
	}
	
	public static void main(String[] args) {
		EventBusUtil.getBus().register(new Object() {
			@Subscribe
			public void handle(String param) {
				System.out.println("String: "+param);
			}
			
			@Subscribe
			public void handle(Integer param) {
				System.out.println("Integer: "+param);
			}
		});
		EventBusUtil.getBus().post("Sth happened!");
		EventBusUtil.getBus().post(1);
	}
}
