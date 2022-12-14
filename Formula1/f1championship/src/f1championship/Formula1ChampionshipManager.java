package f1championship;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author w1740779
 */

public class Formula1ChampionshipManager implements ChampionshipManager{//implementing the championship manager interface

    private ArrayList < Formula1Driver > drivers = new ArrayList < > (); // arraylist for drivers
    private ArrayList < Race > races = new ArrayList < > (); // arraylist for races
    
   public ArrayList < Formula1Driver > getDrivers() {
        return drivers;
    } //getter method for Arraylist Formular1Driver(to call the drivers out)
    public ArrayList < Race > getRaces() {
        return races;
    } //getter method for Arraylist Race to call the races out
    
    public static Scanner input = new Scanner(System.in);// static scanner class
    
    

     /////////////////////////////////////////////////////////
    public boolean driverValidate(String name) { // validate the driver checks weather it already exsits?
        for (Formula1Driver l: drivers) {
            if (l.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }  
    
     public boolean teamValidate(String team) { // validate the team checks weather it already exsits?
        for (Formula1Driver s: drivers) {
            if (s.getTeam().equals(team)) {
                return false;
            }
        }
        return true;
    }
    
     public static Integer intValidInputs(String intval) { // validate the inputs method for integers
        while (true) {
            System.out.print(intval);
            String unchecked1 = input.next();
            try {
                //try to convert user input to integer
                int checkInt = Integer.parseInt(unchecked1);
                //is user input checking positive number or not
                if (checkInt < 0) {
                    System.out.println("\nValid only positive numbers!\n");
                } else
                    return checkInt;
            } catch (Exception e) {
                System.out.println("\ninvalid Input integer required!\n");
            }
        }
    }
    
     
       public static String strValidInputs(String StrVal2) { // validate the inputs method for strings
        //this is string pattern wants to get from user
        String regX = "^[A-a-zZ\\s]+$";
        //given string pattern compile to default format
        Pattern pattern = Pattern.compile(regX, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(StrVal2);
            String unchecked2 = input.next();
            //given user input matching to customize pattern
            Matcher matcher = pattern.matcher(unchecked2);
            //if given input matched condition is true
            if (matcher.find()) {
                return unchecked2;
            } else
                System.out.println("\nString not in proper type!\n");
        }
    }
    ///////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public void createNewDriver() { //creates new driver
      String name = strValidInputs("Enter name of Driver :"+ "\n"); //calling the validation method and String validation for the input Drivername
        if (driverValidate(name)) {
            String team = strValidInputs("Enter team name : "+ "\n"); //calling the validation method and String validation for the input Team name
            if (teamValidate(team)) {
                String location = strValidInputs("Enter location :"+ "\n");
                int noraces = intValidInputs("Enter races participated : " + "\n"); // calling the validation method and String validation for the input races
                Formula1Driver driver = new Formula1Driver(name, location, team, noraces);
                drivers.add(driver); //adds into the Formular1Driver arraylist
                System.out.println("\n new Driver " + name + " Successfully Added.\n");
            } else {
                System.out.println("Team already exists");
            }
        } else {
            System.out.println("Name already exists");
        }
    }



        
    @Override
    public void deleteDriver() {//deletes driver
   Formula1Driver a = null;
        System.out.println("Enter the name of the driver to delete:");
        String deldriver = input.next();
        System.out.println("------------------------------------------");
        boolean found = false;
        for (Formula1Driver i: drivers) {
            if (i.getName().equals(deldriver)) { //delete condition
                a = i;
                found = true;
                break;
            }
        }
        drivers.remove(a); // removes the selected items from the array.
        if (!found) {
            System.out.println("Record is not found !!");
        } else {
            System.out.println("-----------Record is deleted sucessfully-----------");
            System.out.println("\n  Driver " + deldriver + " Sucessfully Deleted.\n");
        }
    }      
        
    

    @Override
    public void changeDriver() {//changes driver to a new team
            System.out.println("Enter Drivers team name : ");
        String tname = input.next();//team name
        System.out.println("------------------------------------------");
        for (Formula1Driver driver: drivers) {
            if (driver.getTeam().equals(tname)) { //changing condition
                System.out.println("Enter new driver : ");
                String dName = input.next();
                driver.setName(dName); //this parameter sets the team name
                System.out.println("\n  Driver changed in ferarri team " + tname + " .\n");
            }
        }
    } 

    @Override
    public void displayStats() {
     // view statistics method overided from ChampionshipManager interface
        String drivercom = ("Enter the name to view statistics : ");
        for (Formula1Driver viewdst: drivers) {
            if (viewdst.getName().equals(drivercom)) { // the input name
                System.out.println("Name: " + viewdst.getName());
                System.out.println("Location: " + viewdst.getLocation());
                System.out.println("Races participated: " + viewdst.getNoraces());
                System.out.println("Points earned: " + viewdst.getNopoints());
                System.out.println("Noof 1 places: " + viewdst.getNoOffirstplaces());
                System.out.println("Noof 2 places: " + viewdst.getNoOfsecondPlaces());
                System.out.println("Noof 3 places: " + viewdst.getNoOfthirdPlaces());
            }
        }
    }    
        
    

    @Override
   public void displayTable() {
        boolean exists = false;
        if (!exists) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                             FORMULAR 1 RACING CAR CHAMPIONSHIP Table                                          ");
            System.out.println("==========================================================================================================================");
            System.out.println("");
            System.out.println("");

            String leftAlignment = "%-18s | %-8s | %-8s| %-17d | %-12d| %-13d | %-13d| %-13d |%n";

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-18s | %-8s | %-8s| %-8s | %-8s| %-8s | %-8s| %-8s\n", "Name", "Team", "Location", "Racesparticipated", "Pointsearned", "1st positions", "2nd positions", "3rd positions");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
             Collections.sort(drivers, new PointsComparator()); // sort
            for (Formula1Driver viewtable: drivers) {
                System.out.printf(leftAlignment, viewtable.getName(), viewtable.getTeam(), viewtable.getLocation(), viewtable.getNoraces(), viewtable.getNopoints(), viewtable.getNoOffirstplaces(), viewtable.getNoOfsecondPlaces(), viewtable.getNoOfthirdPlaces());
            }
        } else {
            System.out.println("Record is not found");
        }
    }

       
       
    @Override
    public void addRace() { //add race method overided from ChampionshipManager interface
        try {
            System.out.println("Enter the date of Race (dd/MM/yyyy): "); //race
            String ddate = input.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(ddate);;
            Race race = new Race(date, drivers.size());
            races.add(race);
            for (Formula1Driver dpos: drivers) {
                int driverpos = intValidInputs("Enter position of driver:" + dpos.getName() + "\n"); // calling the validation method.
                dpos.cal(driverpos); // calling the cal method
                if (driverpos == 1) {
                    dpos.setNoOffirstplaces();
                } else if (driverpos == 2) {
                    dpos.setNoOfsecondPlaces();
                } else if (driverpos == 3) {
                    dpos.setNoOfthirdPlaces();
                }
                dpos.setNoraces(); //to calculate the no of races
                race.setDrivDetails(dpos.getName(), String.valueOf(driverpos)); // calling the set method in race.java class
            }
        } catch (ParseException ignored) {}
    }

    @Override
    public void saveInfo() {//this is save to a txt file method overided from ChampionshipManager interface
        try {
            File file = new File("drivers.txt");
            file.createNewFile(); // create a new file
            FileOutputStream fout = new FileOutputStream(file); //append
            ObjectOutputStream obj = new ObjectOutputStream(fout);

            obj.writeObject(drivers);
            obj.close();
            fout.close();

            File file2 = new File("race.txt");
            file2.createNewFile(); // create a new file
            FileOutputStream fout2 = new FileOutputStream(file2);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fout2);
            objectOutputStream1.writeObject(races);
            objectOutputStream1.close();
            fout2.close();

            System.out.println("**-----------Race details successfully saved!-----------**");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException e) {
            System.out.println("Error Initializing Stream!");
        }
    }
    

    @Override
    public void recoverInfo() { //This is read file method overided from ChampionshipManager interface
        try {
            FileInputStream fin = new FileInputStream("drivers.txt");
            ObjectInputStream objin = new ObjectInputStream(fin);
            drivers = (ArrayList < Formula1Driver > ) objin.readObject();
            objin.close();
            fin.close();

            FileInputStream fin2 = new FileInputStream("race.txt");
            ObjectInputStream objin1 = new ObjectInputStream(fin2);
            races = (ArrayList < Race > ) objin1.readObject();
            objin1.close();
            fin2.close();

        } catch (FileNotFoundException ignored) {

        } catch (IOException e) {
            //System.out.println("Error Initializing Stream");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
   


    

public void exit() {
        System.exit(0);
    } //method to exit the application    
    
}
