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
public class AscComp implements Comparator < Formula1Driver > { //Ascending Comparator
    @Override
    public int compare(Formula1Driver p1, Formula1Driver p2) {
        if (p1.getNopoints() == p2.getNopoints()) {
            if (p1.getNoOffirstplaces() < p2.getNoOffirstplaces()) {
                return -1;
            } else if (p1.getNoOffirstplaces() > p2.getNoOffirstplaces())
                return 1;
            else return 0;
        } else if (p1.getNopoints() < p2.getNopoints()) {
            return -1;
        } else
            return 1;
    }
}

