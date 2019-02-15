/**
 * In this problem, you are given an interface Food. There are two classes Pizza
 * and Cake which implement the Food interface, and they both contain a method
 * getType().
 * The main function in the Main class creates an instance of the FoodFactory
 * class. The FoodFactory class contains a method getFood(String) that returns a
 * new instance of Pizza or Cake according to its parameter.
 *
 * Input Format: cake
 *
 * Output Format: The factory returned class Cake
 *                Someone ordered a Dessert!
 */

import java.util.*;
import java.security.*;

interface Food {
  public String getType();
}

class Pizza implements Food {
  public String getType() {
    return "Someone ordered Fast Food!";
  }
}

class Cake implements Food {
  public String getType() {
    return "Someone ordered a Dessert!";
  }
}

class FoodFactory {
  public Food getFood(String order) {
    // Write your code here
    Food food = null;
    switch(order) {
      case "pizza":
        food = new Pizza();
        break;
      case "cake":
        food = new Cake();
        break;
      default:
        break;
    }

    return food;
  } // End of getFood method
} // End of factory class

public class JavaFactoryPattern {
  
  public static void main(String arg[]) {
    Do_Not_Terminate.forbidExit();

    Scanner sc = null;
    try {
      sc = new Scanner(System.in);

      // Creating the factory
      FoodFactory foodFactory = new FoodFactory();

      // Factory instantiates an object.
      Food food = foodFactory.getFood(sc.nextLine());

      System.out.println("The factory returned " + food.getClass());
			System.out.println(food.getType());
    } catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
    } finally {
      sc.close();
    }
  }
}

class Do_Not_Terminate {
  public static class ExitTrappedException extends SecurityException {
    private static final long serialVersionUID = 1L;
  }

  public static void forbidExit() {
    final SecurityManager securityManager = new SecurityManager() {
      @Override
      public void checkPermission(Permission permission) {
        if (permission.getName().contains("exitVM")) {
          throw new ExitTrappedException();
        }
      }
    };
    System.setSecurityManager(securityManager);
  }
}
