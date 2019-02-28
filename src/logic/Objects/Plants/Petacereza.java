package logic.Objects.Plants;

public class Petacereza extends Plant{
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
	
	@Override
	public void update() {
		if(canUpdate()) {
			//game.bombAttackAndEliminate(posX,posY,DAMAGE);
			for (int i = posX - 1;i<=(posX + 1);i++) {
				for (int j = posY - 1;j <= (posY + 1);j++) {
					game.damageZombie(i, j, damage);
					}
	    		}
			resistance=0;
	   	}
		else
		{
			increaseCycles();
		}
		
	}
	public static String getShortName() {
		return SHORT_NAME;
	}
	public Plant parse(String plantName) {
		if(plantName.equalsIgnoreCase(SHORT_NAME) || plantName.equalsIgnoreCase(NAME))
			return this;
		else
			return null;
	}
	@Override
	public Plant clone() {
		Plant n= new Petacereza();
		return n;
	}
}
