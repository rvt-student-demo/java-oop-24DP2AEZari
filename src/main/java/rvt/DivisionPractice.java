package rvt;
import java.util.Scanner;

public class DivisionPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter the numerator: ");
            String numerator = scanner.nextLine();
            
            if (numerator.equals("quit")) {
                break;
            }
            
            System.out.print("Enter the divisor: ");
            String divisor = scanner.nextLine();
            
            try {
                double num = Double.parseDouble(numerator);
                double div = Double.parseDouble(divisor);
                double result = num / div;
                System.out.println(num + " / " + div + " = " + result);
                
            } catch (ArithmeticException e) {
                System.out.println("Not divisible by 0!");
            } catch (IllegalArgumentException e) {
                System.out.println("Bad input.");
                System.out.println("Try again!");
            }
        }
        scanner.close();
    }
}