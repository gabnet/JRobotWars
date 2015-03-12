package robot.Abstract;

import utils.Face;
import utils.Status;

public interface IRobot extends IPortableRobot {

	public Face GetFace();
	public void SetX(int xValue);
	public void SetY(int yValue);
	
	public void TurnLeft();
	public void TurnRight();
	public Status Forward(int i);
	
	public IPortableRobot GetPortable();
}	
	