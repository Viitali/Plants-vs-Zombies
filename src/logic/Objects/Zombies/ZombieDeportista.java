package logic.Objects.Zombies;

public class ZombieDeportista extends Zombie{
	
	public final static int FREQUENCY=1;
    public final static int RESISTANCE = 2;
    public final static int DAMAGE = 1;
    public final static int CYCLES = 0;
    public final static String SHORTNAME = "X";
    public final static String NAME = "[Z]ombie deportista";

	public ZombieDeportista() {
		super(CYCLES, DAMAGE, RESISTANCE, FREQUENCY, NAME, SHORTNAME);
	}
	public Zombie clone() {
		Zombie z = new ZombieDeportista();
		return z;
	}
	public Zombie parse(String zombieName) {
		if(zombieName.equalsIgnoreCase(SHORTNAME))
			return this;
		else
			return null;
	}
}
