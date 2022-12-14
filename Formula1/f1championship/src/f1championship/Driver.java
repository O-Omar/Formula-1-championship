/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;

import java.io.Serializable;

/**
 *
 * @author w1740779
 */
public abstract class Driver  implements Serializable{ //abstract class driver
    //variables
    private String name;
    private String location;
    private String team;
    private int noposition;
    private int nopoints;
    private int noraces;
    private int noOffirstplaces;
    private int NoOfsecondPlaces;
    private int NoOfthirdPlaces;
    
    public Driver(String name, String location, String team,int noraces){//
        this.name = name;
        this.location = location;
        this.team = team;
        this.noraces = noraces;
    }

   

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

      
    public String getLocation(){
        return location;
    }
    
    public String getTeam(){
        return team;
    }
  
   public int getNoposition() {
        return noposition;
    }
    public void setNoposition(int noposition) {
        this.noposition = noposition;
    }

    
      public int getNopoints() {
        return nopoints;
    }
    public void setNopoints(int nopoints) {
        this.nopoints += nopoints;
    }
    
    
    public int getNoraces() {
        return noraces;
    }
    
    public void setNoraces() { //To calculate the no of races in Formular1Championshipmanager
        this.noraces++;    
    }
    
    
    public int getNoOffirstplaces() {
        return noOffirstplaces;
    }
    public void setNoOffirstplaces() {
        this.noOffirstplaces++;
    }
    
    
    
    public int getNoOfsecondPlaces() {
        return NoOfsecondPlaces;
    }
    public void setNoOfsecondPlaces() {
        this.NoOfsecondPlaces++;
    }
    
    
    
      public int getNoOfthirdPlaces() {
        return NoOfthirdPlaces;
    }
    public void setNoOfthirdPlaces() {
        this.NoOfthirdPlaces++;
    } 
}