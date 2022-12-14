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
public class DateAscComparator implements Comparator <Race>{// comparator for sort the dates in ascending order

    @Override
    public int compare(Race d1, Race d2) { // date comparator
        if (d1.getDate().compareTo(d2.getDate())==0){ // if d1 equals d2
            return 0;
        }else if (d1.getDate().compareTo(d2.getDate())>0) { // if d1 > d2 its a positive value so  should return 1
            return 1;
        }else{
            return -1; //if d1 < d2 its a negative value so  should return -1
        }
    }
}


