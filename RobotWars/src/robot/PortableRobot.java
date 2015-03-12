package robot;

import robot.Abstract.IPortableRobot;
import utils.Abstract.IPosition;

public class PortableRobot implements IPortableRobot {

	protected int Id;
	protected IPosition robotPosition;
	
	public PortableRobot(int id, IPosition position){
		
		this.Id = id;
		robotPosition = position;
	}
	
	@Override
	public int GetId() {
		return Id;
	}
	
	@Override
	public void SetId(int idValue) {
		Id = idValue;
	}
	
	@Override
	public IPosition GetPosition(){
		return robotPosition;
	}
	
	@Override
	public void SetPosition(IPosition position){
		robotPosition = position;
	}
}
