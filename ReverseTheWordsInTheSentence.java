package Assignment6;

import java.util.Scanner;

public class ReverseTheWordsInTheSentence {

	public static void reverseWordsInTheSentence(String str){
		
		   String[] s=str.split(" ");
		   
		       for(int i=s.length-1;i>=0;i--)
		       {
			      System.out.print(s[i]+" ");
		           }
	}
}
	


