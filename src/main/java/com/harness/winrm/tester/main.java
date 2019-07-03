/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harness.winrm.tester;

/**
 *
 * @author gregorykroon
 */
import com.harness.winrm.tester.ping;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;


public class main {
    
    
    public static void main(String [] args) throws IOException {
        
         String IpAddress = args[0];
         String Domain = args[1];
         String UserName = args[2];
         String Password = args[3];
         
         Boolean http = true;
         Boolean https = true;
        
        //String IpAddress = "192.168.56.102";
        //String Domain = "WORKGROUP";
        //String UserName = "Administrator";
       //String Password = "Password1@!#";
        
       System.out.println("\nPlease ensure targets have the following configuration \n"
               + "\nAnsible script has been run \n"
               + "https://github.com/ansible/ansible/blob/devel/examples/scripts/ConfigureRemotingForAnsible.ps1 \n"
               + "\nwinrm set winrm/config/Service '@{AllowUnencrypted=\"true\"}'");
       
       
       
       
       
       
        
        
        ping t = new ping();
        
        System.out.println("\n");
        
        if (t.IsAddressReachable(IpAddress , 5986, 2000)) {
            System.out.println("Port 5986 is OPEN and routable \n");
        } else {
            
            System.out.println("Port 5986 is NOT OPEN \n");
        }
            
            
            
            if (t.IsAddressReachable(IpAddress , 5985, 2000)) {
            
            System.out.println("Port 5985 is OPEN and routable \n");
          } else {
                
             System.out.println("Port 5985 is NOT OPEN \n");   
            
        }
            
            
            
        TrustAllCertificates.install();
        
        
        curl s = new curl();
        
        System.out.println("Attempting to query WINRM service for https/ssl \n");
        try {
        s.SoapTestHTTPS(IpAddress);
        
        } 
        catch (SocketTimeoutException sslsocketexception) 
        {
          System.out.println("Not able to query WINRM service for https/ssl \n");
          https = false;
        } 
        catch (ConnectException sslconnectexception) 
        {
            System.out.println("Not able to query WINRM service for https/ssl \n");
            https = false;
        }    
        
        
       
        
        System.out.println("\n");
        System.out.println("Attempting to query WINRM service for http \n");
        try {
        s.SoapTestHTTP(IpAddress);
        } 
        catch (SocketTimeoutException socketexception) {
          System.out.println("Not able to query WINRM service for http \n");
          http = false;
        }
        catch (ConnectException httpconnectexception) 
        {
            System.out.println("Not able to query WINRM service for http \n");
            http = false;
        }      
        
         //boolean test = false;
        
        if (https == true) {
        
        
        
        System.out.println("Attempting to connect to HTTPS service Port 5986 using WINRM4J and run dir command \n");
       
        winrm u = new winrm();
        try {
        u.WinRm(IpAddress, Domain, UserName, Password , 5986 , true);
        }
        catch (ConnectException winrmsocketexception) {
            System.out.println("WINRM4J unable to connect to HTTPS service Port 5986" + " " + winrmsocketexception + "\n");
        }
        
        }
        
        if (http == true ) {
            
            
        System.out.println("Attempting to connect to HTTP service Port 5985 using WINRM4J and run dir command \n");
       
        winrm u = new winrm();
        try {
        u.WinRm(IpAddress, Domain, UserName, Password , 5985 , false);
        }
        catch (ConnectException winrmsocketexception) {
            System.out.println("WINRM4J unable to connect to HTTP service Port 5985" + " " + winrmsocketexception + "\n");
        }
        
        }
            
            
        }
        
        
        
        
    }
    
    
   
    
    

        
