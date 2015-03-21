import org.joda.time.Period;
import java.util.Scanner;

/* Some notes about polyphasic sleep cycles:
 * In Everyman3:
 *  Core sleep: 3.5 hours
 *  3 naps, each totaling approximately 18 minutes.
 *  Core to N1: 3.7 hours wake time
 *  N1 to N2: 3.7 hours wake time (not including 18 minute nap time prior)
 *  N2 to N3: 6.2 hours wake time (not including 18 minute nap time prior)
 *  N3 to Core: 6 hours wake time (not including 18 minute nap time prior)
 *
 */


public class Generator {

    public String Generator(int coreSleepHours, int coreSleepMinutes) {

        // Declare/instantiate variables
        final int NAPTIME = 18;
        Scanner scan = new Scanner(System.in);

        Period coreTime = new Period(coreSleepHours, coreSleepMinutes, 0, 0);
        Period timeToFirstAndSecondNap = new Period(3, 42, 0, 0);
        Period timeToThirdNap = new Period(6, 12, 0, 0);
        Period nap1 = new Period(coreTime.plus(timeToFirstAndSecondNap));
        Period nap2 = new Period(nap1.plus(timeToFirstAndSecondNap));
        // Adding 18 minutes to naptime so nap1 time is included to nap2
        nap2 = nap2.plusMinutes(NAPTIME);
        if(nap2.getMinutes() > 60) {
            nap2 = nap2.minusMinutes(60);
            nap2 = nap2.plusHours(1);
        }
        Period nap3 = new Period(nap2.plus(timeToThirdNap));
        nap3 = nap3.plusMinutes(NAPTIME);
        if(nap3.getMinutes() > 60) {
            nap3 = nap3.minusMinutes(60);
            nap3 = nap3.plusHours(1);
        }
        boolean tryAgain = true;

        // Create while loop in order to be able to go back if if/else statement returns invalid
        while(tryAgain) {

            System.out.print("\nDid you want the time in 12 hour or 24 hour format? ");
            int whichFormat = scan.nextInt();
            tryAgain = false;

            // ------------ NAP 1 -------------- //
            if(whichFormat == 12) {
                while (nap1.getHours() > 12) {
                    nap1 = nap1.minusHours(12);
                }
                if (nap1.getMinutes() > 60) {
                    nap1 = nap1.plusHours(1).minusMinutes(60);
                    nap1 = (nap1.getHours() > 12) ? nap1.minusHours(12) : nap1;
                }


            } else if(whichFormat == 24) {
                if(nap1.getMinutes() > 60) {
                    nap1 = nap1.plusHours(1).minusMinutes(60);
                }

            } else {
                System.out.println("You have entered an invalid number! Please try either 12 or 24.");
                tryAgain = true;
            }

            // ------------ NAP 2 -------------- //
            if(whichFormat == 12) {
                while (nap2.getHours() > 12) {
                    nap2 = nap2.minusHours(12);
                }
                if (nap2.getMinutes() > 60) {
                    nap2 = nap2.plusHours(1).minusMinutes(60);
                    nap2 = (nap2.getHours() > 12) ? nap2.minusHours(12) : nap2;
                }
            } else if(whichFormat == 24) {
                if(nap2.getMinutes() > 60) {
                    nap2 = nap2.plusHours(1).minusMinutes(60);
                }
            } else {
                System.out.println("You have entered an invalid number! Please try either 12 or 24.");
                tryAgain = true;
            }

            // ------------ NAP 3 -------------- //
            if(whichFormat == 12) {
                while (nap3.getHours() > 12) {
                    nap3 = nap3.minusHours(12);
                }
                if (nap3.getMinutes() > 60) {
                    nap3 = nap3.plusHours(1).minusMinutes(60);
                    nap3 = (nap3.getHours() > 12) ? nap3.minusHours(12) : nap3;
                }
            } else if(whichFormat == 24) {
                if(nap3.getMinutes() > 60) {
                    nap3 = nap3.plusHours(1).minusMinutes(60);
                }
            } else {
                System.out.println("You have entered an invalid number! Please try either 12 or 24.");
                tryAgain = true;
            }
        }



        return("\nYour sleep schedule is: \nCore Sleep: " + coreTime.getHours() + ":" + coreTime.getMinutes()
                + "\nFirst Nap: " + nap1.getHours() + ":" + nap1.getMinutes() + "\nSecond Nap: " + nap2.getHours() +
                ":" + nap2.getMinutes() + "\nNap Three: " + nap3.getHours() + ":" + nap3.getMinutes());
    }

}