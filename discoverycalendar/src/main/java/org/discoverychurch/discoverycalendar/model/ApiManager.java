/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.discoverychurch.discoverycalendar.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Matt
 */
public class ApiManager 
{
    private static ApiManager instance;
    
    public static ApiManager getInstance() 
    {
        if (instance == null) 
        {
            instance = new ApiManager();
        }
        return instance;
    }
    
    protected ApiManager() 
    {
    }
    
    public String getJsArrayOfPlansForUrl(String url) throws IOException 
    {
        Map<String, Plan> plans = performPlanningCenterAPICall(url);
        
        return buildJavascriptArrayOfPlans(plans);
    }
    
    public Map<String, Plan> getPojoArrayOfPlansForUrl(String url) throws IOException
    {
        return performPlanningCenterAPICall(url);
    }
    
    private Map<String,Plan> performPlanningCenterAPICall(String url) throws IOException
    {
        Map<String,Plan> plans = new HashMap<String,Plan>();
        
        BufferedReader br = performAPICall(url);
        
        String line;
        
        while ((line = br.readLine()) != null)
        {
            if (line.equals("BEGIN:VEVENT"))
            {
                Plan p = buildPlanFromAPICall(br);
                plans.put(p.getId(), p);
            }
        }
        
        br.close();
        
        return plans;
    }
    
    private BufferedReader performAPICall(String url) throws IOException
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity responseEntity = httpResponse.getEntity();
        InputStream responseStream = responseEntity.getContent();
        
        BufferedReader br = new BufferedReader(
                new InputStreamReader(responseStream));
        
        return br;
    }
    
    private Plan buildPlanFromAPICall(BufferedReader br) throws IOException
    {
        String line;
        Plan plan = new Plan();
        int currentSection = 0;
        
        while ((line = br.readLine()) != null)
        {
            if (line.startsWith("DTEND;"))
            {
                currentSection = 0;
                int len = line.length();
                int datePos = len - 15;
                plan.setEnd(line.substring(datePos));
            }
            
            if (line.startsWith("DTSTART;"))
            {
                currentSection = 0;
                int len = line.length();
                int datePos = len - 15;
                plan.setStart(line.substring(datePos));
            }
            
            if (line.startsWith("UID:"))
            {
                currentSection = 0;
                plan.setId(line.substring(4));
            }
            
            if (line.startsWith("DESCRIPTION:"))
            {
                currentSection = 1;
                plan.setDescription(line.substring(12));
            }
            
            if (line.startsWith(" ") && currentSection == 1)
            {
                plan.setDescription(plan.getDescription().concat(
                        line.substring(1)));
            }
            
            if (line.startsWith("SUMMARY:"))
            {
                currentSection = 2;
                plan.setSummary(line.substring(8));
            }
            
            if (line.startsWith(" ") && currentSection == 2)
            {
                plan.setSummary(plan.getSummary().concat(
                        line.substring(1)));
            }
            
            if (line.startsWith("LOCATION:"))
            {
                currentSection = 0;
                plan.setLocation(line.substring(9));
            }
            
            if (line.equals("END:VEVENT"))
            {
                currentSection = 0;
                break;
            }
        }
        
        return plan;
    }
    
    private String buildJavascriptArrayOfPlans(Map<String,Plan> plans)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (String planId : plans.keySet())
        {
            Plan p = plans.get(planId);
            sb.append("{");
            sb.append("id: \"");
            sb.append(p.getId());
            sb.append("\", title: \"");
            sb.append(p.getTitle());
            sb.append("\", allDay: false");
            sb.append(", start: \"");
            sb.append(p.getStart());
            sb.append("\", end: \"");
            sb.append(p.getEnd());
            sb.append("\"},");
        }
        
        sb.deleteCharAt(sb.lastIndexOf(","));
        
        sb.append("]");        
        return sb.toString();
    }
}
