

public class Cytokine extends Entity{

	public Cytokine() {
		super(Strength.DEAD);
		setDNA("cytokine");
		setStrength(Strength.DEAD);
	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		if ((neighbor != null) && (neighbor.getDNA().compareTo("neutrophil") == 0))
			kill();
		
	}

}
