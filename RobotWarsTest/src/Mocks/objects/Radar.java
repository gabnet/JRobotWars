package Mocks.objects;

import robot.Abstract.IRadar;
import utils.Move;
import Mocks.utils.Mock;

public class Radar extends Mock implements IRadar {

	@Override
	public Move ReviewMove(Move move) {
		return Get("ReviewMove");
	}
}
