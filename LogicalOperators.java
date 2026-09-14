import java.util.Scanner;
public class LogicalOperators {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        boolean allRulesPassed = false;
        boolean rule1= false , rule2 = false;
        boolean rule12 = rule1 && rule2;
        System.out.println("=========================================");
        System.out.println("           THE PASSWORD GAME");
        System.out.println("=========================================");
        System.out.println("Your password must satisfy ALL 10 rules.\n");
    
  while (!allRulesPassed) {
  	System.out.println ("Enter a password: ");
  	String password = scanner.nextLine();
  	
  	while (!rule12){
  	  	int passwordLength = password.length();
  		if (passwordLength >= 8) { 
  		rule1 = true;
  		}
  		else { System.out.println ("The password is too short, please try again");
  		break;
  		}
        	if (passwordLength >= 30) { System.out.println ("The password is too long, please try again");
        	break;
        	}
        	else {
        	rule2 = true;
        	}
        	rule12 = rule1 && rule2;
        	allRulesPassed = rule12;
        if (allRulesPassed == true) { System.out.println ("We have a winner, unfortunately");
        break;        
        }
       }
  }
  scanner.close();
  }
}
