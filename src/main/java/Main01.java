import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Menu();
        Scanner scanner = new Scanner(System.in);
        String options = scanner.nextLine();

        switch (options) {
            case "add":
                Add();
                main(new String[0]);

                break;
            case "remove":
                Remove();
                main(new String[0]);
                break;

            case "list":
                List();
                main(new String[0]);
                break;
            case "exit":
                System.out.println("Bye, bye...");

                break;

            default:
                System.out.println("\033[0;31m" + "It it not a correct option" + '\n'
                        + "Please select a correct option" + "\033[0m");
                main(new String[0]);
                break;
        }


    }

    public static void Menu() {
        String[] menu = {"Please select an option:", "add", "remove", "list", "exit"};
        for (String option : menu) {
            System.out.println("\033[1;94m" + option + "\033[0m");
        }

    }

    public static void Add() {
        Scanner scanner = new Scanner(System.in);
        File file = new File("tasks.csv");
        String[] results = new String[3];

        System.out.println("Please add task description");
        results[0] = scanner.nextLine();

        System.out.println("Please add task due to date" + " for example \"2020-11-20\" ");
        results[1] = scanner.nextLine();

        System.out.println("Is your task is important: true/false");
        results[2] = scanner.nextLine();

        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print('\n' + results[0] + ", " + results[1] + ", " + results[2]);

            pw.close();
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać do pliku.");
        }

    }

    public static void List() {
        File file = new File("tasks.csv");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String Filecontent = scan.nextLine();
                System.out.println(Filecontent);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }

    }

    public static void Remove() {
        System.out.println("Please select number to remove");
        Scanner scanner = new Scanner(System.in);
        int NumberFromScanner = scanner.nextInt();

        Path filePath = Paths.get("tasks.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lines.remove(NumberFromScanner - 1);  // usuwamy wybraną linię

        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

