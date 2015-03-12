package game.Abstract;

import robot.Abstract.IRobot;
import utils.Abstract.IPlayground;
import exceptions.GameException;
import game.Act;

public interface IGame {

	public void OpenArena(int weight, int height);
	public void AddNewRobot(IRobot newRobot) throws GameException;
	public boolean RobotAct(int id, Act a) throws GameException;
	public IPlayground GetArena();
}
