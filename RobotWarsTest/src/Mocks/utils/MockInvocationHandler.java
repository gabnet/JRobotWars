package Mocks.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MockInvocationHandler implements InvocationHandler {
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return invoke((Mock)proxy, method, args);
	}
		
	private Object invoke(Mock mock, Method method, Object[] args) throws Throwable {
		
		return mock.Get(method.getName());
	}
}