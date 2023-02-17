import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        String[] menu = MenuPanel();
        for (String option : menu) {
            System.out.println("\033[1;94m" + option + "\033[0m");

        }
        SelectOptions();
    }

    public static String[] MenuPanel() {

        String[] menu = {"Please select an option:", "add", "remove", "list", "exit"};

        return menu;

    }

    public static void SelectOptions() {
        Scanner scanner = new Scanner(System.in);
        String options = scanner.nextLine();
        File file = new File("tasks.csv");

        switch (options) {
            case "add":
                //przypadek add
                System.out.println("Please add task description");
                System.out.println("Please add task due to date" + "for example \"2020-11-20\" ");


                break;


            case "remove":
                //przypadek remove
                System.out.println("Please select number to remove");


                break;


            case "list":   //przypadek list
                try {
                    Scanner scan = new Scanner(file);
                    while (scan.hasNext()){
                        String Filecontent = scan.nextLine();
                    System.out.println(Filecontent);
                    }
                }catch (FileNotFoundException e) {
                    System.out.println("File not found" + e.getMessage());
                }


                break;


            case "exit":
                System.out.println("Bye, bye.");

                break;


            default:
                while (!scanner.equals("exit")) {
                    System.out.println("\033[0;31m" + scanner.nextLine() + "It it not a correct option" + '\n'
                            + "Please select a correct option" + "\033[0m");


                }

        }

    }
}






