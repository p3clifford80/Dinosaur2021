
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        //Dinosaur[] pop = new Dinosaur[25];
        
        // Create an arrayList of dinos called dinoPop.
        List<Dinosaur> dinoPop = new ArrayList<Dinosaur>();
        
        for( int i = 0; i< 30; i++ ) 
        {
            double rand = Math.random();
            if(rand < 0.33)// make a TRex
            {
                Dinosaur t = new TRex();
                dinoPop.add(t);
            }
            else if ( rand < 0.67 ) // make a Velo
            {
                dinoPop.add(1, new Velo());
            }
            else // make Bronta
            {
                dinoPop.add(new Bronta());
            }
        }
        
        
/*
        for(int i =0; i< pop.length; i++)
        {
            // double rand = Math.random();// random decimal
            // if(rand < 0.33 ) 
            pop[i] = new TRex();
            // else if ( rand < 0.67 )
            // {
            // pop[i] = new Velo();
            // }
            // else 
            // pop[i] = new Bronta();
            DinoDriver2.growUp(pop[i]);
            System.out.println(pop[i]);
        }
 */

        // int rnd = 1; 
        while(Dinosaur.getPop() > 1)
        // {
            // System.out.println(" ################ Round "+(rnd) +" ###################");
            // DinoDriver2.battleRound(pop);
            // rnd++;
        // }
        
        
        for(int i = 0; i < 9; i ++)
        {
            System.out.println(" ################ Round "+(i+1) +" ###################");
          //  DinoDriver2.battleRound(pop);
        }

        //Output  my population
        //for(int i = 0; i< pop.length; i++)
        for( Dinosaur d : dinoPop )// d gets assigned to pop[i];
        {
            //if(d.getHealth() > 0 )
            System.out.println(d);
        }    
    }

    private static void battleRound(ArrayList<Dinosaur> p )
    {
        /*
        // Modify this code to call the update method with the correct
        // dinos winning and losing.
        System.out.println("\t"+p[0]);
        System.out.println("\t"+p[1]);

         */
        int attWins = 0;
        int battles = 0;
        // Traverse the array, and have all dino battle one other random dino.
        for( Dinosaur d : p )
        {
            // Test if the attacking dino is alive
            if( d.getHealth() > 0 )
            {
                int rand;

                // Write an if statement that tests if def is dead OR
                // def is the same as the attacking dino

                
                int x = 0;
               
                do
                {
                    rand = (int)(Math.random()*p.size());
                }while( p.get(rand).getHealth() == 0 || p.get(rand) == d );

                battles++;
                //boolean attackerWon = d.attack(p[rand]);
                if(d.attack(p.get(rand)))
                {
                    d.update(p.get(rand));
                    attWins++;
                }
                else
                    p.get(rand).update(d);
            }// A given battle is over
        }// round is over
        System.out.println( "**************   Total battles "+battles +" & attacker wins "+ attWins);
    }

    private static void growUp(Dinosaur d)// d = t1, the are aliases
    {
        int rand = (int)(Math.random()*35);
        //d.setBattleCount(rand);
        for(int i = 0; i < rand; i++)
            d.ageUp();    
    }

    
}
