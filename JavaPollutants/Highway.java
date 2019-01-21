
public class Highway extends Tile {
	private int carDensity;// holds car density

	public Highway(int carDensity) {
		super();
		this.carDensity = carDensity;
		setMeasurement(carDensity);
	}

	@Override
	public Force strengthen(Force f) {
		double increments = f.getLoad() + (getCarsWaste() * carDensity);
		f.setLoad(increments);
		return f;
	}

	@Override
	public boolean canPropagate() {
		return true;
	}

	@Override
	public String subString() {
		return "class Highway " + getMeasurement();
	}

}