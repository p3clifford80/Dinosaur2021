 


/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health;// a range between 0 - 100
    private int wins;
    private int battleCount;
    private static int population;

    

    

    /**
     * Default constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        this.type = "Dino";
        this.age = 0;

        // write code that will assign a gender to this dino. 
        // 50% should be male and 50% should be female. 
        if(Math.random() < 0.5)
            this.gender = "M";
        else
            this.gender = "F";
        
        this.health = 10;
    }
    
    /**
     * Explicit constructor for the Dino class.
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.health = 10;
        // write code to set gender to m/f 50%.
        if(Math.random() < 0.5)
            this.gender = "M";
        else
            this.gender = "F";
      
        this.wins = 0;
        this.battleCount = 0;
        Dinosaur.population++;
  
    }

    /*********    Getters  *****************/
    // Getters return the private instance data.
    public String getType()
    {
        return this.type;
    }
    
    public static int getPopulation()
    {
        return Dinosaur.population;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
     public int getAge()
    {
        return this.age;
    }
    public int getWins()
    {
        return this.wins;
    }
    
    public int getHealth()
    {
        return this.health;
    }
    
    public int getBattleCount()
    {
        return this.battleCount;
    }
    
    public static int getPop()
    {
        return population;
    }
    
    /*********    Setters  *****************/
    
    public void setType(String t)
    {
        this.type = t;
    }
    
    public static void setPopulation(int p)
    {
        Dinosaur.population = p;
    }
    
    public void setAge(int a)
    {
        this.age = a;
    }
    
    public void setHealth(int h)
    {
        this.health = h;
    }
    
   public void setWins(int w)
    {
        this.wins = w;
    }
    public void setBattleCount(int bc)
    {
        this.battleCount = bc;
    }
    
    public boolean equals(Dinosaur d)
    {
        // write code that will return true if two dinos are "equal"
        // return true if they're equal, false otherwise.
        boolean same = false;
        if( this.type.equals(d.type))
        {
            if( this.gender.equals(d.getGender()))
            {
                int healthDiff = this.health - d.getHealth();
                if( Math.abs(healthDiff) < 10)
                    same = true;
            }
        }
        return same;
    }
    
    public void ageUp()
    {
        if(this.health > 0) // the dino is alive
        {
            this.age++;
            
            // if age is less than 10, health increases by 10
            if( this.age < 10 )
                this.health = this.health + 10;
            // No change to health if age is 10 and 24
            
            // Health decrease by 5 if age is between 25 and 30
            else if ( this.age >=25 && this.age <=30)
                this.health-=5;
            // Health decreases by 10 if age is greater than 30
            else if ( this.age >30)
                this.health-=10;
        }
        
    }    
    
    public double getBattleFactor(Dinosaur other)
    {
        double answer = 0;
        double hFactor = this.health/100.0;
        double expFactor = 0;
        hFactor *= 0.67;
        
        // Avoid /0 error if both battleCounts equal 0.
        if(this.battleCount + other.getBattleCount() >  0) 
        {  
            expFactor = (double)this.battleCount/(this.battleCount + other.getBattleCount());
            expFactor *= 0.33;
        }
        
        answer = hFactor + expFactor;
        
        return answer;
    }
    
    public void update(Dinosaur loser)
    {
        // reduce the health of the losing dino
        // ??? Reduce the health of the winner by a little
        // increase the wins for "this" dino. 
        // increase battleCount for both
        
        loser.setHealth(loser.getHealth()-20);
        
        
        // Write code that will reset health to zero if health goes neg
        if( loser.getHealth()<=0)
        {
            loser.setHealth(0);
            Dinosaur.population--;
        }
        
        this.wins++;
        this.battleCount++;
        
        loser.setBattleCount(loser.getBattleCount()+1);
        
        
    }
    
    public abstract boolean attack(Dinosaur other);
    
    
    /**
     * Return this Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.health+ " "+this.gender+ " "+this.wins+ " "+this.battleCount;
        return answer;
    }
}
