package application;

import java.util.Scanner;

public class Application {

    private static Scanner scan = new Scanner(System.in);
    private TextEditor textEditor = new TextEditor();

    public void menu() {
        int option = 0;

        do {

            System.out.print("\n1. Write\n2. Undo\n3. Redo\n4. View\n0. Exit\nEnter the number of your choice: ");
            option = scan.nextInt();

            if (option == 1)
                textEditor.write();

            else if (option == 2)
                textEditor.undo();

            else if (option == 3)
                textEditor.redo();

            else if (option == 4)
                textEditor.view();

            else if (option > 4 || option < 0)
                System.out.println("\n Invalid choice! ");

        } while (option != 0);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.menu();
    }

}
