/**
 * We will be given a partially completed code in the editor where the main
 * method takes the name of a state (i.e., WestBengal, or AndhraPradesh) and
 * prints the national flower of that state using the classes and methods
 * written by us. Implement the classes and methods detailed in the diagram on:
 * https://www.hackerrank.com/challenges/java-covariance/problem
 *
 * Input Format: The locked code reads a single string denoting the name of a
 *               subclass of State (i.e., WestBengal, Karnataka, or
 *               AndhraPradesh), then tests the methods associated with that
 *               subclass. You are not responsible for reading any input from
 *               stdin.
 *
 * Output Format: Output is handled for you by the locked code, which creates
 *                the object corresponding to the input string's class name and
 *                then prints the name returned by that class' national flower's
 *                whatsYourName method. You are not responsible for printing
 *                anything to stdout.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
  public String whatsYourName() {
    return "I have many names and types.";
  }
}

class Jasmine extends Flower {
  @Override
  public String whatsYourName() {
    return "Jasmine";
  }
}

class Lily extends Flower {
  @Override
  public String whatsYourName() {
    return "Lily";
  }
}

class Region {
  public Flower yourNationalFlower() {
    return new Flower();
  }
}

class WestBengal extends Region {
  public Flower yourNationalFlower() {
    return new Jasmine();
  }
}

class AndhraPradesh extends Region {
  public Flower yourNationalFlower() {
    return new Lily();
  }
}


public class JavaCovariantReturnTypes {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}