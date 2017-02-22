/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.discoverychurch.discoverycalendar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.discoverychurch.discoverycalendar.model.ApiManager;
import org.discoverychurch.discoverycalendar.model.CalendarUrlManager;
import org.discoverychurch.discoverycalendar.model.Plan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Matt
 */
@Controller
public class ApiController
{    
    @RequestMapping(value = "/api/plans/{campus}/{ministry}", 
            method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<ArrayList<Plan>> getPlans(@PathVariable(value = "campus") String campus, 
            @PathVariable(value = "ministry") String ministry) 
            throws IOException 
    {    
        String url = CalendarUrlManager.getInstance().getUrl(campus, ministry);
        
        Map<String, Plan> plans = 
                ApiManager.getInstance().getPojoArrayOfPlansForUrl(url);
        
        ArrayList<Plan> planList = new ArrayList<Plan>(plans.values());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        return new ResponseEntity<ArrayList<Plan>>(planList, headers, HttpStatus.OK);
    }
}
