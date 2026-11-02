import java.util.Scanner;
public class GpaCalculator {
public static void main(String[] args) {
Scanner gr = new Scanner(System.in);
        System.out.println("How many courses are you taking?");
byte n = gr.nextByte();

  double totalgpa = 0;
        
 for (byte count = 1; count <= n; count++)
        {
            System.out.println("Enter the class code, credit hours, and letter grade of course " + count);
String code = gr.next();
byte credit = gr.nextByte();
String grade = gr.next();
double gpa = 0;
