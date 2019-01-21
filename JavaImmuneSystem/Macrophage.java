
public class Macrophage extends WhiteBloodCell {
	private int count = 0; // counts number of kills

	public Macrophage(String nucleusType, Entity[] targets) {
		super(nucleusType, targets);
		setDNA("macrophage");
	}

	@Override
	public void absorb(Entity in) {
		in.kill();
		count++;
		release();

	}

	@Override
	public void release() {
		if (count == 100)
			kill();

	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		if (getStrength() != Strength.DEAD) {
			super.touchNeighbor(neighbor);
			if (neighbor != null && neighbor.getDNA().compareTo("neutrophil") == 0
					&& neighbor.getStrength() == Strength.LOW) {
				absorb(neighbor);
			}
		}
	}

}
