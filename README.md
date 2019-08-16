# harness-winrm-repository

Purpose of this project is to provide a utility to validate Winrm network and security settings outside of Harness using 
common network utilities like ping , curl e.t.c 

It will do the following tests in order 

1) Connect to the Winrm socket to check if open (analogous to telnet to port) check port 5985 and port 5986

2) Do a curl to the address to check if Winrm will accept default Winrm soap request 

3) Finally attempt to connect via WINRM4J

All detail logged to standard out . 

Note: in some cases because of a WINRM4J bug you will need to prefix the domain with ./ 

