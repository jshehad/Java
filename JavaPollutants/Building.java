
public class Building extends Tile {
	private int people;// holds people
	private int cars;// holds cars
	private int height;// holds height

	public Building(int people, int cars, int height) {
		super();
		this.people = people;
		this.height = height;
		this.cars = cars;
		double building_load = people * getPeopleWaste() + cars * getCarsWaste();
		setMeasurement(building_load);
	}

	@Override
	public Force strengthen(Force f) {
		Force clone = f.clone();
		int pollutants = (getPeopleWaste() * people) + (getCarsWaste() * cars);
		double increment = clone.getLoad() + pollutants;
		clone.setLoad(increment);
		return clone;
	}

	@Override
	public boolean canPropagate() {
		return (height < 100);
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String subString() {
		return "class Building " + getMeasurement();

	}

}
