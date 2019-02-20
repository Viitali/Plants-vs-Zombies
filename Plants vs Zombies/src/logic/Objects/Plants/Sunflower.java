package logic.Objects.Plants;

public class Sunflower extends PassivePlant{
   
    private final static int RESISTANCE = 2;
    private final static  int COST = 10;
    private final static int DAMAGE = 0;
    private final static int CYCLES = 0;
    private final static int FREQUENCY = 2;
    private final static String NAME = "[S]unflower";
    private final static String SHORT_NAME = "S";
    private final int COINS = 10;

    public Sunflower() {
    	super(COST,CYCLES,FREQUENCY,DAMAGE,RESISTANCE,NAME,SHORT_NAME);
    }
    
    public void update() {
        if (canGenerateSun()) {
            game.addCoins(COINS);
        }
        increaseCycles();
    }
    
    public boolean canGenerateSun() {
        return (isAlive() && canUpdate());      
    }
    /*public Plant parse(String plantName) {
		if(plantName.equalsIgnoreCase(SHORT_NAME) || plantName.equalsIgnoreCase(NAME))
			return this;
		else
			return null;
	}*/
	@Override
	public Plant clone() {
		Plant n= new Sunflower();
		return n;
	}
}