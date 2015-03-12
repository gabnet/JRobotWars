package tests;

import static org.junit.Assert.*;
import game.Act;
import game.RadioConsole;

import org.junit.Test;

import utils.Status;

public class RadioConsoleTest {

	Mocks.objects.Robot mockRobot;
	
	public RadioConsoleTest(){
		
		mockRobot = new Mocks.objects.Robot();
	}
	
	@Test
	public void SendOkTestOnForward(){
		
		mockRobot.Stub("Forward", Status.Ok);
		
		assertEquals(RadioConsole.SendCommand(Act.M, mockRobot), true);
	}
	
	@Test
	public void SendKoTestOnForward(){
		
		mockRobot.Stub("Forward", Status.Failed);
		
		assertEquals(RadioConsole.SendCommand(Act.M, mockRobot), false);
	}
}