import java.util.Scanner;
public class GpaCalculator {
public static void main(String[] args) {
Scanner gr = new Scanner(System.in);
        System.out.println("How many courses are you taking?");
byte n = gr.nextByte();

  double totalgpa = 0;
        
 for (byte count = 1; count <= n; count++)
        {
            System.out.println("Enter the class credit hours, and the letter grade of course " + count);

byte credit = gr.nextByte();
String grade = gr.next();
double gpa = 0;

        // Think we should use cases for each of the grades instead of a bunch of if elses//
        
