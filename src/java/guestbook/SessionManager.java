/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Billy
 */
public class SessionManager {
    
    private List<String> history;
    
    public SessionManager(){
        history = new LinkedList<>();
    }
    
    public void addToHistory(String url){
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	Date date = new Date();
        String time = dateFormat.format(date);        
        
        history.add(time + ";" + url);
    }
    
    
}
