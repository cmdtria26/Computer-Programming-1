import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your complete name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        input.nextLine();

        System.out.print("Enter your course: ");
        String course = input.nextLine();

        System.out.print("Enter your year level: ");
        int yearLevel = input.nextInt();

        System.out.print("Enter your section (ex. A): ");
        char section = Character.toUpperCase(input.next().charAt(0));

        System.out.print("Enter your average grade: ");
        float aveGrade = input.nextFloat();

        System.out.print("Enter your middle initial: ");
        char middleInitial = Character.toUpperCase(input.next().charAt(0));

        System.out.print("Are you currently enrolled? (true/false): ");
        boolean isEnrolled = input.nextBoolean();

        //Hi, Sir RK!

        String status = "";
        switch (String.valueOf(isEnrolled)) {
            case "true":
                status = "TRUE";
                break;
            default:
                status = "FALSE";
                break;
        }

        //There are 27 equal signs. There are 4 spaces before STUDENT INFORMATION.

        System.out.println("\n===========================" + "\n    STUDENT INFORMATION" + "\nName: " + name + "\nAge: " + age + "\nCourse: " + course + "\nYear Level: " + yearLevel + "\nSection: " + section + "\nAverage Grade: " + aveGrade + "\nMiddle Initial: " + middleInitial + "." + "\nCurrently Enrolled: " + status + "\n==========================");
        
        input.close();
    }
}
