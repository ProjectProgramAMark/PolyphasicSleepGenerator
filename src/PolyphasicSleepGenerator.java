import java.util.Scanner;

/* Author: Mark Moussa
 * Purpose: To plan out a polyphasic sleep cycle without going crazy
 * trying to plan around your schedule.
 */
public class PolyphasicSleepGenerator {
    public static void main(String[] args) {

        // Declare variables to pass into Generator class and create class instance
        Generator gen = new Generator();
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the hour you want to core sleep? ");
        int coreSleepHours = scan.nextInt();
        System.out.print("\nWhat is the number of minutes into the hour that you want to core sleep? ");
        int coreSleepMinutes = scan.nextInt();
        while(coreSleepMinutes > 60) {
            System.out.println("Number of minutes over 60! Please enter a valid amount of number of minutes: ");
            coreSleepMinutes = scan.nextInt();
        }
        System.out.println(gen.Generator(coreSleepHours,coreSleepMinutes));


    }
}
