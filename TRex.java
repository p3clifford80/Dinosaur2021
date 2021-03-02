/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten; //  specific to the TRex class and not Dinosaur

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {    
        //super() --> Must be the first line of a constructor
        super("TRex"); // Calls the explicit constructor of the parent class       
        this.numEaten = 0;
        
        
    }
    
    
    
    public boolean attack(Dinosaur other)
    {
        
        int myRand = (int)(Math.random()*40)+60;
        int otherRand;
        
        int myWeighting;
        int otherWeighting; 
        
        double temp; 
        
        
        if(other.getType().equals("TRex")) // TRex vs TRex
        {    
            otherRand = (int)(Math.random()*40)+55;
        }
        else if(other.getType().equals("Velo")) // TRex vs Velo
        {
              otherRand = (int)(Math.random()*40)+50;
        }
        else if (other.getType().equals("bronta"))
        {
              otherRand = (int)(Math.random()*40)+40;
        }
        else 
            otherRand = (int)(Math.random()* 50);
        
        temp = myRand * this.getBattleFactor(other)+0.5;
        myWeighting = (int)(temp);
        temp = otherRand * other.getBattleFactor(this) + 0.5;
        otherWeighting = (int)(temp);
        
        System.out.println("\tMy weighting: "+myWeighting);
        System.out.println("\tOther weighting: "+otherWeighting);        
        
        
        if( myWeighting - otherWeighting  > -1)
        {
           return true;
            
        }
        else
        {    
            return false;
        }
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
       // return this.getType()+" "+ this.getWins() +" "+ this.getBattleCount()+ "  "+this.getHealth();
       return this.getType()+" "+this.getAge()+" "+this.getHealth();
    }
}