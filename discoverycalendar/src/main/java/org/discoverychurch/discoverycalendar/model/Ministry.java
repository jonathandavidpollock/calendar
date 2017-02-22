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
public class Ministry 
{
    public static String DC_20_30 = "DC 20-30s";
    public static String DC_ARTS = "DC Arts";
    public static String DC_CARE = "DC Care";
    public static String CLASSES = "Classes";
    public static String DC_GROUP_LIFE = "DC Group Life";
    public static String DC_KIDS = "DC Kids";
    public static String DC_MEN = "DC Men";
    public static String DC_ON_MISSION = "DC On Mission";
    public static String DC_STUDENTS = "DC Students";
    public static String DC_WOMEN = "DC Women";
    
    public static List<String> getMinistries() 
    {
        List<String> campuses = new ArrayList<String>();
        campuses.add(DC_20_30);
        campuses.add(DC_ARTS);
        campuses.add(DC_CARE);
        campuses.add(CLASSES);
        campuses.add(DC_GROUP_LIFE);
        campuses.add(DC_KIDS);
        campuses.add(DC_MEN);
        campuses.add(DC_ON_MISSION);
        campuses.add(DC_STUDENTS);
        campuses.add(DC_WOMEN);
        
        return campuses;
    }
}
