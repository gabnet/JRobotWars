package Mocks.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockTest {

	private Mock mock;
	
	public MockTest(){
		mock = new Mock();
	}
	
	@Test
	public void InsertStubString(){
		mock.Stub("pippo", "bella storia");
		
		assertEquals(mock.Get("pippo"), "bella storia");
		assertEquals(mock.Get("pippo").getClass(), String.class);
	}
	
	@Test
	public void InsertStubBool(){
		mock.Stub("pippo1", false);
		
		assertEquals(mock.Get("pippo1"), false);
		assertEquals(mock.Get("pippo1").getClass(), Boolean.class);
	}
}