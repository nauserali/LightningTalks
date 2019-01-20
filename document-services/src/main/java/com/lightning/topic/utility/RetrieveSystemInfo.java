package com.lightning.topic.utility;

import java.net.InetAddress;
 
public class RetrieveSystemInfo {
	
    public static String getHostIp() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }
    
    public static String getHostName() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostName();
    }
    
    public static String getOSInfo() {
    	return System.getProperty("os.name");
    }
}
