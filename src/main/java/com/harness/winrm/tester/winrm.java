/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harness.winrm.tester;

import io.cloudsoft.winrm4j.client.WinRmClientContext;
import io.cloudsoft.winrm4j.winrm.WinRmTool;
import io.cloudsoft.winrm4j.winrm.WinRmToolResponse;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.client.config.AuthSchemes;

/**
 *
 * @author gregorykroon
 */
public class winrm {
    
    
    public static void WinRm  (String IpAddress , String Domain , String UserName , String Password , int Port , boolean ssl) throws SocketException , SocketTimeoutException , ConnectException {
	
    
    //System.out.println("Attempting to run dir command on target via WIRM4J \n");
    
    WinRmClientContext context = WinRmClientContext.newInstance();
    
    

WinRmTool tool = WinRmTool.Builder.builder(IpAddress , Domain, UserName, Password)
    .authenticationScheme(AuthSchemes.NTLM)
    .port(Port)
    .disableCertificateChecks(true)
    .useHttps(ssl)
    .context(context)
    .build();




//tool.executePs("echo dir");
WinRmToolResponse p = tool.executePs("dir");
System.out.println(p.getStdOut());
//tool.executeCommand("echo 123346573i93i9i939i93i99939393 > C:\test.txt");
context.shutdown();
    
    
}
    
    
}
