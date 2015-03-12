package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import robot.PortableRobot;
import robot.Abstract.IPortableRobot;
import utils.Playground;
import utils.Position;
import utils.Abstract.IPlayground;
import utils.Abstract.IPosition;

public class PlaygroundTest {

	IPlayground sut;
	
	public PlaygroundTest(){
		sut = new Playground(5, 5);
	}
	
	@Test
	public void CheckOkOnBounds(){
		
		IPosition testOkPosition = new Position(3, 4);
		
		assertEquals(sut.CheckBounds(testOkPosition), true);
	}
	
	@Test
	public void CheckKOOnBounds(){
		
		IPosition testKOPosition = new Position(10, 10);
		
		assertEquals(sut.CheckBounds(testKOPosition), false);
	}
	
	@Test
	public void FixBounds(){
		IPosition testKOPosition = new Position(10, 10);
		
		IPosition fixedPosition = sut.FixBounds(testKOPosition);
		
		assertEquals(fixedPosition.GetX(), 5);
		assertEquals(fixedPosition.GetY(), 5);
	}
	
	@Test
	public void CheckRobotsOk(){
		
		IPortableRobot robotTest = new PortableRobot(0, new Position(0, 0));
		
		robotTest.SetId(1);
		robotTest.SetPosition(new Position(3,3));
		
		sut.RegisterRobot(robotTest);
		
		IPosition newPosition = new Position(2,2);
		
		assertEquals(sut.CheckRobots(newPosition), true);
	}
	
	@Test
	public void CheckRobotsOK(){
		IPortableRobot robotTest = new PortableRobot(0, new Position(0, 0));
		
		robotTest.SetId(1);
		robotTest.SetPosition(new Position(3,3));
		
		sut.RegisterRobot(robotTest);
		
		assertEquals(sut.CheckRobots(robotTest.GetPosition()), false);
	}
}