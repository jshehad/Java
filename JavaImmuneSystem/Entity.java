
public abstract class Entity {
	private String DNA;// Dna of Entity
	private Strength strength;// Strength of Entity
	public static Entity[] bloodstream;// In bloodstream

	public Entity(Strength strength) {
		this.strength = strength;

	}

	public String getDNA() {
		return DNA;
	}

	public void setDNA(String dNA) {
		DNA = dNA;
	}

	public Strength getStrength() {
		return strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public void kill() {
		this.strength = Strength.DEAD;

	}

	public abstract void touchNeighbor(Entity neighbor);

	public static void setEntity(int size) {
		bloodstream = new Entity[size];
	}

	public String toString() {
		return "Entity" + ":" + this.getDNA();
	}

}
