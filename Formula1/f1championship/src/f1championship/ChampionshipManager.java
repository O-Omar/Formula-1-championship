/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package f1championship;

import java.io.IOException;

/**
 *
 * @author w1740779
 */
public interface ChampionshipManager {  //this is the ChampionshipManger Interface
    public void createNewDriver(); 
    public void deleteDriver();
    public void changeDriver();
    public void displayStats();
    public void displayTable();
    public void addRace();
    public void saveInfo()throws IOException;;
    public void recoverInfo()throws IOException;;
    
    
    
    
}
