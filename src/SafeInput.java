import java.util.Scanner;

public class SafeInput {

    // -------------------- Get Non-Empty String --------------------
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    // -------------------- Get Yes/No Confirmation --------------------
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print(prompt + " ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("Invalid response. Enter Y or N.");
            }
        } while (!done);

        return retVal;
    }

    // -------------------- Get Integer in a Range --------------------
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear newline
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Error: number must be between " + low + " and " + high);
                }
            } else {
                System.out.println("Error: enter a valid integer.");
                pipe.nextLine(); // clear invalid input
            }
        } while (!done);

        return retVal;
    }

    // -------------------- Get Regex String --------------------
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Input does not match required pattern. Try again.");
            }
        } while (!done);

        return retString;
    }
}
