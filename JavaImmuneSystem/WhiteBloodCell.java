
public abstract class WhiteBloodCell extends Entity {
	private String nucleusType;// nucleus type cell
	private Entity[] targets;// target to get terminated

	public WhiteBloodCell(String nucleusType, Entity[] targets) {
		super(Strength.HIGH);
		this.targets = targets;
		this.nucleusType = nucleusType;

	}

	public abstract void absorb(Entity in);

	public abstract void release();

	@Override
	public void touchNeighbor(Entity neighbor) {

		if (getStrength() != Strength.DEAD && neighbor != null) {
			for (Entity cell : targets) {
				if (cell.getDNA().compareTo(neighbor.getDNA()) == 0) {
					int battle = 1 + (int) (Math.random() * ((10 - 1) + 1));
					if ((getStrength() == Strength.MEDIUM && battle > 5)
							|| (getStrength() == Strength.HIGH && battle > 1)) {
						absorb(neighbor);
					}
				}
			}
		}
	}

	public void increaseStrength() {
		switch (getStrength()) {
		case LOW:
			setStrength(Strength.MEDIUM);
			break;
		case MEDIUM:
			setStrength(Strength.HIGH);
			break;
		default:
			break;
		}

	}

	public void reduceStrength() {
		switch (getStrength()) {
		case LOW:
			setStrength(Strength.DEAD);
			break;
		case MEDIUM:
			setStrength(Strength.LOW);
			break;
		case HIGH:
			setStrength(Strength.MEDIUM);
			break;
		default:
			break;
		}
	}
}
