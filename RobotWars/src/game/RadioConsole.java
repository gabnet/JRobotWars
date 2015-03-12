package game;

import java.lang.reflect.Method;

import robot.Abstract.IRobot;
import utils.Status;

public class RadioConsole {

	public static boolean SendCommand(Act a, IRobot robot){
		
		Method action;

		try {
			switch (a){
			case L:
				action = robot.getClass().getMethod("TurnLeft");
				action.invoke(robot);
				return true;
			case M:
				action = robot.getClass().getMethod("Forward", int.class);
				Status status = (Status) action.invoke(robot, 1);
				return status == Status.Ok;
			case R:
				action = robot.getClass().getMethod("TurnRight");
				action.invoke(robot);
				return true;
			}
		} catch (Exception e){
			return false;
		}
		
		return false;
	}
}
