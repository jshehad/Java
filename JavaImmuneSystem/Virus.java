
public class Virus extends Entity {

	public Virus(Strength strength) {
		super(strength);
		setDNA("virus");
	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		if (getStrength() != Strength.DEAD && neighbor != null) {
			if (neighbor.getDNA().compareTo("neutrophil") == 0) {
				neighbor.setDNA("virus");
			}

		}
	}

}
