
public class Bacteria extends Entity {
	public Bacteria(Strength strength) {
		super(strength);
		setDNA("bacteria");

	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		if (this.getStrength() != Strength.DEAD) {

			for (int i = 0; i < Entity.bloodstream.length; i++) {
				if (Entity.bloodstream[i] == null) {
					Entity.bloodstream[i] = new Bacteria(Strength.HIGH);
					break;
				}
			}
		}

	}

}
