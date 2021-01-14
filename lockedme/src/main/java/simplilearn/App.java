package simplilearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                showFileOperations();
            case "3":
                System.out.println("Thanks for using lockedme.com. Closing application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input provided");
        }
        showMainMenu();
    }

    private static void showFileOperations() {
    	System.out.println("\nWhat do you want to do");
        System.out.println("--------------");
        System.out.println("1.) Add a file");
        System.out.println("2.) Delete a file");
        System.out.println("3.) Search for a file");
        System.out.println("4.) Back to main menu");
        System.out.println("--------------");
        collectFileOperation();
    }

    private static void addAFile() throws InvalidPathException {
       
    	System.out.println("Provide file Name");
    	   String file= scanner.nextLine();
    	
    	   String fullPath  = FOLDER +"/" + file; 
        File newFile = new File(fullPath);
     
        
     

        
//        Path path = Paths.get(filePath);
       
        if (!newFile.exists()) {
            System.out.println("\n" +"Creating File " +file +"........"+"\n");
            try {
				Files.createFile(Paths.get(fullPath));
			System.out.println("\nFile Created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return;
        }
        else {
            System.out.println("\n" +"Creating File " +file +"........"+"\n");

        	System.out.println("\nFile Already Exists");
        }
//        String newFilePath = FOLDER + "/" + path.getFileName();
//        int inc = 0;
//        while (Files.exists(Paths.get(newFilePath))) {
//            inc++;
//            newFilePath = FOLDER + "/" + inc + "_" + path.getFileName();
//        }
//        try {
//            Files.copy(path, Paths.get(newFilePath));
//        } catch(IOException e) {
//            System.out.println("Unable to copy file to " + newFilePath);
//        }

    }

    private static void collectFileOperation() {
        System.out.println("Please choose 1, 2, 3 or 4:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                addAFile();
                break;
            case "2":
            	deleteFile();
                break;
            case "3":
            	searchFile();
                break;
            case "4":
            	
                break;
                default:
                System.out.println("Invalid input provided");
        
        }
        if (option.equals("4")) {
        	System.out.println("\n-----------------");
        	System.out.println("Back to main menu");
        	System.out.println("-----------------\n");
        	showWelcomeScreen();
            showMainMenu();
        }
        else {
        showFileOperations();
        }
    }

    private static void showFilesInAscendingOrder() {
        System.out.println("------------------");
        System.out.println("Showing files in ascending order\n");
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
        System.out.println("Developer: Jon-Thomas Smith");
        System.out.println("---------------");
    }
    private static void deleteFile() {
    	try {
    	System.out.println("\n");
        File p = new File(FOLDER);
        String[] pathnames;
        pathnames = p.list();
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
        }
    	System.out.println("\nWhat file do you want to delete");
    	   String file= scanner.nextLine();
    	   String combine = FOLDER +"/" + file;
    	File delete = new File(combine);
    	if (delete.exists()) {
            System.out.println("\n" +"Deleting File " +file+"......" +"\n");
        
				delete.delete();
			System.out.println("File Deleted"+"\n");
			} 
    	else {
    		System.out.println("File doesn't exsist");
    	}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
            return;
        
    	
    }
    public static void searchFile() {

        System.out.println("----------------------");
   	 System.out.println("Which file are you looking for?");
    	String fileName = scanner.nextLine();
    	String directName= FOLDER +"/" +fileName;
    	
    	File name = new File (directName);
    	if (name.exists()) {
    		  System.out.println("\n----------------------");
    		System.out.println("Searching ....\n");
    		 System.out.println(fileName +" found");
    		  System.out.println("----------------------");
    	}
    	else {
    		  System.out.println("\n----------------------");
    		System.out.println("Searching ....\n");
    		System.out.println("File not Found");
    		  System.out.println("----------------------");
    	}
    	return;
    	
    	
    }
}
