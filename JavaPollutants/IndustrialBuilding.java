
public class IndustrialBuilding extends Building {
	private double emissions;// holds emissions
	private final int EMISSIONS_CONSTANT = 10;// emissions constant

	public IndustrialBuilding(int people, int cars, int height, double emissions) {
		super(people, cars, height);
		this.emissions = emissions;
		double building_load = people * getPeopleWaste() + cars * getCarsWaste() + emissions * EMISSIONS_CONSTANT;
		setMeasurement(building_load);
	}

	@Override
	public Force strengthen(Force force) {
		Force clone = super.strengthen(force);
		double increments = clone.getLoad() + (EMISSIONS_CONSTANT * emissions);
		clone.setLoad(increments);
		return clone;

	}

	@Override
	public boolean canPropagate() {
		return true;
	}

	@Override
	public String subString() {
		return "class IndustrialBuilding " + getMeasurement();
	}

	public int getEmission() {
		return EMISSIONS_CONSTANT;
	}
}
