package utils;

import java.util.ArrayList;
import java.util.Iterator;

import robot.Abstract.IPortableRobot;

public class RobotList <E extends IPortableRobot> implements IRobotList<E> {

	private ArrayList<E> list;
	
	public RobotList(){
		list = new ArrayList<E>();
	}
	
	public E GetRobot(int id){
		
		for (Iterator<E> robotIterator = (Iterator<E>) list.iterator(); robotIterator.hasNext() ; ){
			
			E cicleRobot = robotIterator.next();
			
			if (cicleRobot.GetId() == id)
				return (E) cicleRobot;
		}
		
		return null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean add(E robot) {
		if (GetRobot(robot.GetId()) != null)
			return false;
		list.add(robot);
		return true;
	}
}