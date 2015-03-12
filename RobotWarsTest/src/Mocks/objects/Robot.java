package Mocks.objects;

import Mocks.utils.Mock;
import robot.Abstract.IPortableRobot;
import robot.Abstract.IRobot;
import utils.Face;
import utils.Status;
import utils.Abstract.IPosition;

public class Robot extends Mock implements IRobot {

	@Override
	public int GetId() {
		return Get("GetId");
	}

	@Override
	public void SetId(int idValue) {
	}

	@Override
	public IPosition GetPosition() {
		return Get("GetPosition");	
	}

	@Override
	public void SetPosition(IPosition position) { 
	}

	@Override
	public Face GetFace() {
		return Get("GetFace");
	}

	@Override
	public void SetX(int xValue) {
	}

	@Override
	public void SetY(int yValue) {
	}

	@Override
	public void TurnLeft() {
	}

	@Override
	public void TurnRight() {
	}

	@Override
	public Status Forward(int i) {
		return Get("Forward");
	}

	@Override
	public IPortableRobot GetPortable() {
		return Get("GetPortable");
	}
}