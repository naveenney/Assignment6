package Assignment6;
import java.util.Scanner;

public class CountVowels {
	
   public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.print("enter the input(Only alphabet):");
		String str=scan.next();
		
		str=str.toLowerCase();
		
		int cnt=0;
		
		for(int i=0;i<str.length();i++)
		{
			char temp=str.charAt(i);
			
			switch(temp)
			{
			   case 'a','e','i','o','u': 
				   cnt++;
			}
		}
	   System.out.println("vowels in the string:"+cnt);
	}
}
