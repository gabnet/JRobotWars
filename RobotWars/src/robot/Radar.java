package robot;

import robot.Abstract.IRadar;
import utils.Move;
import utils.Status;
import utils.Abstract.IPlayground;

public class Radar implements IRadar {

	private IPlayground playground;
	
	public Radar(IPlayground playground){
		this.playground = playground;
	}
	
	@Override
	public Move ReviewMove(Move move) {
		
		move.SetStatus(Status.Ok);
		
		if (!playground.CheckBounds(move.GetPosition()))
			move.SetPosition(playground.FixBounds(move.GetPosition()));
		
		if (!playground.CheckRobots(move.GetPosition()))
			move.SetStatus(Status.Failed);
		
		return move;
	}
}
