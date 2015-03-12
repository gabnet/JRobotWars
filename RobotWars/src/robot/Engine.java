package robot;

import robot.Abstract.IEngine;
import utils.Abstract.IPosition;
import utils.Move;
import utils.Status;

public class Engine implements IEngine {

	@Override
	public Move Move(Move move) {
		
		IPosition tryPosition;
		
		tryPosition = GetPosition(move);

		return new Move(tryPosition, move.GetFace(), move.GetSteps(), Status.ToCheck);
	}
	
	private IPosition GetPosition(Move move) {
		switch (move.GetFace()) {
		case N:
			return VerticalMove(move.GetPosition(), move.GetSteps());
		case E:
			return OrizontalMove(move.GetPosition(), move.GetSteps());
		case S:
			return VerticalMove(move.GetPosition(), - move.GetSteps());
		default:
			return OrizontalMove(move.GetPosition(), - move.GetSteps());
		}
	}

	private IPosition OrizontalMove(IPosition position, int steps) {
		position.SetX(position.GetX() + steps);
		
		return position;
	}

	private IPosition VerticalMove(IPosition position, int steps) {
		position.SetY(position.GetY() + steps);
		
		return position;
	}
}
