/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author w1740779
 */
public class Race implements Serializable {
//race class
    Date date;
    private String[][] drivDetails; // drivDetails 2D array
    private int c = 0; // innitialising the variable c

    public Race(Date ddate, int a) { // constructor of race
        this.drivDetails = new String[a][2]; // 2D array to get the name and position
        this.date = ddate;
    }

    public String[][] getDrivDetails() {
        return drivDetails;
    } // getting the getDrivDetails 2D array

    public void setDrivDetails(String dname, String position) {
        this.drivDetails[c][0] = dname;
        this.drivDetails[c][1] = position;
        c++; //variable to increment the 2D array one by one.
    }

    public Date getDate() {
        return date;
    }
}
