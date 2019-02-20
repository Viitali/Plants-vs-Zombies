package logic.Objects.Plants;

public class SnowPeashooter extends ShooterPlant{

	public final static int COST= 175;
	public final static int CYCLES = 0;
	public final static int DAMAGE = 0;
	public final static int FREQUENCY = 1;
	public final static int RESISTANCE = 10;
	public final static String NAME = "Snow Peashooter";
	public final static String SHORTNAME = "SP";
	
	public SnowPeashooter() {
		super(COST, CYCLES, FREQUENCY, DAMAGE, RESISTANCE, NAME, SHORTNAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plant clone() {
		Plant n= new SnowPeashooter();
		return n;
	}

	@Override
	protected void attack(int posX, int i) {
		game.damageZombie(posX, i, damage);
		game.freezeZombie(posX, i);
	}
}
