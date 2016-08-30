/*
Write a class called myRegex which will contain a string pattern. Write a regular expression and assign it to the pattern 
such that it can be used to validate an IP address. Use the following definition of an IP address:

IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
Some valid IP address:

000.12.12.034
121.234.12.12
23.45.12.56
Some invalid IP address:

000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
*/
import java.io.*;
import java.util.*;

class myRegex {
    /*
    1) \\d{1,2} catches any one or two digit number
    2) (0|1)\\d{2} catches any three digit number starting with 0 or 1.
    3) 2[0-4]\\d catches numbers between 200 and 249.
    4) 25[0-5] catches numbers between 250 and 255.
       \d represents digits in regular expressions, same as [0-9]
    */
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public String pattern = "(" + zeroTo255 + "\\.){3}" + zeroTo255;
}

class Solution { 
 
  
    public static void main(String[] args) {
      
        String[] ips = {"000.12.12.034","121.234.12.12","23.45.12.56","00.12.123.123123.123","122.23","Hello.IP"};
        for (String IP : ips) {
            System.out.println(IP + " : " + IP.matches(new myRegex().pattern));   
        }
    }
}
