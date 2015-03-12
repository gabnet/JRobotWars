package robot;

import robot.Abstract.IEngine;
import robot.Abstract.IPortableRobot;
import robot.Abstract.IRadar;
import robot.Abstract.IRobot;
import utils.Face;
import utils.FaceManager;
import utils.Move;
import utils.Position;
import utils.PositionFactory;
import utils.Status;
import utils.Abstract.IPosition;

public class Robot extends PortableRobot implements IRobot {

	private Face robotFace;
	
	private IEngine engine;
	private IRadar radar;
	
	public Robot(int id, IPosition position, IEngine engine, IRadar radar){
		super(id, position);
		robotFace = FaceManager.GetZeroFace();
		this.engine = engine;
		this.radar = radar;
	}
	
	@Override
	public Face GetFace(){
		return robotFace;
	}

	@Override
	public void TurnLeft() {
		robotFace = FaceManager.Left(robotFace);
	}
	
	@Override
	public void TurnRight(){
		robotFace = FaceManager.Right(robotFace);
	}

	@Override
	public Status Forward(int i) {
		
		Move resultMove = engine.Move(new Move(robotPosition, robotFace, i, Status.ToDo));
		
		Move finalMove = radar.ReviewMove(resultMove);
		
		if (finalMove.GetStatus() != Status.Failed)
			robotPosition = finalMove.GetPosition();
		
		return finalMove.GetStatus();
	}

	@Override
	public void SetX(int xValue) {
		robotPosition.SetX(xValue);
	}

	@Override
	public void SetY(int yValue) {
		robotPosition.SetY(yValue);
	}

	@Override
	public IPortableRobot GetPortable() {
		return (IPortableRobot) this;
	}
}
