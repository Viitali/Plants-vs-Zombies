package logic.Objects.Plants;

public class PotatoMine extends ExplosivePlant {
	public final static int COST= 75;
	public final static int CYCLES = 0;
	public final static int DAMAGE = 10;
	public final static int FREQUENCY = 3;
	public final static int RESISTANCE = 15;
	public final static String NAME = "PotatoMine";
	public final static String SHORTNAME = "PM";
	public boolean cuenta=false;
	public PotatoMine() {
		super(COST, CYCLES, FREQUENCY, DAMAGE, RESISTANCE, NAME, SHORTNAME);
		// TODO Auto-generated constructor stub
	}
	public void update()
	{
		if(game.isZombieInPosition(posX, posY+1))
			cuenta=true;
		if(cuenta)
		{
			if(canUpdate())
				super.update();
			else
				increaseCycles();
		}
	}
	public Plant clone() {
		Plant n= new PotatoMine();
		return n;
	}

}
