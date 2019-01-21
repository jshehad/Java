

public class BodyOfWater extends Tile {
	public BodyOfWater() {
		setMeasurement(0);
	}

	@Override
	public Force strengthen(Force f) {
		Force clone = f.clone();
		return clone;
	}

	@Override
	public boolean canPropagate() {
	
		return true;
	}
	

	@Override
	public String subString() {
		return "class BodyOfWater "+getMeasurement();
	}

}