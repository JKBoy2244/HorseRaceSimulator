import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;


class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;
    private Horse horseWinner;

    public Race(int distance) {
        // initialise instance variables
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
        horseWinner = null;
    }


    /** The addHorse method is the method which checks the lane numbers to see if they are available and if they are, adds each of the horses to their respective lane numbers.
    */
    
    public void addHorse(Horse theHorse, int laneNumber)
    {
        if (laneNumber == 1)
        {
            lane1Horse = theHorse;
        }
        else if (laneNumber == 2)
        {
            lane2Horse = theHorse;
        }
        else if (laneNumber == 3)
        {
            lane3Horse = theHorse;
        }
        else
        {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }

    /**
     This method starts the race of the horses where the horses move forward constantly until they reach the finish line. If one horse reaches the finish line before the others, the race finishes/ends.
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;

        //Sets all the horses to 0 at the start and fallen = false since race hasn't started.
        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();

        while (!finished)
        {

            //move each horse

            //It first checks for each 3 horse lanes whether the horse has started moving or not and if it hasnt because it's still in the starting position of distance 0, the program calls the moveHorse method to prompt the horses to start moving for each respective lane.
            if (lane1Horse != null) { 
               moveHorse(lane1Horse);
            } 
            if (lane2Horse != null) {
               moveHorse(lane2Horse);
            }
            if (lane3Horse != null) {
               moveHorse(lane3Horse);
            }   

            //print the race positions
            printRace();

            //if any of the three horses has won the race is finished and there isn't a winner yet.
            if ( raceWonBy(lane1Horse) || raceWonBy(lane2Horse) || raceWonBy(lane3Horse) )
            {
                finished = true;
            }

            //displays the winner of the horse race by checking first if there's no winner yet and the horse was the first out of the 3 to reach the end of the track. 
            if (raceWonBy(lane1Horse) && horseWinner == null) {
                System.out.println("The winner is " + lane1Horse.getName() + " at first place!");
            }
            else if (raceWonBy(lane2Horse) && horseWinner == null) {
                System.out.println("The winner is " + lane2Horse.getName() + " at first place!");
            }
            else  if (raceWonBy(lane3Horse) && horseWinner == null) {
                System.out.println("The winner is " + lane3Horse.getName() + " at first place!");
            } else {

                System.out.println("There's no winner!");
            }

            //wait for 200 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(200);
            }catch(Exception e){}
        }
    }

    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }

            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }

    /** 
     Checks if the horse potentially wins the race by seeing if the total distance travelled by the horse is the same as the length of the track, if yes it returns true saying yes potentially. Otherwise, it returns false.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window

        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();

        printLane(lane1Horse);
        System.out.println();

        printLane(lane2Horse);
        System.out.println();

        printLane(lane3Horse);
        System.out.println();

        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }

    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        //print a | for the beginning of the lane
        System.out.print('|');

        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);

        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('❌');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }

        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);

        //print the | for the end of the track
        System.out.print('|');
    }


    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
