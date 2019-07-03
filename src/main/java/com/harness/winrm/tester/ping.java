/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harness.winrm.tester;


import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ping {
    
    public static boolean IsAddressReachable(String address, int port, int timeout) {
		try {
 
			try (Socket crunchifySocket = new Socket()) {
				// Connects this socket to the server with a specified timeout value.
				crunchifySocket.connect(new InetSocketAddress(address, port), timeout);
			}
			// Return true if connection successful
			return true;
		}catch (IOException exception) {
			//exception.printStackTrace();
                        
                        
                        
                        return false;
                }
        //connexception.printStackTrace();
        // Return false if connection fails
        
                
    }
    
    

    
}
