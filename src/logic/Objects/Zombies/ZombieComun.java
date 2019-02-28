package logic.Objects.Zombies;

public class ZombieComun extends Zombie{
	
	public final static int FREQUENCY=2;
    public final static int RESISTANCE = 5;
    public final static int DAMAGE = 1;
    public final static int CYCLES = 0;
    public final static String SHORTNAME = "Z";
    public final static String NAME = "[Z]ombie comun";
    
    public ZombieComun() {
        super(CYCLES,DAMAGE,RESISTANCE,FREQUENCY,NAME,SHORTNAME);
    }
    public Zombie clone() {
		Zombie z = new ZombieComun();
		return z;
	}
    public Zombie parse(String zombieName) {
		if(zombieName.equalsIgnoreCase(SHORTNAME))
			return this;
		else
			return null;
	}
}