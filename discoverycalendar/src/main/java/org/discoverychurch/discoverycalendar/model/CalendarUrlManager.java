/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.discoverychurch.discoverycalendar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matt
 */
public class CalendarUrlManager 
{
    private static CalendarUrlManager instance;
    private Map<String, Map<String, String>> urlManager;
    
    public static CalendarUrlManager getInstance() 
    {
        if (instance == null) 
        {
            instance = new CalendarUrlManager();
        }
        return instance;
    }
    
    protected CalendarUrlManager() 
    {
        loadUrls();
    }
    
    public String getUrl(String campus, String ministry) 
    {
        Map<String, String> ministriesForCampus = urlManager.get(campus);
        
        if (ministriesForCampus == null || ministriesForCampus.isEmpty())
        {
            return "";
        }
        
        String url = ministriesForCampus.get(ministry);
        
        if (url == null)
        {
            return "";
        }
        
        return url;
    }
    
    private void loadUrls() 
    {
        urlManager = new HashMap<String, Map<String, String>>();
        List<String> campuses = Campus.getCampuses();
        for (String campus : campuses) 
        {
            urlManager.put(campus, loadCampusUrls(campus));
        }
    }
    
    private Map<String, String> loadCampusUrls(String campus) 
    {
        if (campus.equals(Campus.CENTRAL)) 
        {
            return loadCentralCampusUrls();
        }
        else if (campus.equals(Campus.EAST)) 
        {
            return loadEastCampusUrls();
        }
        else if (campus.equals(Campus.SOUTHWEST)) 
        {
            return loadSouthwestCampusUrls();
        }
        
        return null;
    }
    
    private Map<String, String> loadCentralCampusUrls() 
    {
        Map<String, String> urls = new HashMap<String, String>();
        
        urls.put(Ministry.CLASSES, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJpzxIq7ILEoMbe4mgEAaK4IMQ==453a072b6e26c54c0b416bedaf7241b14ada4ae4");
        urls.put(Ministry.DC_20_30, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJp1xIq7ILEoMbe4mgEAaJYILw==2397f3f89ecd27d6d725bbf09df59604da9955bc");
        urls.put(Ministry.DC_ARTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZDIaMVdkFiUmFtczQAAY6EHxQ==c8b647faeda58fde7442f8e126519a136681142d");
        urls.put(Ministry.DC_CARE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJp9xIq7ILEoMbe4mgEAaKIIMA==977fadb4de840bd7821aa94a08f369576ce7429b");
        urls.put(Ministry.DC_GROUP_LIFE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJpxxIq7ILEoMbe4mgEAaH4ILQ==f94dabcbf2d4e6830c2fa10628dd42e5ea1de0e1");
        urls.put(Ministry.DC_KIDS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJp7xIq7ILEoMbe4mgEAaLoIMg==955e7df538df1c22662e61785ffeb6be9dbd2463");
        urls.put(Ministry.DC_MEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJp3xIq7ILEoMbe4mgEAaMYIMw==a437f93d9a2a44feab3e65f66edc3936ddf8638b");
        urls.put(Ministry.DC_ON_MISSION, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZJp_xIq7ILEoMbe4mgEAaNIINA==86900090cae8f789f59c3489bf1072e49ae64752");
        urls.put(Ministry.DC_STUDENTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZFpwxIq7ILEoMbe4mgEAaN4INQ==6f2ee3aada3d2fef6558f21d1ba87fe6bf0d05d4");
        urls.put(Ministry.DC_WOMEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZFp4xIq7ILEoMbe4mgEAaOoINg==84731e1fd746100818340dee5be06f19f30adb52");
        
        return urls;
    }
    
    private Map<String, String> loadEastCampusUrls() 
    {
        Map<String, String> urls = new HashMap<String, String>();
        
        urls.put(Ministry.CLASSES, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHp42Iq7ILEoMbe4mgEAa98IdQ==8a943991d9a7c913168a9a088c3ac1d8b0f63aab");
        urls.put(Ministry.DC_20_30, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHp62Iq7ILEoMbe4mgEAbA8IeQ==23a1c2a0617e9bbf6fcc7cff6b81365455533f71");
        urls.put(Ministry.DC_ARTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZDIaMVdkFiUmFtczQAAY6EHxQ==c8b647faeda58fde7442f8e126519a136681142d");
        urls.put(Ministry.DC_CARE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHp82Iq7ILEoMbe4mgEAa_cIdw==667f5b07699ca8e5368b59da803d29f7451ca137");
        urls.put(Ministry.DC_GROUP_LIFE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp_2Iq7ILEoMbe4mgEAa8cIcw==1c63255e75b16a5d5a6e04daf5ba18988e789620");
        urls.put(Ministry.DC_KIDS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp72Iq7ILEoMbe4mgEAa68IcQ==e5d3200da6f719fe7a754d3c43f8965cbcb75a23");
        urls.put(Ministry.DC_MEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp92Iq7ILEoMbe4mgEAa5cIbw==76bb7a1657e8cabbd68c1f78c3d5dcda941a0a07");
        urls.put(Ministry.DC_ON_MISSION, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp52Iq7ILEoMbe4mgEAa38IbQ==fb2c7c9670def2de9b6566bc884cad0792acb110");
        urls.put(Ministry.DC_STUDENTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp-2Iq7ILEoMbe4mgEAa2cIaw==71a6ef58a099fb7a1527e7405ad67cea2f845122");
        urls.put(Ministry.DC_WOMEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZNpw2Iq7ILEoMbe4mgEAaZMIRA==84b15e21f2f8d4978d53bb2a090aec1ed183e4d4");
        
        return urls;
    }
    
    private Map<String, String> loadSouthwestCampusUrls() 
    {
        Map<String, String> urls = new HashMap<String, String>();
        
        urls.put(Ministry.CLASSES, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHp02Iq7ILEoMbe4mgEAasIdg==76adc5e86ad7980cfada0e145b4fb5397a159fd6");
        urls.put(Ministry.DC_20_30, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHp22Iq7ILEoMbe4mgEAbBsIeg==b6a16412104a9757ed3571f378b3a8c70e0446b9");
        urls.put(Ministry.DC_ARTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZDIaMVdkFiUmFtczQAAY6EHxQ==c8b647faeda58fde7442f8e126519a136681142d");
        urls.put(Ministry.DC_CARE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHpy2Iq7ILEoMbe4mgEAbAMIeA==91df3ce72d146ea7341ca3df74f9dfa8c3f6d0a8");
        urls.put(Ministry.DC_GROUP_LIFE, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZHpw2Iq7ILEoMbe4mgEAa9MIdA==0e25e5f7b886331e4ef832109e0d6ac67c8b9877");
        urls.put(Ministry.DC_KIDS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp32Iq7ILEoMbe4mgEAa7sIcg==f9a6aa715cc2fb67ddf510486ed024cead0bb2d8");
        urls.put(Ministry.DC_MEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLpz2Iq7ILEoMbe4mgEAa6MIcA==dd294757a871dbbc73c3553533fdc0a31a9f942b");
        urls.put(Ministry.DC_ON_MISSION, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLp12Iq7ILEoMbe4mgEAa4sIbg==edce7b7057d6789b110bb110c59c36f28113e16d");
        urls.put(Ministry.DC_STUDENTS, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZLpx2Iq7ILEoMbe4mgEAa3MIbA==04f278c5e921bcd31137379f89a71229351bb104");
        urls.put(Ministry.DC_WOMEN, "http://resources.planningcenteronline.com/icals/eJxj4ajmsGLLz2Ry0rJiT03LZNp42Iq7ILEoMbe4mgEAaZ8IRQ==aa8389d5de04c1b529d89240a7bdb0f22f842bac");
        
        return urls;
    }
}
