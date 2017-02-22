/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.discoverychurch.discoverycalendar.model;

/**
 *
 * @author Matt
 */
public class Plan 
{
    private String m_id;
    private String m_description;
    private String m_summary;
    private String m_location;
    private boolean m_allDay;
    private String m_start;
    private String m_end;
    private String m_url;
    
    public Plan()
    {
        super();
    }

    public String getId() 
    {
        return m_id;
    }

    public void setId(String id) 
    {
        this.m_id = id;
    }
    
    public String getDescription() 
    {
        return m_description;
    }
    
    public void setDescription(String description) 
    {
        this.m_description = description;
    }
    
    public String getSummary() 
    {
        return m_summary;
    }
    
    public void setSummary(String summary) 
    {
        this.m_summary = summary;
    }
    
    public String getLocation() 
    {
        return m_location;
    }
    
    public void setLocation(String location) 
    {
        this.m_location = location;
    }

    public String getTitle() 
    {
        StringBuilder sb = new StringBuilder();
        String summary = m_summary == null ? "" : m_summary.replaceAll("\\\\n", "");
        sb.append(summary);
        sb.append("\\n");
        String description = m_description == null ? "" : m_description.replaceAll("\\\\n", "");
        sb.append(description);
        sb.append("\\n");
        String location = m_location == null ? "" : m_location.replaceAll("\\\\n", "");
        sb.append("Location: ");
        sb.append(location);
        
        return sb.toString();
    }

    public boolean isAllDay() 
    {
        return m_allDay;
    }

    public void setAllDay(boolean allDay) 
    {
        this.m_allDay = allDay;
    }

    public String getStart() 
    {
        return m_start;
    }

    public void setStart(String start) 
    {
        this.m_start = start;
    }

    public String getEnd() 
    {
        return m_end;
    }

    public void setEnd(String end) 
    {
        this.m_end = end;
    }

    public String getUrl() 
    {
        return m_url;
    }

    public void setUrl(String url) 
    {
        this.m_url = url;
    }
}
