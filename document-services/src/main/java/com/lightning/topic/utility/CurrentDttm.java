package com.lightning.topic.utility;


import java.text.SimpleDateFormat;
import java.util.Date; 
public class CurrentDttm {
	
public String getCurrentDttm() {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	Date date = new Date();
	return formatter.format(date);
}

}
