package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Face;
import utils.FaceManager;

public class FaceManagerTest {

	@Test
	public void TestTurnLeft(){
		
		assertEquals(FaceManager.Left(Face.N), Face.W);
		assertEquals(FaceManager.Left(Face.W), Face.S);
		assertEquals(FaceManager.Left(Face.S), Face.E);
		assertEquals(FaceManager.Left(Face.E), Face.N);
	}
	
	@Test
	public void TestTurnRight(){
		assertEquals(FaceManager.Right(Face.N), Face.E);
		assertEquals(FaceManager.Right(Face.E), Face.S);
		assertEquals(FaceManager.Right(Face.S), Face.W);
		assertEquals(FaceManager.Right(Face.W), Face.N);
	}
}