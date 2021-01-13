package simplilearn;

import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    final static String FOLDER = "/tmp";

    static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        showWelcomeScreen();
        showMainMenu();

    }

    private static void collectMainMenuOption() {
        System.out.println("Please choose 1, 2 or 3:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                showFilesInAscendingOrder();
                break;
            case "2":

            case "3":
                System.out.println("Thanks for using lockedme.com. Closing application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input provided, please choose 1, 2 or 3.");
        }
        showMainMenu();
    }

    private static void showFilesInAscendingOrder() {
        System.out.println("------------------");
        System.out.println("Showing files in ascending order");
        File[] files = new File(FOLDER).listFiles();
        Set<String> sorted = new TreeSet<>();
        for (File file: files) {
            if (!file.isFile()) {
                continue;
            }
            sorted.add(file.getName());
        }
        sorted.forEach(System.out::println);
        System.out.println("------------------");
    }

    private static void showMainMenu() {
        System.out.println("-- MAIN MENU --");
        System.out.println("1.) Show files in ascending order");
        System.out.println("2.) Perform file operations");
        System.out.println("3.) Close the application");
        System.out.println("---------------");
        collectMainMenuOption();
    }

    private static void showWelcomeScreen() {
        System.out.println("---------------");
        System.out.println("Application: LockedMe.com");
        System.out.println("Developer: Bas Kuis");
        System.out.println("---------------");
    }
}
