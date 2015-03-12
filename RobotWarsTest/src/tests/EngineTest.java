package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import robot.Engine;
import robot.Abstract.IEngine;
import utils.Face;
import utils.Move;
import utils.Position;
import utils.Status;
import utils.Abstract.IPosition;

public class EngineTest {

	private IEngine sut;
	
	public EngineTest(){
		sut = new Engine();
	}
	
	@Test
	public void TestForwardNorth(){
		
		IPosition startPosition = new Position(0, 0);
		
		Move testMove = new Move(startPosition, Face.N, 3, Status.ToDo);
		
		Move resultMove = sut.Move(testMove);
		
		assertEquals(resultMove.GetPosition().GetX(), 0);
		assertEquals(resultMove.GetPosition().GetY(), 3);
	}
	
	@Test
	public void TestForwardEast(){
		
		IPosition startPosition = new Position(0, 0);
		
		Move testMove = new Move(startPosition, Face.E, 3, Status.ToDo);
		
		Move resultMove = sut.Move(testMove);
		
		assertEquals(resultMove.GetPosition().GetX(), 3);
		assertEquals(resultMove.GetPosition().GetY(), 0);
	}
	
	@Test
	public void TestForwardSouth(){
		
		IPosition startPosition = new Position(0, 0);
		
		Move testMove = new Move(startPosition, Face.S, 3, Status.ToDo);
		
		Move resultMove = sut.Move(testMove);
		
		assertEquals(resultMove.GetPosition().GetX(), 0);
		assertEquals(resultMove.GetPosition().GetY(), -3);
	}
	
	@Test
	public void TestForwardWest(){
		
		IPosition startPosition = new Position(0, 0);
		
		Move testMove = new Move(startPosition, Face.W, 3, Status.ToDo);
		
		Move resultMove = sut.Move(testMove);
		
		assertEquals(resultMove.GetPosition().GetX(), -3);
		assertEquals(resultMove.GetPosition().GetY(), 0);
	}
}