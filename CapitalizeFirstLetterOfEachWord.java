package Assignment6;

import java.util.Scanner;

public class CapitalizeFirstLetterOfEachWord {

	public static void capitalizeFirstLet(String str) {
		
	         String[] st=str.split(" ");
        
	         for(int i=0;i<st.length;i++)
	         {
	        	 String s=st[i].substring(0,1);
	        	 String s1=st[i].substring(1,st[i].length());
	        	 
	        	 System.out.print(s.toUpperCase()+s1+" ");
	         }
	}
	}


