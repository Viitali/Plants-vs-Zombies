package logic.Managers;


public class SuncoinManager {

    private int sunCoins;

    public SuncoinManager() {
        sunCoins = 100;
    }

    public void addCoins(int coins) {
        sunCoins += coins;
    }

    public void buyPlant(int cost) {
        sunCoins -= cost;
    }
    
    public boolean canBuyPlant(int cost) {
    	return(sunCoins >= cost);
    }

    public int getSunCoins() {
        return sunCoins;
    }
    public void setSunCoins(int sunCoins) {
        this.sunCoins = sunCoins;
    }
}
