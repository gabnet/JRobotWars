package utils;

import utils.Abstract.IPosition;

public class PositionFactory {

	public static int GetZeroX() {
		return 0;
	}

	public static int GetZeroY() {
		return 0;
	}
	
	public static IPosition GetZeroPosition(){
		return new Position(GetZeroX(), GetZeroY());
	}
}
