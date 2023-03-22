package application;

import java.util.Scanner;

import unitins.LinkedTins;
import unitins.StackTins;

public class TextEditor {

    private static Scanner scan = new Scanner(System.in);

    private StackTins<String> stackUndo = new StackTins<String>();
    private StackTins<String> stackRedo = new StackTins<String>();

    public void write() {
        System.out.println("---- Text Editor ----\nWrite:");
        String value = "";

        if (Boolean.FALSE.equals(stackUndo.isEmpty()))
            value = " ";

        value += scan.nextLine();
        stackUndo.push(value);
    }

    public void undo() {
        if (stackUndo.isEmpty())
            System.out.println("There is no action to undo.");
        else {
            stackRedo.push(stackUndo.pop());
        }
    }

    public void redo() {
        if (stackRedo.isEmpty())
            System.out.println("There is no action to redo.");
        else {
            stackUndo.push(stackRedo.pop());
        }
    }

    public void view() {
        LinkedTins<String> text = new LinkedTins<>();
        String value;

        for (int i = 0; i <= stackUndo.size(); i++) {
            value = stackUndo.pop();
            text.add(value);
        }

        value = "";

        for (int i = text.size() - 1; i >= 0; i--) {
            value += text.get(i);
            stackUndo.push(text.get(i));
        }

        System.out.println(value);
    }

}
