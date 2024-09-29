//TASK-1


//**********************************************************************************


import java.util.Scanner;

public class StudentGradeCalculator {
    
    // Method to calculate the grade based on percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: Take the number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();
        
        double[] marks = new double[subjects];
        double totalMarks = 0;
        
        // Input: Collect marks for each subject
        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
            totalMarks += marks[i];  // Calculate total marks
        }
        
        // Calculate average percentage
        double averagePercentage = totalMarks / subjects;
        
        // Calculate grade based on the average percentage
        String grade = calculateGrade(averagePercentage);
        
        // Output: Display total marks, average percentage, and grade
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
