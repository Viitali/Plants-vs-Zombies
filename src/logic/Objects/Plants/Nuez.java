package logic.Objects.Plants;

public class Nuez extends Plant {

	public final static int COST= 50;
	public final static int CYCLES = 0;
	public final static int DAMAGE = 0;
	public final static int FREQUENCY = 0;
	public final static int RESISTANCE = 10;
	public final static String NAME = "[N]uez";
	public final static String SHORTNAME = "N";
	
	public Nuez() {
		super(COST, CYCLES, DAMAGE, FREQUENCY, RESISTANCE, NAME, SHORTNAME);
	}
	public void update() {
		
	}
	@Override
	public Plant parse(String plantName) {
		if(plantName.equalsIgnoreCase(SHORTNAME) || plantName.equalsIgnoreCase(NAME))
			return this;
		else
			return null;
	}
	@Override
	public Plant clone() {
		Plant n= new Nuez();
		return n;
	}

}
