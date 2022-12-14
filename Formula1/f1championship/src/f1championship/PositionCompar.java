/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f1championship;

import java.util.Comparator;

/**
 *
 * @author w1740779
 */
public class PositionCompar implements Comparator < Formula1Driver > { //firstposition comparator
    @Override
    public int compare(Formula1Driver posit1, Formula1Driver posit2) {
        if (posit1.getNoOffirstplaces() == posit2.getNoOffirstplaces()) {
            return 0;
        } else if (posit1.getNoOffirstplaces() < posit2.getNoOffirstplaces()){
            return 1;
        }else{
            return -1;
        }
    }
}