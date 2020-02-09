package com.royalbuffalo;

import java.util.*;

public class Main {

    public static void main(String[] args) {

         // How many sides on each die?
        int sides = getSides();
        // How many dice to roll?
        int diceNo = getDiceNo();
        // How many times to roll?
        int timesRoll = getTimesRoll();

        Dice[] myDice = createDice(sides, diceNo);

        getAndPrintAllScores(timesRoll, myDice);

    }

    private static void getAndPrintAllScores(int timesRoll, Dice[] myDice) {
        for (int i = 0; i < timesRoll; i++) {
            // roll the dice
            for (Dice die : myDice) die.roll();

            // get the scores list
            int[] myRolledDice = getCurrentDiceScores(myDice);

            // do the score math
            int totalScore = getTotalScore(myRolledDice);

            outputResultString(myRolledDice, totalScore);
        }
    }

    private static int getTimesRoll() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many times do you want to roll? ");
        String timesRollIn = in.nextLine();
        return Integer.parseInt(timesRollIn);
    }

    private static void outputResultString(int[] myRolledDice, int totalScore) {
        StringBuilder sb = new StringBuilder();
        sb.append("yahtzee_upper([");
        for (int score : myRolledDice) sb.append(score + ", ");
        sb.setLength(sb.length() - 2);
        sb.append("]) => ");
        sb.append(totalScore);
        System.out.println(sb);
    }

    private static int getTotalScore(int[] myRolledDice) {
        HashMap<Integer, Integer> scorePairs = getArrayElementCount(myRolledDice);
        Iterator hmIterator = scorePairs.entrySet().iterator();
        int totalScore = 0;
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            int pointsValue = ((int)mapElement.getKey());
            int timesAppeared = ((int)mapElement.getValue());
            if (pointsValue * timesAppeared > totalScore) totalScore = pointsValue * timesAppeared;
//            System.out.println("Points: " + pointsValue + " * " + timesAppeared + " = " + pointsValue * timesAppeared);

        }
        return totalScore;
    }

    private static int[] getCurrentDiceScores(Dice[] myDice) {
        // put the scores in an array
        int myRolledDice[] = new int[myDice.length];
        for (int i = 0; i < myRolledDice.length; i++) myRolledDice[i] = myDice[i].getCurrentSideUp();
        return myRolledDice;
    }

    private static Dice[] createDice(int sides, int diceNo) {
        // Create diceNo # array of dice myDice
        Dice[] myDice = new Dice[diceNo];

        // Create each Dice object with sides-sided die
        for (int i = 0; i < myDice.length; i++) {
            myDice[i] = new Dice(sides);
        }
        return myDice;
    }

    private static int getDiceNo() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many dice do you want to roll? ");
        String diceNoIn = in.nextLine();
        return Integer.parseInt(diceNoIn);
    }

    private static int getSides() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many sides do you want on each die? ");
        String sidesIn = in.nextLine();
        return Integer.parseInt(sidesIn);
    }

    static HashMap<Integer, Integer> getArrayElementCount(int inputArray[])
    {
        //Creating a HashMap object with elements of inputArray as keys and their count as values

        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

        //checking every element of the inputArray

        for (int i : inputArray)
        {
            if(elementCountMap.containsKey(i))
            {
                //If element is present in elementCountMap, incrementing it's count by 1

                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else
            {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as its value

                elementCountMap.put(i, 1);
            }
        }

        return elementCountMap;
    }


}
