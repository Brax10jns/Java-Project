import java.util.Scanner;
public class GpaCalculator {
public static void main(String[] args) {
Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of courses");
byte n = kb.nextByte();
        
        double totalgpa = 0;
        
        for (byte count = 1; count <= n; count++)
        {
            System.out.println("Enter the code, credit hours, and letter grade of course " + count);
String code = kb.next();
byte credit = kb.nextByte();
String grade = kb.next();
double gpa = 0;

            if (grade.equals("A+")) {
                gpa = 4.0;
            }
            else if (grade.equals("A")) {
                gpa = 3.5;
            }
            else if (grade.equals("B+")) {
                gpa = 3.0;
            }
            else if (grade.equals("B")) {
                gpa = 2.5;
            }
            else if (grade.equals("C+")) {
                gpa = 2.0;
            }
            else if (grade.equals("C")) {
                gpa = 1.5;
            }
            else if (grade.equals("D+")) {
                gpa = 1.0;
            }
            else if (grade.equals("D")) {
                gpa = 0.5;
            }
            else if (grade.equals("F")) {
                gpa = 0;
            }
            totalgpa += gpa;
        }
        System.out.println(totalgpa / n);
    }
}    