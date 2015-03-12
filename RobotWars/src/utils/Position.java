package utils;

import utils.Abstract.IPosition;

public class Position implements IPosition {

	private int xPos;
	private int yPos;
	
	public Position(int xValue, int yValue){
		xPos = xValue;
		yPos = yValue;
	}
	
	@Override
	public int GetX(){
		return xPos;
	}
	
	@Override
	public int GetY(){
		return yPos;
	}

	@Override
	public void SetX(int xValue) {
		xPos = xValue;
	}

	@Override
	public void SetY(int yValue) {
		yPos = yValue;
	}
	
	@Override
	public boolean equals(Object obj){
		try{
			return this.GetX() == ((IPosition)obj).GetX() && this.GetY() == ((IPosition)obj).GetY();
		}catch(Exception e){
			return false;
		}
	}
}
