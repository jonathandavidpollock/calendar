/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.discoverychurch.discoverycalendar.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matt
 */
public class Campus 
{
    public static String CENTRAL = "Central Campus";
    public static String EAST = "East Campus";
    public static String SOUTHWEST = "Southwest Campus";
    
    public static List<String> getCampuses() 
    {
        List<String> campuses = new ArrayList<String>();
        campuses.add(CENTRAL);
        campuses.add(EAST);
        campuses.add(SOUTHWEST);
        
        return campuses;
    }
}
