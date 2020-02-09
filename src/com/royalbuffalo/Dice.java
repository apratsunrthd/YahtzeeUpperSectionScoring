package com.royalbuffalo;

import java.util.Random;

/**
 * Class for simulating a die
 * (an object "rolled" to generate a random number)
 *
 * @author Owen Astrachan
 * @modifiedBy Brad Lumley
 */
public class Dice
{
//    private int myRollCount;   // # times rolled
    private int mySides;       // # sides
    private Random myRandGen;  // the random number generator
    private int currentSideUp; // which side of the die is up right now?


    /**
     * Construct standard six-sided Dice object
     */

    public Dice()
    {
        this(6);
    }

    /**
     * Constructs a Dice object.
     * @param sides specifies the number of "sides" for the die, e.g., 
     * 2 is a coin, 6 is a "regular" die.
     */
    public Dice(int sides)
    {
//        myRollCount = 0;
        mySides = sides;
        myRandGen = new Random();
        currentSideUp = myRandGen.nextInt(mySides) + 1;
    }

    /**
     * Returns the random "roll" of the die, a uniformly distributed 
     * random number in the range [1..numSides()].
     * @return a random value in range [1..numSides()]
     */
    public int roll()
    {
//        myRollCount++;
        currentSideUp = myRandGen.nextInt(mySides) + 1;
        return currentSideUp;
    }

    /*
     * Returns number of sides of die
     * @return number of sides of this dice object
     */

    public int numSides()
    {
        return mySides;
    }

    /*
     * Returns number of times this die object has been rolled.
     * @return number of times dice object rolled
     */

//    public int numRolls()
//    {
//        return myRollCount;
//    }

    /**
     * Returns a string representing this Dice object
     */

    public String toString()
    {
        return "# sides: " + numSides() + " # rolls: ";
    }

//    public static void main(String[] args)
//    {
//        Dice die = new Dice(6);
//
//        for(int k = 0; k < 100; k++)
//        {
//            int roll = die.roll();
//            System.out.println("roll " + die.numRolls() + ": " + roll);
//        }
//    }


    public int getCurrentSideUp() {
        return currentSideUp;
    }
}