
package studentgradecalculator;
import java.util.Scanner;

public class Studentgradecalculator {

  
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

//        Array for the subject names
        String[] allsubjects = {"Java", "Python", "C++", "Dbms", "D.Analyst"};
        int[] marks = new int[allsubjects.length];
        
        int ttlmrk = 0;

        for (int i = 0; i < allsubjects.length; i++) {
            System.out.print("Enter marks in " + allsubjects[i] + " (out of 100): ");
            marks[i] = scanner.nextInt();
//            Sum up the marks obtained in all subjects.
           ttlmrk += marks[i]; 
        }

//         Marks Printing
        System.out.println("\nMarks in each subject:");
        for (int i = 0; i < allsubjects.length; i++) {
            System.out.println(allsubjects[i] + ": " + marks[i]);
        }
        System.out.println("\nTotal marks:" + ttlmrk);
//        Divide the total marks by the total number of subjects to get the
//average percentage
        double averagePercentage = (double) ttlmrk / allsubjects.length;
        System.out.println("Average percentage: " + averagePercentage + "%");
        
//         Assign grades based on the average percentage achieved
         String gradeOfStudent;
        if (averagePercentage >= 90) {
            gradeOfStudent = "A";
        } else if (averagePercentage >= 80) {
            gradeOfStudent = "B";
        } else if (averagePercentage >= 70) {
            gradeOfStudent = "C";
        } else if (averagePercentage >= 60) {
            gradeOfStudent = "D";
        } else {
            gradeOfStudent = "F";
        }

        System.out.println("Grade: " + gradeOfStudent);
//        Show the total marks, average percentage, and the corresponding grade to the user.
        System.out.println("\n----------All Details-----------");
        System.out.println("Total Marks: " + ttlmrk);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + gradeOfStudent);

        scanner.close();
    }
    
}
