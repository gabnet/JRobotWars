package utils.Abstract;

import robot.Abstract.IPortableRobot;

public interface IPlayground {

	public void RegisterRobot(IPortableRobot robot);
	
	public boolean CheckBounds(IPosition tryPosition);
	public IPosition FixBounds(IPosition tryPosition);
	public boolean CheckRobots(IPosition robotPosition);
}
