
public class Lymphocyte extends WhiteBloodCell {
	public Lymphocyte(String nucleusType, Entity[] targets) {
		super(nucleusType, targets);
		setDNA("lymphocyte");
	}

	@Override
	public void absorb(Entity in) {
		in.kill();
		release();

	}

	@Override
	public void release() {
		if (Math.random() < .1) {
			kill();
		}

	}

}
