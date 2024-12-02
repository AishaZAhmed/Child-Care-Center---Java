import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Aisha Ahmed and Sumaima Qazi
Child Care Centres
ICS4U1
*Mrs. Kupresak
*This program is a child care centres program that allows the user to find the most suitable child care center for thier child and check statistics of the chidlc are centers in onatrio
*https://replit.com/@ICS4U112324/Cpt-Final-Child-Care-Center#Main.java
*December, 20, 2023
*/
public class Main {

  // Global Scanner
  static Scanner input = new Scanner(System.in);

  // Global 2d array
  static String[][] myArray = new String[558][19];

  /*
   * Syeda Sumaima Qazi
   * Description: Method to find the most suitable child care center for your
   * child based on your prefrences
   * Precondition: User must fill out all questions
   * Postcondition: User will be able to see the most suitable child care center
   * for their child
   */
  private static void InfoForm() {
    // Variables
    String Name, childname, childage, city, program, hours;

    // Variable for type of childcare
    int type = 0;

    // Child care form Intro
    System.out.println("");
    System.out.println("Ontario Child Care Center Info Board");
    System.out.println("Fill in all Questions to find the most suitable Child care center for your child\n");

    input.nextLine();
    // Q.1) Your Name
    System.out.print("What is your Name: ");
    Name = input.nextLine();
    System.out.println("");
    // Q.2) Your Childs Name
    System.out.print("What is your Childs Name: ");
    childname = input.nextLine();
    System.out.println("");
    // Q.3) Your Childs Age
    System.out.print("What is your Childs Age: ");
    childage = input.nextLine();
    System.out.println("");
    // Q.4) What City do you live in
    System.out.print("Where do you live (hint Mississauga, Brampton or Caledon): ");
    city = input.nextLine();
    System.out.println("");
    // Q.5) Your working hours
    System.out.print("What are your main working hours: ");
    hours = input.nextLine();
    System.out.println("");

    // Q.6) What type of Child Care program you would want
    System.out.print("Would you prefer an After School Program or a Regular program" +
        "\nIf you prefer an After School Program press Yes, if you prefer the Regular Program press No: ");
    program = input.nextLine();
    System.out.println("");
    // Q.7) What type of Child Care Type
    System.out.print(
        "What Type of Child Care center would you prefer (School-Based Center, Community-Based for-Profit Center, Community-Based Non-Profit Center)"
            + "\n Press 1 for School-Based Center, 2 for Community-Based for-Profit Center, 3 for Community-Based Non-Profit Center: ");
    type = input.nextInt();

    // display the array
    int counter = 0;

    // Check if the user input is correct
    for (int r = 0; r < myArray.length; r++) {

      // If the user input is correct, display the array
      if ((myArray[r][8] != null && myArray[r][14] != null)
          && (myArray[r][8].equalsIgnoreCase(city) && myArray[r][14].equals(program))) {

        // Check the array for School-Based Child care Centres
        if (type == 1) {
          if (myArray[r][13].equalsIgnoreCase("School-Based Centre")) {
            counter++;
            System.out.println(myArray[r][2]);
          }
        }

        // Check the array for Community-Based For-Profit Child care Centres
        if (type == 2) {
          if (myArray[r][13].equalsIgnoreCase("Community-Based For-Profit Centre")) {
            counter++;
            System.out.println(myArray[r][2]);
          }
        }

        // Check the array for Community-Based Non-Profit Child care Centres
        if (type == 3) {
          if (myArray[r][13].equalsIgnoreCase("Community-Based Non-Profit Centre")) {
            counter++;
            System.out.println(myArray[r][2]);
          }
        }
      }
    }

    // Display the number of Child care Centres that fit the user input
    if (type == 1) {
      System.out.println("\nThere are " + counter + " School-Based Centre in " + city);
    }

    if (type == 2) {
      System.out.println("\nThere are " + counter + " Community-Based For-Profit Centre " + city);
    }

    if (type == 3) {
      System.out.println("\nThere are " + counter + " Community-Based Non-Profit Centre " + city);
    }
  }

  /**
   * Statistics
   * Aisha Ahmed
   * Description: Provides statistics: Calculates number of Child care centers for
   * Misssiauga, Brampton and Caledon. In addition, it provides a percetage of
   * child care centers for that city out of the total number in all of Ontario.
   * Pre: Array must be filled with data and user must put valid parameter for
   * statistics to be displayed
   * Post: Statistics are displayed and user is able to return to the main menu
   * @param args
   */

  private static void Statistics() { // Aisha Ahmed
    // prompting user
    int useri;
    int statoption;
    boolean done = false;
    while (done == false) {
      
      System.out.println("\nWould you like some statistics relating to child care centers in Ontario?");
      System.out.println("Enter 1 for yes / 2 for no");

      // PROMPTING
      useri = input.nextInt();
      // USER STATS OPTION
      if (useri == 1) {
        System.out.println(
            "Choose 1 / 2 / 3 / 4 \n Number of child care centers in Brampton\n Number of child care centers in Mississauga\n Number of child care centers in Caledon\n Number of child care centers in Ontario");
        statoption = input.nextInt();

        // COUNTERS for Mississauga, Brampton and Caledon
        int Bcounter = 0, Mcounter = 0, Ccounter = 0;
        int c2 = 0;

        // Brampton stats
        for (int r = 0; r < myArray.length; r++) {
          if (myArray[r][8] != null && myArray[r][8].equals("Brampton")) {
            // System.out.println(myArray[r][2]);
            Bcounter++;
          }
          // Mississauga stats
          if (myArray[r][8] != null && myArray[r][8].equals("Mississauga")) {
            Mcounter++;
          }
          // Caledon stats
          if (myArray[r][8] != null && myArray[r][8].equals("Caledon")) {
            Ccounter++;
          }
          // counting all child care centers in Ontario
          if (myArray[r][3] != null) {
            c2++;
          }
        }
        // displaying Brampton stats
        if (statoption == 1) {
          double Bpercentage = (Bcounter * 100 / c2);
          System.out.println("There are " + Bcounter + " child care services in Brampton. That is " + Bpercentage
              + "% of all child care centers in Ontario. \n");
          ;
        }
        // displaying Brampton stats
        if (statoption == 2) {
          double Mpercentage = (Mcounter * 100 / c2);
          System.out
              .println("There are " + Mcounter + " child care services in Mississauga.That is \n" + Mpercentage
                  + "% of all child care centers in Ontario. \n");
        }
        // displaying Brampton stats
        if (statoption == 3) {
          double Cpercentage = (Ccounter * 100 / c2);
          System.out.println("There are " + Ccounter + " child care services in Caledon. That is \n" + Cpercentage
              + "% of all child care centers in Ontario. \n");
        }
        // displaying Brampton stats
        if (statoption == 4) {
          System.out.println("There are " + c2 + " child care services in Ontario.\n");
        }
        // if invalid parameter
        if (statoption < 0 || statoption > 4) {
          System.out.println("Please enter a valid option.\n");
        }
      } else {
        System.out.print("\nThank you for using the statistics program.\n");
        done = true;
      }
    }

  }

  // MAIN
  public static void main(String[] args) {

    File textFile = new File("Child_Care_Centres_.csv");
    String lineOfText;

    int row = 0;

    try {
      FileReader in = new FileReader(textFile);
      BufferedReader readFile = new BufferedReader(in);
      while ((lineOfText = readFile.readLine()) != null) {
        // System.out.println(lineOfText);

        String[] colInfo = lineOfText.split(",");

        for (int c = 0; c < colInfo.length; c++) {
          myArray[row][c] = colInfo[c]; // put into array
        }
        row++; // count the rows
      }
      readFile.close(); // closing
      in.close();

    } catch (FileNotFoundException e) {
      System.out.println("File does not exist or could not be found.");
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Problem reading file.");
      System.err.println("IOException: " + e.getMessage());
    }

    // Intro Menu
    boolean repeat = true;
    while (repeat) {
      int user;
      System.out.println("");
      System.out.print("Welcome to the Child Care Centre Finder!\r\n" +
          "Choose 1 to fill out a form\r\n" +
          "Choose 2 for Statistics of Child Care Centres in Ontario\r\n" +
          "Choose 3 for EXIT\r\n" +
          "Choose the operation you want to perform: ");
      user = input.nextInt();

      // calling methods
      if (user == 1) {
        InfoForm();
      }

      if (user == 2) {
        Statistics();
      }

      if (user == 3) {
        repeat = false;
        System.out.println("Thank you!");
      }
    }
    input.close();
  }
}
