package logic.Lists;
import java.io.BufferedWriter;
import java.io.IOException;

import logic.Objects.GameObject;

public class GameObjectList {

	public GameObject[] List;
    public int contador;

 public GameObjectList() {
	 contador=0;
	 List=new GameObject[30];
 }
 public GameObjectList clone()
 {
	 GameObjectList g = new GameObjectList();
	 g.List=List;
	 g.contador=contador;
	 return g;
 }
 
 public void addObject(GameObject gameObject) {
     List[contador] = gameObject;
     contador++;
 }
 public void writeObject(BufferedWriter bw) throws IOException
 {
	 for(int i=0;i<contador;i++)
	 {
		 if(i==contador-1)
				bw.write(List[i].writeString());
			else
				bw.write(List[i].writeString()+",");
	 }
 }
 
 public int objectCounterInPosition(int posX,int posY) {
	 int i = 0;
	 boolean encontrado = false;
	 while(i<contador && !encontrado)
	  {
		  if(List[i].getPosX()==posX && List[i].getPosY() == posY )
		  {
			  encontrado=true;
		  }
		  if(!encontrado)
		  i++;
	  }
	 if(!encontrado) {
		 return i = -1;
	 }
	 return i;
 }
 public void kill(int x, int y)
 {
	 int i= objectCounterInPosition(x,y);
	 eliminateObject(i);
 }
 
 
 public void findAndEliminateDeadObject() {
	 for(int i=0; i<contador;i++)
	 {
		 if(!List[i].isAlive())
			 eliminateObject(i);
	 }
 }
 
 public void eliminateObject(int i) {
	 List[contador] = null;
	 if(contador > 0) {
		 while(i < contador) {
			 List[i] = List[i+1];
			 i++;
		 }
		 contador--;
	 }
 }
  public void update()
     {
      for(int i=0;i<contador;i++)
      {
    	  List[i].update();
      }
      findAndEliminateDeadObject();
     }
  public GameObject getObject(int i)
  {
	  return List[i];
  }
  public GameObject getObjectInPosition(int posX, int posY)
  {
	  boolean encontrado=false;
	  int i=0;
	  GameObject object=null;
	  while(i<contador && !encontrado)
	  {
		  if(List[i].getPosX()==posX && List[i].getPosY() == posY )
		  {
			  encontrado=true;
			  object=List[i];
		  }
		  i++;
	  }
	  return object;
  }
  public boolean isObjectInPosition(int posX,int posY) {
	  boolean found=false;
	  int i=0;
	  while(i<contador && !found)
	  {
		  if(List[i].getPosX() == posX && List[i].getPosY() == posY)
		  {
			  found=true;
		  }
		  i++;  
	  }
	  return found;
  }
  public String toString(int i, int j) {
  	return getObjectInPosition(i,j).toString();
  }
  
  public String debugString(int i,int j) {
	  return getObjectInPosition(i,j).debugString();
  }
  
  
  public int getObjectListSize()
  {
	  return contador;
  }

  public boolean damageObject(int posX, int posY, int damage) {
	  int i= objectCounterInPosition(posX,posY);
	  if(i!=-1)
	  {
		  List[i].damageObject(damage);
		  return true;
	  }
	  return false;
  }
  
  public boolean computerWon() {
      for (int i = 0; i < List.length; i++) {
          if (List[i] != null && List[i].getPosY() == 0) {
              return true;
          }
      }
      return false;
  }
  
  public boolean noZombies() {
	  return contador == 0;
  }

public boolean freezeZombie(int posX, int posY) {
	int i= objectCounterInPosition(posX,posY);
	  if(i!=-1)
	  {
		  List[i].freeze();
		  return true;
	  }
	  return false;
}
}