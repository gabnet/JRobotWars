package utils;

import utils.Abstract.IPosition;

public class Move {

	private IPosition position;
	private Face face;
	private int steps;
	private Status status;
	
	public Move(IPosition position, Face face, int steps, Status status){
		this.position = position;
		this.face = face;
		this.steps = steps;
		this.status = status;
	}
	
	public IPosition GetPosition(){
		return position;
	}
	
	public Face GetFace(){
		return face;
	}
	
	public int GetSteps(){
		return steps;
	}
	
	public Status GetStatus() {
		return status;
	}
	
	public boolean IsStatusOK(){
		return status == Status.Ok;
	}

	public void SetStatus(Status status) {
		this.status = status;	
	}
	
	public void SetPosition(IPosition position){
		this.position = position;
	}
}