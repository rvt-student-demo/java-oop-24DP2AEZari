package Students;
import java.util.Scanner;
public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentRegistration student = new studentRegistration();
            while (true){
        System.out.println("---------------------------------");
        System.out.println("Student registration");
        System.out.println("---------------------------------");
        System.out.println("1 - Register");
        System.out.println("2 - Show all");
        System.out.println("3 - Remove");
        System.out.println("4 - Edit");
        System.out.println("5 - Exit");
        System.out.println();
        System.out.println("What stuff you wanna do?");
        Integer answer = scanner.nextInt();

            if (answer == 1) {
                student.register();
            } else if (answer == 2) {
                student.show();
            } else if (answer == 3) {
                student.remove();
            } else if (answer == 4) {
                student.edit();
            } else if (answer == 5) {
                student.exit();
            } else {
                System.out.println("Nepareiza izvele, meginiet velreiz");
            }
        }
    }
}
