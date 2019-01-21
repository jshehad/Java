
public class Neutrophil extends WhiteBloodCell {
	private boolean sniffCytokines;// sniffs if there is a cytokine

	public Neutrophil(String nucleusType, Entity[] targets, boolean sniffCytokines) {
		super(nucleusType, targets);
		setDNA("neutrophil");
		this.sniffCytokines = sniffCytokines;

	}

	@Override
	public void absorb(Entity in) {
		in.kill();
		reduceStrength();
		release();
	}

	@Override
	public void release() {
		int count = 0;
		for (int index = 0; index < bloodstream.length; index++) {
			if (bloodstream[index] == null) {
				if (this.getDNA().compareTo("virus") == 0) {
					count = index;
					count += 3;
					if (count >= Entity.bloodstream.length)
						count = Entity.bloodstream.length;
					while (index < count) {
						Entity.bloodstream[index] = new Virus(Strength.HIGH);
						index++;
					}
					index -= 1;
				} else {
					count = index;
					count += 3;
					if (count >= Entity.bloodstream.length)
						count = Entity.bloodstream.length;
					while (index < count) {
						Entity.bloodstream[index] = new Cytokine();
						index++;
					}
					index -= 1;
				}
			}
		}

	}

	@Override
	public void touchNeighbor(Entity neighbor) {

		if (getStrength() != Strength.DEAD) {
			super.touchNeighbor(neighbor);
			if (sniffCytokines == true && neighbor != null) {
				if (neighbor.getDNA().compareTo("cytokine") == 0) {
					increaseStrength();
				}
			}
		}
	}
}
