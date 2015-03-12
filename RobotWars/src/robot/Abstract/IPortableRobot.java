package robot.Abstract;

import utils.Abstract.IPosition;

public interface IPortableRobot {

	public int GetId();
	public void SetId(int idValue);
	public IPosition GetPosition();
	public void SetPosition(IPosition position);
}
