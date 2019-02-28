package logic.Managers;

import java.util.Random;

public class ZombieManager {
    public int zombiesLeftToAppear;
    Random rand;
    double frecuencia;

    public ZombieManager() {
        rand = new Random(System.nanoTime());
    }
    public double getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public boolean isZombieAdded() {
        double x = rand.nextDouble();
        return (zombiesLeftToAppear > 0 && x < frecuencia);
    }
    
    public boolean noZombiesLeft() {
        return (zombiesLeftToAppear == 0);
    }

    public int getZombiesLeftToAppear() {
        return zombiesLeftToAppear;
    }
    public void setZombiesLeftToAppear(int zombiesLeftToAppear) {
        this.zombiesLeftToAppear = zombiesLeftToAppear;
    }
    public void restarZombiesLeftToAppear() {
        zombiesLeftToAppear--;
    }
}
