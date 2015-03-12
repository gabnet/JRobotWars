package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import robot.Abstract.IPortableRobot;
import utils.Abstract.IPlayground;
import utils.Abstract.IPosition;

public class Playground implements IPlayground {

	private int weight;
	private int height;
	
	private List<IPortableRobot> robots;

	public Playground (int weight, int height){
		this.weight = weight;
		this.height = height;
		this.robots = new ArrayList<IPortableRobot>();
	}
	
	@Override
	public void RegisterRobot(IPortableRobot robot){

		if (!RobotExists(robots, robot.GetPosition()))
			robots.add(robot);
	}
		
	@Override
	public boolean CheckBounds(IPosition tryPosition) {
		if (weight == Integer.MAX_VALUE && height == Integer.MAX_VALUE)
			return true;
			
		return Math.abs(tryPosition.GetX()) <= weight && Math.abs(tryPosition.GetY()) <= height;
	}
	
	@Override
	public IPosition FixBounds(IPosition tryPosition) {

		tryPosition.SetX(FixPosition(tryPosition.GetX(), weight));
		tryPosition.SetY(FixPosition(tryPosition.GetY(), height));
		
		return tryPosition;
	}
	
	@Override
	public boolean CheckRobots(IPosition robotPosition) {
		return !RobotExists(robots, robotPosition);
	}
	
	private int FixPosition(int xValue, int bound) {
		
		int min = Math.min(Math.abs(xValue), bound);
		
		return (xValue < 0) ? (min * -1) : min;
	}
	
	private boolean RobotExists(List<IPortableRobot> currentList, IPosition newPosition){
		
		for (Iterator<IPortableRobot> robotIterator = robots.iterator(); robotIterator.hasNext(); ){
			
			IPortableRobot cicleRobot = robotIterator.next();

			if (cicleRobot.GetPosition().GetX() == newPosition.GetX() && cicleRobot.GetPosition().GetY() == newPosition.GetY())
				return true;
		}
		
		return false;
	}
}