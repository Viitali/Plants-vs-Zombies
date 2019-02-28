package logic;

import logic.Exceptions.CommandExecuteException;
import logic.Exceptions.ArgsException;
import logic.Factory.PlantFactory;
import logic.Factory.ZombieFactory;
import logic.Lists.GameObjectList;
import logic.Managers.SuncoinManager;
import logic.Managers.ZombieManager;
import logic.Objects.GameObject;
import logic.Objects.Plants.Plant;
import logic.Objects.Zombies.Zombie;
import logic.Printer.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Game {
	
    private boolean printMode;
	private GameObjectList zombieList;
    private GameObjectList plantList;
    private ZombieManager zManager;
    private SuncoinManager sManager;
    private Level level;
    private boolean end;
    private boolean print;
    private Random rand;
    public final static int LINES = 4;
	public final static int ROWS = 8;
	private BoardPrinter debugPrinter;
    private BoardPrinter releasePrinter;
    public int cycleCount;
    public int seed;

	public Game(Level level,int seed) {
		this.seed = seed;
        this.level=level;
		cycleCount = 0;
        printMode = true;
        sManager = new SuncoinManager();
        zManager = new ZombieManager();
        plantList= new GameObjectList();
        zombieList=new GameObjectList();
        rand = new Random(System.nanoTime());
        rand.setSeed(this.seed);
        print = true;
        end=false;
        setLevel(level);
        releasePrinter= new ReleasePrinter(LINES,ROWS,this);
    }
	
	public void setPrintMode(boolean printMode) {
		this.printMode = printMode;
	}
	public void newGame()
	{
		cycleCount = 0;
        printMode = true;
        sManager = new SuncoinManager();
        zManager = new ZombieManager();
        plantList= new GameObjectList();
        zombieList=new GameObjectList();
        rand = new Random(System.nanoTime());
        rand.setSeed(this.seed);
        print = true;
        end=false;
        setLevel(level);
        releasePrinter= new ReleasePrinter(LINES,ROWS,this);
	}
	public void draw() {
		if (print) {
			System.out.println("Number of cycles: " + cycleCount);
			System.out.println("Suncoins: " + getSuncoins());
			System.out.println("Remaining zombies: " + getZombiesLeftToAppear());
			if(printMode)
			{
				System.out.println(releasePrinter.printGame());
			}	
			else
			{
				debugPrinter= new DebugPrinter(1,getNumObjects(),this);
				System.out.println("Level: " + level);
				System.out.println("Seed: " + seed);
				System.out.println(debugPrinter.printGame());
			}
		}
    }
	public int getNumObjects()
	{
		int i=0,j=0;
		i= getZombieListSize();
		j= getPlantListSize();
		i=i+j;
		return i;
	}

    public boolean userWon() {
    	if (zManager.noZombiesLeft() && zombieList.noZombies()) {
    		return true;
    	}
        return false;
    }
    public boolean computerWon() {  
    	if (zombieList.computerWon()) {
    	return true;
    	}
    	return false;
    }
    public boolean addPlant(Plant plant, int x, int y) throws CommandExecuteException{
    	noPrint();
    	plant.setPosX(x);
    	plant.setPosY(y);
    	plant.setGame(this);
    	if(sManager.canBuyPlant(plant.getCost())) {
    		if(!isPlantInPosition(x,y))
    		{
    			sManager.buyPlant(plant.getCost());
        		plantList.addObject(plant);
        		print();
        		return true;
    		}
    		else
    			throw new CommandExecuteException ("Ya hay una planta en esa posicion");
    	}
    	else 
    		throw new CommandExecuteException ("No hay suficientes suncoins para comprar "+ plant.getName());
    }
    public void addZombie() {
        if (zManager.isZombieAdded()) {
            zManager.setZombiesLeftToAppear(zManager.getZombiesLeftToAppear()-1);
            Zombie zombie = ZombieFactory.getZombie();
            zombie.setPosX(rand.nextInt(LINES-1));
            zombie.setPosY(ROWS-1);
            zombie.setGame(this);
            zombieList.addObject(zombie);
        }
    }
    public void update() {
       plantList.update();
       zombieList.update();
       if (!computerWon()) 
    	   addZombie();
       cycleCount++;
       System.out.println(plantList.List[0]);
    }
    public boolean zombieWon() {
    	if (findZombieWinner())
     	   setEnd(true);
        return findZombieWinner();
    }
    
    public boolean findZombieWinner() {
    	boolean winner = false;
    	int i = 0;
    	while (i < LINES && !winner) {
    	if (zombieList.isObjectInPosition(i, 0)) {
    		winner = true;
    		}
    	else {
    		i++;	
    		}
    	}
    	return winner;
    }
    public void write(BufferedWriter bw) throws IOException
	{
		bw.write("Plants Vs Zombies v3.0");
		bw.newLine();
		bw.newLine();
		bw.write("cycle: "+cycleCount);
		bw.newLine();
		bw.write("sunCoins: "+getSuncoins());
		bw.newLine();
		bw.write("level: "+getLevel());
		bw.newLine();
		bw.write("remZombies: "+getZombiesLeftToAppear());
		bw.newLine();
		bw.write("plantList: ");
		plantList.writeObject(bw);
		bw.newLine();
		bw.write("zombieList: ");
		zombieList.writeObject(bw);
	}
    public void read(BufferedReader bf) throws IOException, NumberFormatException, ArgsException
    {
    	//no es mala idea hacer una funcion para inicializar
    	plantList.contador=0;
    	zombieList.contador=0;
    	bf.readLine(); //salta el plants vs zombies v3
    	bf.readLine(); // salta la linea
    	String[] words = bf.readLine().trim().split(" ");
    	String[] allObjects;
    	cycleCount=Integer.parseInt(words[1]);
    	words = bf.readLine().trim().split(" ");
    	setSuncoins(Integer.parseInt(words[1]));
    	words = bf.readLine().trim().split(" ");
    	setLevel(Level.parse(words[1]));
    	words = bf.readLine().trim().split(" ");
    	setZombiesLeftToAppear(Integer.parseInt(words[1]));
    	
    	words = bf.readLine().trim().split(" "); // separa words[0] = "plantlist:" y words[1] lista de plantas
    	allObjects=words[1].split(","); //separa en cada posicion los datos de una planta
    	loadListOfPlants(allObjects); //carga lista de plantas
    	
    	words=bf.readLine().trim().split(" "); //separa "zombielist:" de la lista de zombis
    	allObjects=words[1].split(","); //deja a cada zombie en una posicion
    	loadListOfZombies(allObjects);
    }
    public void loadListOfPlants(String[] allObjects)
    {
    	int res,x,y,cycles,i=0;
    	String[] ObjectInfo;
    	while(i<allObjects.length)
    	{
    		ObjectInfo=allObjects[i].split(":");
    		res=Integer.parseInt(ObjectInfo[1]);
    		x=Integer.parseInt(ObjectInfo[2]);
    		y=Integer.parseInt(ObjectInfo[3]);
    		cycles=Integer.parseInt(ObjectInfo[4]);
    		loadPlant(ObjectInfo[0],res,x,y,cycles);
    		i++;
    	}
    }
    public void loadListOfZombies(String[] allObjects) //Preguntarle a david como coño simplificar esto
    {
    	int res,x,y,cycles,i=0; // hacer esto en listas
    	String[] Object;
    	while(i<allObjects.length)
    	{
    		Object=allObjects[i].split(":");
    		res=Integer.parseInt(Object[1]);
    		x=Integer.parseInt(Object[2]);
    		y=Integer.parseInt(Object[3]);
    		cycles=Integer.parseInt(Object[4]);
    		loadZombie(Object[0],res,x,y,cycles); //load game object esta hecho pero ni idea de como siplificarlo con los factory de por medio
    		i++;
    	}
    }
    public void loadPlant (String plantShortName,int resis, int x, int y, int cycles)
    {
    	Plant p=PlantFactory.getPlant(plantShortName);//metodo
    	p.setResistance(resis);//generalizar
    	p.setPosX(x);
    	p.setPosY(y);
    	p.setCycles(cycles);
    	p.setGame(this);
    	plantList.addObject(p);
    }
    public void loadZombie(String zombieSN, int res , int x , int y, int cycles)
    {
    	Zombie z = ZombieFactory.getZombie(zombieSN);
    	z.setResistance(res);
    	z.setPosX(x);
    	z.setPosY(y);
    	z.setCycles(cycles);
    	z.setGame(this);
    	zombieList.addObject(z);
    }
    public boolean damageZombie(int posX, int posY, int damage)
    {
    	return zombieList.damageObject(posX, posY, damage);
    }
    public void damagePlant(int posX, int posY, int damage) {
		plantList.damageObject(posX, posY, damage);
	}
    public boolean print() {
    	return print = true;
    }
    public boolean noPrint() {
    	return print = false;
    }
    
    public void addCoins(int coins)
    {
    	sManager.addCoins(coins);
    }
    public boolean getPrint() {
    	return print;
    }
	public int getSeed() {
		return seed;
	}
	public boolean getEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public void setPrint(boolean p) {
		print = p;
	}
	 public static int getLINES() {
		return LINES;
	}
	 public static int getROWS() {
		return ROWS;
	}
    public int getZombieListSize()
    {
    	return zombieList.getObjectListSize();
    }
    public int getPlantListSize()
    {
    	return plantList.getObjectListSize();
    }
    public boolean isPlantInPosition(int posX,int posY) {
    	return plantList.isObjectInPosition(posX, posY);
    }
    public boolean isZombieInPosition(int posX,int posY) {
    	return zombieList.isObjectInPosition(posX, posY);
    }
    public String plantToString(int i,int j) {
  	  	return plantList.toString(i,j);
    }
    public String zombieToString(int i,int j) {
    	return zombieList.toString(i,j);
    }
    public int getSuncoins() {
        return sManager.getSunCoins();
    }
    public void setSuncoins(int sun)
    {
    	sManager.setSunCoins(sun);
    }
    public int getZombiesLeftToAppear() {
        return zManager.zombiesLeftToAppear;
    }
    public void setZombiesLeftToAppear(int nZ)
    {
    	zManager.setZombiesLeftToAppear(nZ);
    }
	public String listOfPlants()
	{
		return PlantFactory.infoAvaiablePlants();
	}
	public String listOfZombies() {
	   return ZombieFactory.infoAvailableZombies();
	}
	public boolean getPrintMode() {
		return printMode;
	}
	public GameObject getPlant(int i)
	{
		return plantList.getObject(i);
	}
	public GameObject getZombie(int i)
	{
		return zombieList.getObject(i);
	}
	private void setLevel(Level level) {
			this.level=level;	
			zManager.setFrecuencia(level.getZombieFrequency());
			zManager.setZombiesLeftToAppear(level.getNumberOfZombies());
	}
	public String getLevel()
	{
		return level.name();
	}

	public Game getGame() {
		return this;
	}
}