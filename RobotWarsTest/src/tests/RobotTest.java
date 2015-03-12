package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import robot.Robot;
import robot.Abstract.IPortableRobot;
import robot.Abstract.IRobot;
import utils.Face;
import utils.Move;
import utils.Position;
import utils.Status;
import utils.Abstract.IPosition;


public class RobotTest {

	private IRobot sut;
	private Mocks.objects.Engine mockEngine;
	private Mocks.objects.Radar mockRadar;

	public RobotTest(){
		
		mockEngine = new Mocks.objects.Engine();
		mockRadar = new Mocks.objects.Radar();
		
		sut = new Robot(0, new Position(0, 0), mockEngine, mockRadar);
	}
	
	@Test
	public void NewRobotTest(){
	
		assertEquals(sut.GetFace(), Face.N);
	}
	
	@Test
	public void PlaceTest() {
		
		IPosition testPosition = new Position(2, 4);
		
		sut.SetPosition(testPosition);
		
		assertEquals(testPosition.GetX(), sut.GetPosition().GetX());
		assertEquals(testPosition.GetY(), sut.GetPosition().GetY());
	}
	
	@Test
	public void PartialPlaceTest(){
		
		IPosition testPosition = new Position(2, 4);
		
		sut.SetX(testPosition.GetX());
		
		assertEquals(testPosition.GetX(), sut.GetPosition().GetX());
		
		sut.SetY(testPosition.GetY());
	
		assertEquals(testPosition.GetY(), sut.GetPosition().GetY());
	}

	@Test
	public void TestForwardOk(){

		Position testPosition = new Position(0, 3);
		Move testMoveEngine = new Move(testPosition, Face.N, 0, Status.ToCheck);
		Move testMoveRadar = new Move(testPosition, Face.N, 0, Status.Ok);
		
		mockEngine.Stub("Move", testMoveEngine);
		mockRadar.Stub("ReviewMove", testMoveRadar);
		
		assertEquals(sut.Forward(3), Status.Ok);
		assertEquals(sut.GetPosition(), new Position(0, 3));
	}
	
	@Test
	public void TestForwardKo(){
		
		Position testPosition = new Position(0, 3);
		Move testMoveRadar = new Move(testPosition, Face.N, 0, Status.Failed);
		
		mockEngine.Stub("Move", null);
		mockRadar.Stub("ReviewMove", testMoveRadar);
		
		assertEquals(sut.Forward(3), Status.Failed);
		assertEquals(sut.GetPosition(), new Position(0, 0));
	}
	
	@Test
	public void TestGetPortableRobot(){
		
		IPortableRobot test = sut.GetPortable();
		
		assertEquals(test.GetId(), sut.GetId());
	}
}