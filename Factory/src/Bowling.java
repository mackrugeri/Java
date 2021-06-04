import java.util.Scanner;

public class Bowling
{

    public static int check_spare_strick_gutter(int a , int b)
    {
        if(a == 10 || b == 10)
        {
            return 1;
        }
        else if(a == 5 || b == 5 )
        {
            return 2;
        }
        if(a == 0 || b == 0)
        {
            return 1;
        }
        return 0;
    }
    public static int Game()
    {
        Scanner input = new Scanner(System.in);
        int rolls[] = new int [21];
        int frame[] = new int [10];
        char strike = 'X'; //<----?
        char spare = '/'; //<-----?
        char gutter = '-'; //<-----?
        int strikes = 10;
        int spares = 5;
        int total = 0;

        //Intro to keep.
        String player;
        System.out.print("Enter player name: ");
        player = input.next();
        System.out.println("----------------------\nBOWLING FRAME FOR " +
                player.toUpperCase() +"\n----------------------\n");
        System.out.println("When entering scores, enter \"X\" for a strike, \"/\" for a spare, and \"-\" for a gutter ball.");
        //End of intro.

        for (int i = 1; i < 10; i=i+2)
        {
            System.out.println("\n----------------------Frame: " + i + "----------------------\n");

            System.out.print("Score for Roll 1: ");
            rolls[i] = input.nextInt();
            System.out.print("Score for Roll 2: ");
            rolls[i+1] = input.nextInt();
            frame[i] = rolls[i] + rolls[i+1];


            int a = check_spare_strick_gutter(rolls[i], rolls[i+1]);
            if (a == 1)
            {
                rolls[i] = 10 + rolls[i] + rolls [i+1];
                System.out.println("YOu have strike");

            }
            if (a == 2)
            {
                rolls[i] = 10 + rolls[i];
                System.out.println("YOu have spare");
            }
            if (a == 3)
            {
                rolls[i] = 0;
                rolls[i=1] = 0;
                System.out.println("YOu have gutter");
            }
        }

        System.out.println("Per Frame goal" + frame[0] + " " + frame[1] + " " + frame[2] + " " + frame[3] + " " + frame[4] + " " + frame[5] + " " + frame[6] + " " + frame[7] + " " + frame[8] + " " + frame[9] + " " );
        for(int i : frame)
        {
            total = total + i;
        }
        System.out.println("Total Score is " + total );
        return total;


    }
    public static void main(String[] args) {
        Game();;
    }
}