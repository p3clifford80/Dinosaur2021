 


/**
 * Write a description of class Bronta here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bronta extends Dinosaur
{
    // instance variables - replace the example below with your own
    
    public Bronta()
    {
        super("Bronta");
        
    }

    public boolean attack(Dinosaur other)
    {
        boolean result = false;
        if(other.getType().equals("Bronta"))
        {    
            if(Math.random()>0.5)
                result = true;
        }
        else if(other.getType().equals("TRex"))
        {
             if(Math.random()>0.7)
                result = true;
        }
        else if (other.getType().equals("bronta"))
        {
             if(Math.random()>0.6)
                result = true;
        }
        return result; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
     public String toString()
    {
       return this.getType()+" "+ this.getWins() +" "+ this.getBattleCount();
    }
}
