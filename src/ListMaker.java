import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> items = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Choose an option", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = quitProgram();
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    // ---------------- Menu Display ----------------
    private static void displayMenu() {
        System.out.println("\n==== List Maker Menu ====");
        printList(); // show numbered list
        System.out.println("A – Add an item");
        System.out.println("D – Delete an item");
        System.out.println("I – Insert an item");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit");
    }

    // ---------------- Menu Functions ----------------

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add:");
        items.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (items.isEmpty()) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        printNumberedList();
        int index = SafeInput.getRangedInt(in, "Enter the number of the item to delete:", 0, items.size() - 1);
        String removed = items.remove(index);
        System.out.println("Removed: " + removed);
    }

    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert:");
        int index = SafeInput.getRangedInt(in, "Enter the position to insert at (0 to " + items.size() + "):", 0, items.size());
        items.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (items.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            System.out.println("Current List:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ": " + items.get(i));
            }
        }
    }

    private static boolean quitProgram() {
        boolean confirm = SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N)");
        return confirm;
    }

    // Utility: display numbered list
    private static void printNumberedList() {
        System.out.println("List Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i));
        }
    }
}
