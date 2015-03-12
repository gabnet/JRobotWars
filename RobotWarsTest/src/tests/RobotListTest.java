package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import robot.Robot;
import robot.Abstract.IRobot;
import utils.IRobotList;
import utils.Position;
import utils.RobotList;

public class RobotListTest {

	private IRobotList<IRobot> sut;
	
	public RobotListTest(){
		
		sut = new RobotList<IRobot>();
	}

	@Test
	public void GetRobotOk(){
		
		sut.add(new Robot(0, new Position(0,0), null, null));
	
		assertEquals(sut.GetRobot(0).GetId(), 0);
	}
	
	@Test
	public void GetRobotKo(){
		
		assertEquals(sut.GetRobot(999), null);
	}
}