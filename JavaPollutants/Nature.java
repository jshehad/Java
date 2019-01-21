
public class Nature extends Tile {
	private int treeDensity;// tree density

	public Nature(int treeDensity) {
		super();
		this.treeDensity = treeDensity;
		//setMeasurement(treeDensity);
		setMeasurement(0);
	}

	@Override
	public Force strengthen(Force f) {
		Force clone = f.clone();
		return clone;
	}

	@Override
	public boolean canPropagate() {
		return (treeDensity <= 50);
	}

	@Override
	public Force weaken(Force force) {
		Force clone = force.clone();
		double reduce = (clone.getLoad() * ((treeDensity / 100.0)));
		double loads = clone.getLoad() - reduce;
		if (loads <= 0)
			loads = 0;
		clone.setLoad(loads);
		// setMeasurement(loads);
		return clone;
	}

	@Override
	public String subString() {
		return "class Nature " + getMeasurement();
	}

}