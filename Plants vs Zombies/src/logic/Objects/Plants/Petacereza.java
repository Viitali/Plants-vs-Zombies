package logic.Objects.Plants;

public class Petacereza extends ExplosivePlant{
	public final static int COST= 50;
	public final static int CYCLES = 0;
	public final static int DAMAGE = 10;
	public final static int FREQUENCY = 2;
	public final static int RESISTANCE = 2;
	public final static String NAME = "Peta[c]ereza";
	public final static String SHORT_NAME = "C";
	
	public Petacereza()
	{
		super(COST,CYCLES,FREQUENCY,DAMAGE,RESISTANCE,NAME,SHORT_NAME);
	}
	
	/*public static String getShortName() {
		return SHORT_NAME;
	}*/
	public Plant clone() {
		Plant n= new Petacereza();
		return n;
	}
	public void update()
	{
		if(canUpdate())
			super.update();
		else
			increaseCycles();
	}
}
