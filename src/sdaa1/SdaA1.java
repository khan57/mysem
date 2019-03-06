/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaa1;

import java.io.IOException;
import java.util.StringTokenizer;



/**
 *
 * @author Haseeb
 */
public class SdaA1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//
//String name = "Haseeb";
//String name2= "haseeb";
//int check = name.compareTo(name2);
//System.out.println(check);
//System.out.println(name.compareToIgnoreCase(name2));
//    new menubar().showmenubar();
        
    
    String delims = " ";
		String splitString = "one two three four five";
 
		System.out.println("StringTokenizer Example: \n");
		StringTokenizer st = new StringTokenizer(splitString, delims);
		while (st.hasMoreElements()) {
			System.out.println("StringTokenizer Output: " + st.nextElement());
		}
 
		System.out.println("\n\nSplit Example: \n");
		String[] tokens = splitString.split(delims);
		int tokenCount = tokens.length;
		for (int j = 0; j < tokenCount; j++) {
			System.out.println("Split Output: "+ tokens[j]);
		}
	
    
    }
}
