package game;

import exceptions.GameException;
import robot.Abstract.IRobot;
import game.Abstract.IGame;
import utils.IRobotList;
import utils.Playground;
import utils.RobotList;
import utils.Abstract.IPlayground;

public class Game implements IGame {
	
	private IPlayground arena;
	private IRobotList<IRobot> warriors;

	@Override
	public void OpenArena(int weight, int height) {

		arena = new Playground(weight, height);
	}

	@Override
	public void AddNewRobot(IRobot newRobot) throws GameException {

		if (arena == null)
			throw new GameException("Arena is closed, plz OpenArena");
		
		if (warriors == null)
			warriors = new RobotList<IRobot>();
	
		warriors.add(newRobot);
	
		arena.RegisterRobot(newRobot.GetPortable());
	}

	@Override
	public boolean RobotAct(int id, Act a) throws GameException {

		IRobot actualRobot;
		
		if (warriors == null)
			warriors = new RobotList<IRobot>();
		
		actualRobot = warriors.GetRobot(id);
		
		if (actualRobot == null)
			throw new GameException("Robot not found on arena");
		
		return RadioConsole.SendCommand(a, actualRobot);
	}

	@Override
	public IPlayground GetArena() {
		return arena;
	}
}