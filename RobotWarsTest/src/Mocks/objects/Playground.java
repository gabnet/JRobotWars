package Mocks.objects;

import robot.Abstract.IPortableRobot;
import Mocks.utils.Mock;
import utils.Abstract.IPlayground;
import utils.Abstract.IPosition;

public class Playground extends Mock implements IPlayground {

	@Override
	public void RegisterRobot(IPortableRobot robot) {
	}

	@Override
	public boolean CheckBounds(IPosition tryPosition) {
		return Get("CheckBounds");
	}

	@Override
	public IPosition FixBounds(IPosition tryPosition) {
		return Get("FixBounds");
	}

	@Override
	public boolean CheckRobots(IPosition robotPosition) {
		return Get("CheckRobots");
	}
}
