package rvt;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class studentRegistration {
    Scanner scanner = new Scanner(System.in);
    String name;
    String surname;
    String email;
    String personalCode;
    Date date = new Date();

    
   public void register() {

        // Name input
        while (true) {
            System.out.print("Ievadiet v?rdu: ");
            this.name = scanner.nextLine();
            if (name.matches("^[\\p{L}'\\- ]{3,}$")){
                break;
            } else {
                System.out.println("Nepareizs v?rda form?ts! (Vismaz 3 burti, tikai burti, atstarpes, '-' vai ')");
            }
            
        }

        // Surname input
        while (true) {
            System.out.print("Ievadiet savu uzv?rdu: ");
            this.surname = scanner.nextLine();
            if (surname.matches("^[\\p{L}'\\- ]{3,}$")){
                break;
            } else {
                System.out.println("Nepareizs uzv?rda form?ts! (Vismaz 3 burti, tikai burti, atstarpes, '-' vai ')");
            }
        }

        // Email input
        while (true) {
            System.out.print("Ievadiet savu e-pastu: ");
            this.email = scanner.nextLine();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) 
            {
                break;
            } else {
                System.out.println("Nepareizs e-pasta form?ts!");
            }
        }

        // Latvian personal code input
        while (true) {
            System.out.print("Ievadiet savu personas kodu (DDMMYY-XXXXX): ");
            this.personalCode = scanner.nextLine();
            if (personalCode.matches("^\\d{6}-\\d{5}$")) {
            break;
            } else {
                System.out.println("Nepareizs personas kods! Pareizais form?ts: DDMMYY-XXXXX");
            }
            
        }
        csvFileHandler file = new csvFileHandler();
        file.addToCSV();
   }

    
    class csvFileHandler {
    public void addToCSV() {
        try {

            String filePath ="data\\data.csv";
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(String.format("%s,%s,%s,%s,%s\n",
                    name, surname, email, personalCode, date.toString()));
            writer.close();
            System.out.println("Student saved to CSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    public static void main(String[] args) {
        studentRegistration student = new studentRegistration();
        student.register();
    }     
}