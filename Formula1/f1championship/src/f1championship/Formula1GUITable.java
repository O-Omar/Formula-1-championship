/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author w1740779
 */
public class Formula1GUITable extends JFrame { //GUI of the application
    private int arow;//instance variable decleration
    private String[][] data; // data
    private String[] column = {// column names of the jtable
                                "Name",
                                "Team",
                                "Location",
                                "Races",
                                "Points",
                                "1",
                                "2",
                                "3"
    }; 
    JScrollPane scrollp;
    JScrollPane scrollp2; //Generaterandomtable table scrollpane
    JScrollPane scrollp3; //scrollpane of probabilitytable
    JScrollPane scrollp4; //scrollpane of view completed races
    JScrollPane searchscrollp;
    JTable statJtbl; //instance variable of the decending table.
    JButton toAscend;// creating points Ascending order button
    JButton toDecend;
    JButton generateNewRace;
    JLabel dLbl; //fixed date label of GenerateRandomRace--
    JLabel dateLbl; // date label of GenerateRandomRace
    JLabel dLbl2; //fixed date label of GenerateProbabilityRace--
    JLabel dateLbl2; // date label of GenerateProbabilityRace
    JTable randTbl;//table to generate randomrace
    JButton probabilityRace;
    JTable probTbl; //instance variable of the Probability table.
    JButton completedRaces;
    JTable compareDateTbl;
    JButton SearchBtn;//search button
    JTextField serchTxt;// textfield to serach
    JTable searchRaceTbl;
    JLabel shownamelbl;
    JLabel Heading;



    public Formula1GUITable(Formula1ChampionshipManager par) { // constructor od Formula1GUITable
        this.arow = par.getDrivers().size(); // array size
        data = new String[arow][8]; // 2dimensional array
        guiTbl(par.getDrivers()); //acessing to the driver objects values/statistics in descending order at the beginning
        statJtbl = new JTable(data, column); // values and columns of the jtable/table showing the statistics at the begining
        statJtbl.setDefaultEditor(Object.class, null); // To prevent editing
        scrollp = new JScrollPane(statJtbl); //scrollpane of the table showing the statistics
        scrollp.setBounds(50, 100, 500, 400);

        Heading = new JLabel("-FORMULA 1 RACING CAR CHAMPIONSHIP-"); // creating date label object
        Heading.setFont(new Font("Serif", Font.BOLD, 40)); //font type and the size
        Heading.setBounds(120, 20, 870, 50); // bounds of the label

        //============================Ascending button start===================================================================
        toAscend = new JButton("Ascending"); // creating points Ascending order button
        toAscend.setBounds(50, 520, 120, 20); // bounds of the button
        toAscend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Collections.sort(par.getDrivers(), new AscComp()); // sort points in ascending
                Ascendtblobj(par.getDrivers());
                statJtbl.repaint(); // refreshing the statistics table

            }
        });
        //============================Ascending button end===================================================================

        //----------------------------------------Descending button start-----------------------------------------------------
        toDecend = new JButton("Descending"); // creating a button to descend according to largest first position.
        toDecend.setBounds(200, 520, 120, 20); // bounds of the button
        toDecend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decending(par.getDrivers());
                statJtbl.repaint();

            }
        });
        //----------------------------------------Descending button end-----------------------------------------------------

        //========================================GeneratenNewRace Random button start===========================================
        String[] twodim_randCol = {
                "Driver Name",
                "Position"
        };
        String[][] twodim_Randarr = new String[par.getDrivers().size()][2];

        dLbl = new JLabel("Date"); // creating fixed date label object
        dLbl.setBounds(650, 685, 200, 10); //setting bounds to the dLbl

        dateLbl = new JLabel(); // creating date label object
        dateLbl.setBounds(700, 685, 200, 10); //setting bounds to the dateLbl

        generateNewRace = new JButton("GeneratenNewRace"); //object of the buttton generateNewRace
        generateNewRace.setBounds(650, 650, 200, 20); //setting bounds to the generateNewRace jbutton.
        generateNewRace.setBackground(Color.CYAN); //backgroundcolour of button
        generateNewRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = generateRandomRace(par.getDrivers(), par.getRaces(), twodim_Randarr); //calling the generateRandomRace method
                randTbl = new JTable(twodim_Randarr, twodim_randCol); //creating the table using the values got by calling the generateRandomRace method
                randTbl.setDefaultEditor(Object.class, null); // To prevent editing
                scrollp2 = new JScrollPane(randTbl); //adding the table to the scrollpane
                scrollp2.setBounds(650, 700, 350, 200);
                dateLbl.setText(String.valueOf(date)); // printing the random race date
                guiTbl(par.getDrivers()); //calling the 2d array in guiTbl method inorder to change the values.
                statJtbl.repaint(); //refresh the stattable
                add(scrollp2); // adding the scroll pane2 with the randomtable into jframe

            }
        });
        //========================================GeneratenNewRace Random button end===========================================

        //------------------------------------------------GenerateProbabilityRace start----------------------------------------
        String[] twodim_probCol = {
                "Driver Name",
                "Position",
                "Starting position"
        }; // headings
        String[][] twodim_probarr = new String[par.getDrivers().size()][3];

        dLbl2 = new JLabel("Date"); // creating fixed date label object of GenerateProbabilityRace
        dLbl2.setBounds(50, 685, 200, 10);

        dateLbl2 = new JLabel(); // creating date label object
        dateLbl2.setBounds(100, 685, 200, 10);

        probabilityRace = new JButton("GenerateProbabilityRace"); //object of the buttton generateProbability
        probabilityRace.setBounds(50, 650, 200, 20); //setting bounds to the generateNewRace jbutton.
        probabilityRace.setBackground(Color.CYAN); //backgroundcolour of button
        probabilityRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = ProbRandomRace(par.getDrivers(), par.getRaces(), twodim_probarr); //calling the ProbRandomRace method
                probTbl = new JTable(twodim_probarr, twodim_probCol); //creating the table
                probTbl.setDefaultEditor(Object.class, null); // To prevent editing
                scrollp3 = new JScrollPane(probTbl); //scrollpane of probabilitytable
                scrollp3.setBounds(50, 700, 500, 200); // bounds of probabilitytable
                dateLbl2.setText(String.valueOf(date)); // printing the probability race date
                guiTbl(par.getDrivers()); //calling the 2d array in guiTbl method inorder to change the values.
                statJtbl.repaint(); //refresh the stattable
                add(scrollp3); // adding the scroll pane2 with the randomtable into jframe

            }
        });
        //------------------------------------------------------------GenerateProbabilityRace end------------------------------------------------------

        //==========================================View completedRaces Start=======================================================
        String[] dateCompArrCol = {
                "Date"
        }; // cloumn heading of date compareDateTbl to comare the race dates.
        String[][] datecompArrRows = new String[par.getRaces().size()][1]; // row of the date compare table
        Collections.sort(par.getRaces(), new DateAscComparator());
        int i = 0;
        for (Race raceD: par.getRaces()) { // loop to get the races one by one
            datecompArrRows[i][0] = String.valueOf(raceD.getDate()); // convert date getting value to a string
            i++;
        }

        completedRaces = new JButton("View completedRaces"); // button to view the completed race dates in ascending order.
        completedRaces.setBounds(650, 310, 200, 20);
        completedRaces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compareDateTbl = new JTable(datecompArrRows, dateCompArrCol); //datecomparing table object
                compareDateTbl.setDefaultEditor(Object.class, null); // To prevent editing
                scrollp4 = new JScrollPane(compareDateTbl); //scrollpane of view completed races
                scrollp4.setBounds(650, 350, 350, 150);
                add(scrollp4);
            }
        });
        //==========================================View completedRaces end=======================================================

        // ---------------------------------------------Search Races start--------------------------------------------------
        // to show the results when user enters an input in the textfileld.
        shownamelbl = new JLabel(); // label object to show the name when searched.
        shownamelbl.setBounds(800, 120, 100, 20); // bounds of the jlable.
        String[] searchR_DispCol = {
                "Date",
                "Position"
        }; // column headings of search results
        serchTxt = new JTextField(); // text field to search the races of a driver
        serchTxt.setBounds(800, 100, 200, 20);
        SearchBtn = new JButton("Search Races"); //object of the buttton Searchbtn
        SearchBtn.setBounds(650, 100, 150, 20); //setting bounds to the Searchbtn jbutton.
        //        SearchBtn.setBackground(Color.BLACK);
        //        SearchBtn.setForeground(Color.WHITE);
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] searchR_Disprow = new String[par.getRaces().size()][2]; // 2d array to display details by a jtable
                shownamelbl.setText(serchTxt.getText()); //acessing the textfiled
                displayWhenSearched(serchTxt.getText(), par.getRaces(), searchR_Disprow); // calling the displayWhenSearched method.
                searchRaceTbl = new JTable(searchR_Disprow, searchR_DispCol); //creating the table and adding the rows and columns
                searchRaceTbl.setDefaultEditor(Object.class, null); // To prevent editing
                searchscrollp = new JScrollPane(searchRaceTbl); //scrollpane
                searchscrollp.setBounds(650, 150, 350, 150); //setting bounds of the searchrace table
                add(searchscrollp);
            }
        });
        // ---------------------------------------------Search Races end--------------------------------------------------

        add(dateLbl); //adding the date lable
        add(dateLbl2); // adding the date label 2
        add(toAscend); //adding the jbutton
        add(toDecend);
        add(generateNewRace); //adding the generatenewrace jbutton.
        add(probabilityRace); //adding the probability button
        add(completedRaces); // adding the view completed race button
        add(scrollp); //adding the scroll pane in to the Jframe
        add(SearchBtn); //adding the search button
        add(serchTxt); //adding the seacrch text filed.
        add(shownamelbl); //adding the label to display the name.
        add(Heading);
        add(dLbl); //adding the fixed date label of GenerateRandomRace
        add(dLbl2); //adding the fixed date label of GenerateProbabilityRace

        setTitle("FORMULAR 1 RACING CAR CHAMPIONSHIP Management System"); //title
        setSize(1100, 950); // size of the window
        setLocationRelativeTo(null); //to center the frame
        getContentPane().setBackground(Color.GRAY); // setting the background colour
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends the program
    }

    public void guiTbl(ArrayList < Formula1Driver > f1driv) { // jtable obj descending points  First display when load the GUI.
        Collections.sort(f1driv, new PointsComparator());
        int i = 0;
        for (Formula1Driver drvdt: f1driv) {
            data[i][0] = drvdt.getName();
            data[i][1] = drvdt.getTeam();
            data[i][2] = drvdt.getLocation();
            data[i][3] = String.valueOf(drvdt.getNoraces()); //integers
            data[i][4] = String.valueOf(drvdt.getNopoints());
            data[i][5] = String.valueOf(drvdt.getNoOffirstplaces());
            data[i][6] = String.valueOf(drvdt.getNoOfsecondPlaces());
            data[i][7] = String.valueOf(drvdt.getNoOfthirdPlaces());
            i++;
        }

    }
    public void Ascendtblobj(ArrayList < Formula1Driver > f1driv) { // jtable obj ascending points comparator
        Collections.sort(f1driv, new AscComp());
        int i = 0;
        for (Formula1Driver drvdt: f1driv) {
            data[i][0] = drvdt.getName();
            data[i][1] = drvdt.getTeam();
            data[i][2] = drvdt.getLocation();
            data[i][3] = String.valueOf(drvdt.getNoraces());
            data[i][4] = String.valueOf(drvdt.getNopoints());
            data[i][5] = String.valueOf(drvdt.getNoOffirstplaces());
            data[i][6] = String.valueOf(drvdt.getNoOfsecondPlaces());
            data[i][7] = String.valueOf(drvdt.getNoOfthirdPlaces());
            i++;
        }

    }
    public void decending(ArrayList < Formula1Driver > f1driv) { // sorts in descending order of positions
        Collections.sort(f1driv, new PositionCompar());
        int i = 0;
        for (Formula1Driver drvdt: f1driv) {
            data[i][0] = drvdt.getName();
            data[i][1] = drvdt.getTeam();
            data[i][2] = drvdt.getLocation();
            data[i][3] = String.valueOf(drvdt.getNoraces()); //integers
            data[i][4] = String.valueOf(drvdt.getNopoints());
            data[i][5] = String.valueOf(drvdt.getNoOffirstplaces());
            data[i][6] = String.valueOf(drvdt.getNoOfsecondPlaces());
            data[i][7] = String.valueOf(drvdt.getNoOfthirdPlaces());
            i++;
        }

    }
    //----------------------------------------------------------
    public Date generateRandomRace(ArrayList < Formula1Driver > f1driv, ArrayList < Race > races, String[][] twodim_Randarr) { // adding a method to generate random race with random positions.
        try {
            ArrayList < Integer > checkval = new ArrayList < > (); // array to store the previous randomly generated values
            int randmonth = (int)(Math.random() * 12) + 1;

            Calendar calend = Calendar.getInstance(); // this is the calender object
            calend.set(2021, randmonth, 0); // setting the Date
            int randDaysOfMonth = calend.get(Calendar.DAY_OF_MONTH); // acessing the days of the month
            int randDay = (int)(Math.random() * randDaysOfMonth) + 1; // cannot be 0 so adds 1

            String dategui = randDay + "/" + randmonth + "/" + 2021; // this is the randomly generated date
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dategui);
            Race race = new Race(date, f1driv.size());
            races.add(race);

            int r = 0;
            for (Formula1Driver drvRand: f1driv) {

                int randomPos;
                while (true) {
                    randomPos = (int)((Math.random() * f1driv.size()) + 1); // creatingrandom positions
                    if (checkval.isEmpty()) {
                        checkval.add(randomPos);
                        break;
                    } else if (!checkval.contains(randomPos)) {
                        checkval.add(randomPos);
                        break;
                    }
                }
                if (randomPos == 1) {
                    drvRand.setNoOffirstplaces();
                } else if (randomPos == 2) {
                    drvRand.setNoOfsecondPlaces();
                } else if (randomPos == 3) {
                    drvRand.setNoOfthirdPlaces();
                }
                drvRand.setNoposition(randomPos);
                drvRand.cal(randomPos); // calling the cal method in Formular1Driver to update the points.
//                drvRand.setNoraces(); //to update the race count
                twodim_Randarr[r][0] = drvRand.getName();
                twodim_Randarr[r][1] = String.valueOf(drvRand.getNoposition()); //getting the position
                race.setDrivDetails(drvRand.getName(), String.valueOf(randomPos)); // calling the set method in race.java class
                r++;
            }
            return date;
        } catch (ParseException ignored) {}
        return null;
    }
    //----------------------------------------------------------------------------

    public Date ProbRandomRace(ArrayList < Formula1Driver > f1driv, ArrayList < Race > races, String[][] twodim_probarr) { // adding a method to generate random race with random positions.
        try {
            ArrayList < Integer > checkval = new ArrayList < > (); // array to store the previous randomly generated values

            int randmonth = (int)(Math.random() * 12) + 1;

            Calendar calend = Calendar.getInstance(); // this is the calender object
            calend.set(2021, randmonth, 0); // setting the Date
            int randDaysOfMonth = calend.get(Calendar.DAY_OF_MONTH); // acessing the days of the month
            int randDay = (int)(Math.random() * randDaysOfMonth) + 1; // cannot be 0 so adds 1

            String dategui = randDay + "/" + randmonth + "/" + 2021; // this is the randomly generated date
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dategui);
            Race race = new Race(date, f1driv.size());
            races.add(race);

            int p = 0;

            Collections.shuffle(f1driv); //shuffling the  exsisting drivers in the drivers array to get random starting positions.

            boolean winbool = false; //boolean value for winning the 1 st position

            for (Formula1Driver drvRand: f1driv) { // for each loop to get the drivers one by one

                int winposition;
                int startpos = f1driv.indexOf(drvRand)+1; //getting the index of starting positions randomly

                while(true) {
                    if(!winbool) {//if dosen't win the 1 st position.
                        int random = (int) (Math.random() * 100) + 1;
                        if (startpos == 1) {
                            // getting random numbers up to 100
                            if (random <= 40 && random >= 1) { // check weather that probability of random  number is in range 40%
                                winbool = true;
                            }
                        } else if (startpos == 2) {
                            if (random <= 70 && random >= 40) { // check weather that probability of random  number is in range 30%
                                winbool = true;
                            }
                        } else if (startpos == 3 || startpos == 4) {
                            if (random <= 11 && random >= 1) { // check weather that probability of random  number is in range 10%
                                winbool = true;
                            }
                        } else if (startpos >= 5 && startpos <= 8) {
                            if (random <= 3 && random >= 1) { // check weather that probability of random  number is in range 2%
                                winbool = true;
                            }
                        } else if (startpos == 9) {// gets 1 st place (if any of above conditions didn't get the 1 st place)
                            winbool = true;
                        }
                    }
                    if(winbool && !checkval.contains(1) || f1driv.size() < 9 && f1driv.indexOf(drvRand) == f1driv.size()-1 && !checkval.contains(1)){
                        winposition = 1;    //if the driver in arraylist is lessthan 9 and the last driver of the arraylist , then it checks weather the
                    }                       //the checkval array dosen't already have the first position then that driver wins the race.
                    else{
                        winposition = (int)(Math.random() * f1driv.size() - 1) + 2;// if the driver fails to win he gets a random position
                    }
                    if (checkval.isEmpty()) {
                        checkval.add(winposition);
                        break;
                    } else if (!checkval.contains(winposition)) {
                        checkval.add(winposition);
                        break;
                    }
                }
                if (winposition == 1) {
                    drvRand.setNoOffirstplaces();
                } else if (winposition == 2) {
                    drvRand.setNoOfsecondPlaces();
                } else if (winposition == 3) {
                    drvRand.setNoOfthirdPlaces();
                }
                drvRand.setNoposition(winposition);
                drvRand.cal(winposition); // calling the cal method in Formular1Driver to update the points.
//                drvRand.setNoraces(); //to update the race count
                twodim_probarr[p][0] = drvRand.getName();
                twodim_probarr[p][1] = String.valueOf(drvRand.getNoposition()); //getting the position
                twodim_probarr[p][2] = String.valueOf(startpos);
                race.setDrivDetails(drvRand.getName(), String.valueOf(winposition)); // calling the set method in race.java
                p++;
            }
            return date;
        } catch (ParseException ignored) {}
        return null;
    }

    //--------------------------------------------------------------------------------------------------------
    public void displayWhenSearched(String name, ArrayList < Race > races, String[][] display2d) { // method to display the the serach resuluts.
        int i = 0;
        for (Race r: races) { // getting the races one by one.
            for (String[] elements: r.getDrivDetails()) { //acessing the elements in 2D array
                if (elements[0] != null && elements[0].equals(name)) { // getting the driver name from 2d array in race.java
                    display2d[i][0] = String.valueOf(r.getDate()); // to display the date
                    display2d[i][1] = elements[1]; // displaying the position
                    break; // to stop finding again and again
                }
            }
            i++; // running of for each loop

        }
    }

} //end of the Formular1GUIclASS
