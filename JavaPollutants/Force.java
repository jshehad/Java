
public class Force {
	private double load;// holds load
	private String name;// holds name of force

	public Force(double load, String name) {
		this.load = load;
		this.name = name;
	}

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void decay() {
		load *= .8;

	}

	@Override
	public Force clone() {
		return new Force(load, name);
	}

	@Override
	public String toString() {
		return this.name + " has a load of " + Math.round(this.load);
	}
}
