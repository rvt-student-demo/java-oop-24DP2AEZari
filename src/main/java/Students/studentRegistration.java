package Students;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class studentRegistration {
    Scanner scanner = new Scanner(System.in);
    String name;
    String surname;
    String email;
    String personalCode;
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    
   public void register() {
        while (true) {
            System.out.print("Ievadiet vardu: ");
            this.name = scanner.nextLine();
            if (name.matches("^[\\p{L}'\\- ]{3,}$")){
                break;
            } else {
                System.out.println("Nepareizs varda formats! (Vismaz 3 burti, tikai burti, atstarpes, '-' vai ')");
            }
            
        }
        while (true) {
            System.out.print("Ievadiet savu uzvardu: ");
            this.surname = scanner.nextLine();
            if (surname.matches("^[\\p{L}'\\- ]{3,}$")){
                break;
            } else {
                System.out.println("Nepareizs uzvarda formats! (Vismaz 3 burti, tikai burti, atstarpes, '-' vai ')");
            }
        }
        while (true) {
            System.out.print("Ievadiet savu e-pastu: ");
            this.email = scanner.nextLine();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) 
            {
                break;
            } else {
                System.out.println("Nepareizs e-pasta formats!");
            }
        }
        while (true) {
            System.out.print("Ievadiet savu personas kodu (DDMMYY-XXXXX): ");
            this.personalCode = scanner.nextLine();
            if (personalCode.matches("^\\d{6}-\\d{5}$")) {
            break;
            } else {
                System.out.println("Nepareizs personas kods! Pareizais formats: DDMMYY-XXXXX");
            }
            
        }
        csvFileHandler file = new csvFileHandler();
        file.addToCSV();
    }

    public void edit() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ievadiet skolena personas kodu, kuru velaties rediget: ");
    String code = scanner.nextLine();

    csvFileHandler file = new csvFileHandler();
    file.editStudent(code);
}
    public void exit() {
        System.exit(0);
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        csvFileHandler fileHandler = new csvFileHandler();
        System.out.print("Ievadiet savu personas kodu (DDMMYY-XXXXX): ");
        String pCode = scanner.nextLine();
        fileHandler.removeFromCSV(pCode);
    }

    public void show() {
        String filePath = "data/data.csv";
        BufferedReader reader = null;
        String line = "";
        
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(","); 
               for (int i = 0; i<5 ;i++){
                System.out.print("+");
                System.out.print("--------------------------");
               }
               System.out.println("+");
               for(String index : row) {
                System.out.printf("| %-25s", index);
               }
               System.out.println("|");
               }
            if (line == null) {
                 for (int i = 0; i<5 ;i++){
                    System.out.print("+");
                    System.out.print("--------------------------");
               }
               System.out.println("+");
            }

        } catch (Exception e) {
        }
    }

    
    
    class csvFileHandler {
    public void addToCSV() {
        try {
            String filePath ="data\\data.csv";
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(String.format("%s,%s,%s,%s,%s\n",
                    name, surname, email, personalCode, date.format(dateFormat)));
            writer.close();
            System.out.println("Student saved to CSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeFromCSV(String code) {
        String filePath = "data/data.csv";
        String tempFile = "data/temp.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length >= 4 && !row[3].trim().equals(code.trim())) {
                    pw.println(line);
                }
            }
            System.out.println("Removal completed. Updated CSV saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            FileWriter writer = new FileWriter(filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();
            new File(tempFile).delete();
            System.out.println("Removal completed. Updated CSV saved.");
        } catch (IOException e) {
            System.out.println("Error replacing file: " + e.getMessage());
        }
    }

    public void editStudent(String code) {
    String filePath = "data\\data.csv";
    String tempFile = "data\\temp.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath));
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)))) {

        Scanner input = new Scanner(System.in);
        String line;

        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            if (row.length >= 5 && row[3].trim().equals(code.trim())) {
                String rowName = row[0].trim();
                String rowSurname = row[1].trim();
                String rowEmail = row[2].trim();
                String rowCode = row[3].trim();
                String rowDate = row[4].trim();
                
                System.out.println("Students atrasts!");
                System.out.println("1 - Vards");
                System.out.println("2 - Uzvards");
                System.out.println("3 - E-pasts");
                System.out.println("4 - Personas kods");
                System.out.print("Izvelaties ko mainit: ");
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    System.out.print("Ievadiet jauno vardu: ");
                    while (true) {
                        String newName = input.nextLine();
                        if (newName.matches("^[\\p{L}'\\- ]{3,}$")) {
                            rowName = newName;
                            break;
                        }
                        System.out.println("Nepareizs varda formats!");
                    }
                }

                if (choice == 2) {
                    System.out.print("Ievadiet jauno uzvardu: ");
                    while (true) {
                        String newSurname = input.nextLine();
                        if (newSurname.matches("^[\\p{L}'\\- ]{3,}$")) {
                            rowSurname = newSurname;
                            break;
                        }
                        System.out.println("Nepareizs uzvarda formats!");
                    }
                }

                if (choice == 3) {
                    System.out.print("Ievadiet jauno e-pastu: ");
                    while (true) {
                        String newEmail = input.nextLine();
                        if (newEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                            rowEmail = newEmail;
                            break;
                        }
                        System.out.println("Nepareizs e-pasta formats!");
                    }
                }

                if (choice == 4) {
                    System.out.print("Ievadiet jauno personas kodu: ");
                    while (true) {
                        String newCode = input.nextLine();
                        if (newCode.matches("^\\d{6}-\\d{5}$")) {
                            rowCode = newCode;
                            break;
                        }
                        System.out.println("Nepareizs personas kods!");
                    }
                }
                pw.println(rowName + "," + rowSurname + "," + rowEmail + "," + rowCode + "," + rowDate);
            } else {
                pw.println(line);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        FileWriter writer = new FileWriter(filePath);
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line + "\n");
        }
        reader.close();
        writer.close();
        new File(tempFile).delete();
        System.out.println("Redigesana pabeigta!");
    } catch (IOException e) {
        System.out.println("Error replacing file: " + e.getMessage());
        }
    }
    }
}