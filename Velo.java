 


/**
 * Write a description of class Velo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Velo extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten;

    /**
     * Constructor for objects of class Velo
     */
    public Velo()
    {
        super("Velo");
        this.numEaten = 0;
    }
    public boolean attack(Dinosaur other)
    {
     boolean result = false;
        if(other.getType().equals("Velo"))
        {    
            if(Math.random()>0.5)
                result = true;
        }
        else if(other.getType().equals("TRex"))
        {
             if(Math.random()>0.55)
                result = true;
        }
        else if (other.getType().equals("bronta"))
        {
             if(Math.random()>0.25)
                result = true;
        }
        return result; 
    }
    
     public String toString()
    {
       return this.getType()+" "+ this.getWins() +" "+ this.getBattleCount();
    }
}
