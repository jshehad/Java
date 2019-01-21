
public abstract class Tile implements Modifiable {
	private int row = 0;// holds the row of the tile
	private int column = 0;// holds the col of the tile
	private String measurement;// holds measurement
	final int PEOPLE_WASTE = 2;// people waste
	final int CARS_WASTE = 5;// cars waste

	@Override
	public Force weaken(Force f) {
		Force clone = f.clone();
		clone.decay();
		return clone;
	}

	public int getPeopleWaste() {
		return PEOPLE_WASTE;
	}

	public int getCarsWaste() {
		return CARS_WASTE;
	}

	public abstract boolean canPropagate();

	public abstract String subString();

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int col) {
		this.column = col;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(double measurement) {
		this.measurement = "" + Math.round(measurement);
	}

	public String toString() {
		return "row: " + row + " col: " + column;
	}

}
