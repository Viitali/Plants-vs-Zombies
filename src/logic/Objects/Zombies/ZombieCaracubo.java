package logic.Objects.Zombies;


public class ZombieCaracubo extends Zombie {
	
	private final static int FREQUENCY=4;
	private final static int RESISTANCE = 8;
	private final static int DAMAGE = 1;
	private final static int CYCLES = 0;
	private final static String SHORTNAME = "W";
    private final static String NAME = "[Z]ombie caracubo";

	public ZombieCaracubo() {
		super(CYCLES, DAMAGE, RESISTANCE, FREQUENCY, NAME, SHORTNAME);
	}
	public Zombie clone() {
		Zombie z = new ZombieCaracubo();
		return z;
	}
	public Zombie parse(String zombieName) {
		if(zombieName.equalsIgnoreCase(SHORTNAME))
			return this;
		else
			return null;
	}

}
