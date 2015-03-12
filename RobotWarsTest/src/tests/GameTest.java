package tests;

import static org.junit.Assert.*;
import exceptions.GameException;
import game.Act;
import game.Game;
import game.Abstract.IGame;

import org.junit.Test;

import robot.Engine;
import robot.PortableRobot;
import robot.Radar;
import robot.Robot;
import robot.Abstract.IRobot;
import utils.Face;
import utils.Position;
import utils.Status;
import utils.Abstract.IPosition;

public class GameTest {

	private IGame sut;
	
	public GameTest(){
		
		sut = new Game();
	}
	
	@Test
	public void RobotActKo(){

		try {
			sut.RobotAct(0, Act.L);
		} catch (GameException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void RobotActOk(){
		
		sut.OpenArena(5, 5);
		
		Mocks.objects.Robot testRobot = new Mocks.objects.Robot();
		
		testRobot.Stub("GetId", 0);
		testRobot.Stub("Forward", Status.Ok);
		testRobot.Stub("GetPortable", new PortableRobot(0, new Position(0, 0)));
		
		try {
			sut.AddNewRobot(testRobot);
			
			assertTrue(sut.RobotAct(0, Act.M));
		} catch (GameException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void FinalGameTest(){
		
		sut.OpenArena(5, 5);
		
		IPosition posA = new Position(1, 2);
		IRobot robotA = new Robot(0, posA, new Engine(), new Radar(sut.GetArena()));
		
		IPosition posB = new Position(3,3);
		IRobot robotB = new Robot(1, posB, new Engine(), new Radar(sut.GetArena()));
		
		try {
			
			sut.AddNewRobot(robotA);
			
			sut.RobotAct(robotA.GetId(), Act.L);
			sut.RobotAct(robotA.GetId(), Act.M);

			sut.RobotAct(robotA.GetId(), Act.L);
			sut.RobotAct(robotA.GetId(), Act.M);

			sut.RobotAct(robotA.GetId(), Act.L);
			sut.RobotAct(robotA.GetId(), Act.M);

			sut.RobotAct(robotA.GetId(), Act.L);
			sut.RobotAct(robotA.GetId(), Act.M);

			sut.RobotAct(robotA.GetId(), Act.M);

			sut.AddNewRobot(robotB);
			
			robotB.TurnRight();

			sut.RobotAct(robotB.GetId(), Act.M);
			sut.RobotAct(robotB.GetId(), Act.M);
			
			sut.RobotAct(robotB.GetId(), Act.R);
			
			sut.RobotAct(robotB.GetId(), Act.M);
			sut.RobotAct(robotB.GetId(), Act.M);
			
			sut.RobotAct(robotB.GetId(), Act.R);
			
			sut.RobotAct(robotB.GetId(), Act.M);
			sut.RobotAct(robotB.GetId(), Act.R);
			
			sut.RobotAct(robotB.GetId(), Act.R);
			
			sut.RobotAct(robotB.GetId(), Act.M);
			
			sut.AddNewRobot(robotB);
		} catch (GameException e) {
			assertTrue(false);
		}
		
		assertTrue(robotA.GetPosition().equals(new Position(1, 3)));
		assertEquals(robotA.GetFace(), Face.N);
		
		assertTrue(robotB.GetPosition().equals(new Position(5, 1)));
		assertEquals(robotB.GetFace(), Face.E);
	}
}