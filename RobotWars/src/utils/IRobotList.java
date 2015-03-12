package utils;

import robot.Abstract.IPortableRobot;

public interface IRobotList <E extends IPortableRobot> {

	public E GetRobot(int id);
	public int size();
	public boolean add(E robot);
}