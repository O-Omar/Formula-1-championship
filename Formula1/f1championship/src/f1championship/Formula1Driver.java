/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;



/**
 *
 * @author w1740779
 */
public class Formula1Driver extends Driver { // extending the abstract class

    public Formula1Driver(String name, String location, String team,int noraces) { // constructor of formular1Driver int noraces
        super(name, location, team, noraces);//acess the super class. 
    }
    public void cal(int noposition){ //method to give points awarded for each driver in a race
        switch (noposition) {
            case 1 -> setNopoints(25);
            case 2 -> setNopoints(18);
            case 3 -> setNopoints(15);
            case 4 -> setNopoints(12);
            case 5 -> setNopoints(10);
            case 6 -> setNopoints(8);
            case 7 -> setNopoints(6);
            case 8 -> setNopoints(4);
            case 9 -> setNopoints(2);
            case 10 -> setNopoints(1);
            default -> {
            }
        }
    }
}
