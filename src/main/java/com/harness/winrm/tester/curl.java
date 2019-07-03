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


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;



public class curl {

    

    
    public void SoapTestHTTPS(String IpAddress) throws MalformedURLException, IOException {
        
        
        
        String RequestData = "&lt;s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsmid=\"http://schemas.dmtf.org/wbem/wsman/identity/1/wsmanidentity.xsd\"&gt;&lt;s:Header/&gt;&lt;s:Body&gt;&lt;wsmid:Identify/&gt;&lt;/s:Body&gt;&lt;/s:Envelope&gt;";
        
        
        URL url = new URL("https://" + IpAddress + ":5986/wsman");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Length", "0");
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
        con.setRequestProperty("WSMANIDENTIFY","unauthenticated");
        //con.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        
        //con.setRequestProperty(IpAddress, 344);
        con.setDoOutput(true);
      
        con.setConnectTimeout(10000);
    con.setReadTimeout(10000);
    
    
    OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
        writer.write(RequestData);
        writer.close();
    
    
    
    // retrieve the response from server
    InputStream is = null;
    try {
      is = con.getInputStream();
      int ch;
      StringBuffer sb = new StringBuffer();
      while ((ch = is.read()) != -1) {
        sb.append((char) ch);
      }
      System.out.println(sb.toString());
    } catch (IOException e) {
      throw e;
    } finally {
      if (is != null) {
        is.close();
      }
    }
        
    
    

        
    }    
    
    public void SoapTestHTTP(String IpAddress) throws MalformedURLException, IOException {
        
        String RequestData = "&lt;s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsmid=\"http://schemas.dmtf.org/wbem/wsman/identity/1/wsmanidentity.xsd\"&gt;&lt;s:Header/&gt;&lt;s:Body&gt;&lt;wsmid:Identify/&gt;&lt;/s:Body&gt;&lt;/s:Envelope&gt;";
        
        
        URL url = new URL("http://" + IpAddress + ":5985/wsman");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Length", "0");
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
        con.setRequestProperty("WSMANIDENTIFY","unauthenticated");
        //con.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        
        //con.setRequestProperty(IpAddress, 344);
        con.setDoOutput(true);
      
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
    
    
    OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
        writer.write(RequestData);
        writer.close();
    
    
    
    // retrieve the response from server
    InputStream is = null;
    try {
      is = con.getInputStream();
      int ch;
      StringBuffer sb = new StringBuffer();
      while ((ch = is.read()) != -1) {
        sb.append((char) ch);
      }
      System.out.println(sb.toString());
      System.out.println("\n");
    } catch (IOException e) {
      throw e;
    } finally {
      if (is != null) {
        is.close();
      }
    }
        
    
    

        
    }    
    
    
    
    
    
}
