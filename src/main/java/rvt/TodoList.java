package rvt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    int i;
    private ArrayList<String> tasks;
    private final String filepath = "data/todo.csv";
    
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    private void loadFromFile(){
        try {
            Scanner fileReader = new Scanner(new File(filepath));
            fileReader.nextLine();

            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] tokens = line.split(",");
                tasks.add(tokens[1].trim());
            }
            fileReader.close();
        }catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println(tasks);
    }

    private int getLastId() {
        int lastValue = tasks.size();
        System.out.println("pedejas aktivitates id vertiba ir: " + lastValue);
        return lastValue;
    }
    public void add (String task) {
        this.tasks.add(task);
        try{
            PrintWriter writer = new PrintWriter(new File(filepath));
            // write header
            writer.println("id, task");

            for(i = 0; i < tasks.size(); i++){
                writer.println(i + 1 + ", " + tasks.get(i));
            }
            writer.close();
        }catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public void remove() {
    Scanner input = new Scanner(System.in);
    System.out.println("Ievadiet ID");
    String answer = input.nextLine();
    int id;
    try {
        id = Integer.parseInt(answer);
    } catch (NumberFormatException e) {
        System.out.println("Nepareizi ievadits ID");
        return;
    }
    if (id < 1 || id > tasks.size()) {
        System.out.println("Nepareizi ievadits ID");
        return;
    }
    tasks.remove(id - 1);
    try {
        PrintWriter updatedWriter = new PrintWriter(new File(filepath));
        updatedWriter.println("id, task");
        for (i = 0; i < tasks.size(); i++) {
            updatedWriter.println(i + 1 + ", " + tasks.get(i));
        }
        updatedWriter.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        }
    }
    public boolean checkEventString(String value) {
        if(value.matches("^[a-zA-Z0-9 ]{3,}$")){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.loadFromFile(); 
        todoList.getLastId();
        System.out.println("Vai v?laties izdz?st k?du aktivit?ti? [1/0] ");
        Scanner answer = new Scanner(System.in);
        int Answer = answer.nextInt();
        if(Answer == 0){
            System.out.println("No task removed");
        }
        if(Answer == 1){
            todoList.remove();
            System.out.println(todoList.tasks);
        }
        todoList.checkEventString("do a homework");
    }
}