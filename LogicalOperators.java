import java.util.Scanner;
public class LogicalOperators {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        boolean allRulesPassed = false;
        System.out.println("=========================================");
        System.out.println("           THE PASSWORD GAME");
        System.out.println("=========================================");
        System.out.println("Your password must satisfy ALL 10 rules.\n");
    
  while (!allRulesPassed) {
    // remove this if you don't like it
    int attemptRule1 = 0;
    while (attemptRule1 == 0){
    System.out.println ("Enter password");
    String lenghtPassword = scanner.nextLine();
    if (lenghtPassword.length () >=8) { 
    System.out.println ("Rule 1: Passed ");
    attemptRule1++;
    }
    else { System.out.println ("Password is too short, try again");
         }
  }
  }
    if (allRulesPassed) {
                System.out.println("\nAll 10 rules satisfied! You win the Password Game.");
            } else {
                System.out.println("\nNot quite. Fix the FAILed rules and try again!\n");
            }

    scanner.close();
        }
  }

