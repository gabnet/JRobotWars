package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import robot.Radar;
import robot.Abstract.IRadar;
import utils.Face;
import utils.Move;
import utils.Position;
import utils.Status;

public class RadarTest {

	private IRadar sut;
	private Mocks.objects.Playground mockPlayground;
	
	public RadarTest(){
		
		mockPlayground = new Mocks.objects.Playground();
		
		sut = new Radar(mockPlayground);
	}
	
	@Test
	public void MoveOk(){
		
		mockPlayground.Stub("CheckBounds", true);
		mockPlayground.Stub("CheckRobots", true);
		
		assertEquals(sut.ReviewMove(new Move(new Position(0, 0), Face.N, 0, Status.ToDo)).GetStatus(), Status.Ok);
	}

	@Test
	public void MoveKo(){

		mockPlayground.Stub("CheckBounds", false);
		mockPlayground.Stub("CheckRobots", false);
		
		assertEquals(sut.ReviewMove(new Move(new Position(0, 0), Face.N, 0, Status.ToDo)).GetStatus(), Status.Failed);
	}
	
	@Test
	public void MoveBoundKoFixRobotOk(){
		
		Position testPosition = new Position(3,3); 
		
		mockPlayground.Stub("CheckBounds", false);
		mockPlayground.Stub("CheckRobots", true);
		mockPlayground.Stub("FixBounds", testPosition);
		
		Move testMove = sut.ReviewMove(new Move(new Position(0, 0), Face.N, 0, Status.ToDo));
		
		assertEquals(testMove.GetStatus(), Status.Ok);
		assertEquals(testMove.GetPosition().GetX(), testPosition.GetX());
		assertEquals(testMove.GetPosition().GetY(), testPosition.GetY());
	}
	
	@Test
	public void MoveBoundKoFixRobotKo(){
		
		Position testPosition = new Position(3,3); 
		
		mockPlayground.Stub("CheckBounds", false);
		mockPlayground.Stub("CheckRobots", false);
		mockPlayground.Stub("FixBounds", testPosition);
		
		Move testMove = sut.ReviewMove(new Move(new Position(0, 0), Face.N, 0, Status.ToDo));
		
		assertEquals(testMove.GetStatus(), Status.Failed);
		assertEquals(testMove.GetPosition().GetX(), testPosition.GetX());
		assertEquals(testMove.GetPosition().GetY(), testPosition.GetY());
	}
	
}
