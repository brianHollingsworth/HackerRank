/**
 * TimeConversion.java
 *
 * - In this problem, I am given time in AM/PM format. Convert this into a
 *   24-hour format.
 * - Input: Time in the AM/PM format i.e. hh:mm:ssAM or hh:mm:ssPM where 
 *          01≤hh≤12 
 *          00≤mm≤59 
 *          00≤ss≤59
 * - Output: The time in 24 hour format i.e. hh:mm:ss where 
 *           00≤hh≤23 
 *           00≤mm≤59 
 *           00≤ss≤59
 *
 * Example:
 * Input -> 07:05:45PM
 * Output -> 19:05:45
 */

import java.io.*;
import java.util.*;

public class TimeConversion {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String time = sc.nextLine();
      String timeArray[] = time.split(":");
      char amOrPM = timeArray[2].charAt(2);
      int hour = Integer.parseInt(timeArray[0]);

      if (amOrPM == 'p' || amOrPM == 'P') {
         if (hour < 12) {
            hour += 12;
         }
         System.out.println(hour + ":" + timeArray[1] + ":" + timeArray[2].charAt(0) + timeArray[2].charAt(1));
      }
      else {
         if (hour == 12) {
            hour -= 12;
         }
         System.out.println(String.format("%02d", hour) + ":" + timeArray[1] + ":" + timeArray[2].charAt(0) + timeArray[2].charAt(1));
      }
   }
}