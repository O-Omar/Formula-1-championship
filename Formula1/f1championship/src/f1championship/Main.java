/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author w1740779
 */
public class Main {
    
 public static void main(String[] args) throws IOException { // Main method of the application

        Formula1ChampionshipManager a = new Formula1ChampionshipManager(); // link between main and Formular1championshipmanager
        Scanner input = new Scanner(System.in);

        // menu consists of a switchcase
        boolean menuChoice = true; //this is a boolean
        String choice;
        a.recoverInfo(); // getting the saved data
        while (menuChoice) {
            //System.out.print("-------------------Formula1 Championship Management System----------------\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                             FORMULAR 1 RACING CAR CHAMPIONSHIP Management System.                                        ");
            System.out.println("==========================================================================================================================");
            System.out.println("Enter 1 to add  Driver : ");
            System.out.println("Enter 2 change a Driver: ");
            System.out.println("Enter 3 to delete a driver:");
            System.out.println("Enter 4 to add a race:");
            System.out.println("Enter 5 to view statistics by name of a driver:");
            System.out.println("Enter 6 to view table:");
            System.out.println("Enter 7 to save the driver:");
            System.out.println("Enter 8 to recoverInfo from the driver:");
            System.out.println("Enter 9 to view the GUI");
            System.out.println("Enter Q to Quit:");
            System.out.print("---------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("Enter your choice:");
            choice = input.next();

            switch (choice) {
                case "1" -> //add adriver
                    a.createNewDriver();
                case "2" -> //change a driver
                    a.changeDriver();
                case "3" -> //delete a driver
                    a.deleteDriver();
                case "4" -> //add races
                    a.addRace();
                case "5" -> //view statistics
                    a.displayStats();
                case "6" -> //view tables
                    a.displayTable();
                case "7" -> //saves the file
                    a.saveInfo();
                case "8" -> //saves the file
                    a.recoverInfo();
                case "Q" -> //Quits from the program
                    a.exit();
                case "9" -> // loading the gui                    
                    new Formula1GUITable(a);
                default -> System.out.println("Please enter valid input"); //if invalid input
            }
            //switch case including the letters in menu and the methods.
            //end of switch case including the letters in menu and the methods.
        }
    }
}
