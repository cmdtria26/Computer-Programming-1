import java.util.Random;
import java.util.Scanner;

public class GoblinDoors {

    static final Scanner in = new Scanner(System.in);
    static final Random rng = new Random();

    public static void main(String[] args) {
        System.out.println("=== THE GOBLIN'S DOORS ===");
        System.out.println("A sneaky goblin has stolen your equipment and");
        System.out.println("scurried into a room full of doors. Time to get it back!\n");

        boolean running = true;
        while (running) {
            System.out.println("Select a mode:");
            System.out.println("  1) Tutorial");
            System.out.println("  2) Practice (endless lives)");
            System.out.println("  3) Normal game (3 lives)");
            System.out.println("  4) Quit");

            switch (readInt("> ", 1, 4)) {
                case 1 -> tutorialMode();
                case 2 -> practiceMode();
                case 3 -> normalMode();
                case 4 -> running = false;
            }
            System.out.println();
        }
        System.out.println("Farewell, mage!");
    }

    static void tutorialMode() {
        System.out.println("\n--- TUTORIAL ---");
        System.out.println("You are a mage with 2 X-RAY spells and 1 UNLOCK spell.");
        System.out.println("* X-RAY a door to peek inside. It tells you if the goblin is there.");
        System.out.println("* UNLOCK a door to burst it open. If the goblin is behind it, you win.");
        System.out.println("  But you only get ONE unlock, so make it count!");
        System.out.println("Tip: every empty door you reveal makes the others more likely.\n");

        boolean won = playRound(3, true);
        System.out.println(won ? "Tutorial complete. You're ready!" : "Don't worry, that's what tutorials are for!");
    }

    static void practiceMode() {
        System.out.println("\n--- PRACTICE MODE (no lives, 5 doors) ---");
        int wins = 0, rounds = 0;
        boolean again = true;

        while (again) {
            rounds++;
            if (playRound(5, false)) wins++;
            System.out.println("Record: " + wins + " / " + rounds);
            again = readInt("Play again? (1 = yes, 2 = no): ", 1, 2) == 1;
        }
    }

    static void normalMode() {
        System.out.println("\n--- NORMAL GAME ---");
        int lives = 3;
        final int totalRounds = 5;
        int round = 1;

        while (lives > 0 && round <= totalRounds) {
            int doors = (round <= 2) ? 3 : 5;
            System.out.println("\nRound " + round + "/" + totalRounds
                    + " | Lives: " + lives + " | Doors: " + doors);

            if (playRound(doors, false)) {
                round++;
            } else {
                lives--;
                System.out.println("You lose a life! Lives left: " + lives);
            }
        }

        if (lives > 0) {
            System.out.println("\nYOU WIN! Your equipment is back and the goblin is in a sack.");
        } else {
            System.out.println("\nGAME OVER. The goblin cackles as it escapes with your gear...");
        }
    }

    static boolean playRound(int doors, boolean hints) {
        int goblin = rng.nextInt(doors) + 1; 
        int xrays = 2;
        int unlocks = 1;
        boolean[] cleared = new boolean[doors + 1];
        int foundGoblin = -1;

        System.out.println("\nThe goblin dashes behind one of " + doors + " doors...");

        while (unlocks > 0) {
            System.out.println("\nSpells left -> X-ray: " + xrays + " | Unlock: " + unlocks);
            System.out.println("Doors: " + doorStatus(doors, cleared, foundGoblin));

            int action;
            if (xrays > 0) {
                action = readInt("1) X-ray  2) Unlock > ", 1, 2);
            } else {
                System.out.println("No X-rays left. Time to unlock a door!");
                action = 2;
            }
            int door = readInt("Which door (1-" + doors + ")? ", 1, doors);

            if (action == 1) {
                xrays--;
                if (door == goblin) {
                    foundGoblin = door;
                    System.out.println("X-RAY: You see the goblin's silhouette behind door " + door + "!");
                    if (hints) System.out.println("(Hint: now UNLOCK that door!)");
                } else {
                    cleared[door] = true;
                    System.out.println("X-RAY: Door " + door + " is empty.");
                    if (hints) {
                        System.out.println("(Hint: one fewer suspect! Unlocking a "
                                + "cleared door would waste your only unlock.)");
                    }
                }
            } else {
                unlocks--;
                if (door == goblin) {
                    System.out.println("CRASH! You blast door " + door + " open and grab the goblin!");
                    return true;
                }
                System.out.println("CRASH! Door " + door + " is empty. The goblin was behind door "
                        + goblin + ".");
            }
        }
        return false;
    }

    static String doorStatus(int doors, boolean[] cleared, int foundGoblin) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= doors; i++) {
            String state = (i == foundGoblin) ? "GOBLIN" : cleared[i] ? "empty" : "?";
            sb.append("[").append(i).append(":").append(state).append("] ");
        }
        return sb.toString();
    }

    static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = in.nextLine().trim();
            try {
                int n = Integer.parseInt(line);
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("Please enter a number from " + min + " to " + max + ".");
        }
    }
}