package Mocks.utils;

import java.util.HashMap;
import java.util.Map;

public class Mock {
	
	public void Stub(String methodName, Object result){
		getMockResultMap().put(methodName, result);
	}
	
	public <T> T Get(String methodName){
		
		if (!mockResultMap.containsKey(methodName))
			return null;
		
		try {
			@SuppressWarnings("unchecked")
			T casted = (T) mockResultMap.get(methodName);
			
			return casted;
		}
		catch (Exception e){
			return null;
		}
	}
	
	private Map<String, Object> mockResultMap;

	private Map<String, Object> getMockResultMap() {
		if (mockResultMap == null)
			mockResultMap = new HashMap<String, Object>();
		
		return mockResultMap;
	}
}
