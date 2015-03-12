package Mocks.objects;

import robot.Abstract.IEngine;
import Mocks.utils.Mock;

public class Engine extends Mock implements IEngine {

	@Override
	public utils.Move Move(utils.Move move) {
		return Get("Move");
	}
}
