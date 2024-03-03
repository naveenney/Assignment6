package Assignment6;
import java.util.Scanner;

public class ValidateEmail {
	
		public static void main(String[] args) {

	        Scanner scan=new Scanner(System.in);
	        System.out.println("Enter your email address:");
	        String email=scan.next();

	        boolean enddot=false;
	        enddot=email.endsWith(".");

	        int indexOfAt=email.indexOf('@');
	        int lastIndexOfAt=email.lastIndexOf('.');
	        
	        int countOfAt=0;

	        for (int i=0;i<email.length();i++) 
	        {
	            if(email.charAt(i)=='@')
	                countOfAt++; 
	            } 
	        String str=email.substring(email.indexOf('@')+1, email.length());
	        int len=str.length();

	        int countofdot=0;
	        for (int i=0;i<len;i++) {
	            if(str.charAt(i)=='.')
	                countofdot++; 
	            }
	            String userName=email.substring(0, email.indexOf('@'));
	            String domainName=email.substring(email.indexOf('@')+1,email.length()); 

	            if ((countOfAt==1)&&(userName.endsWith(".")==false)&&(countofdot==1)&&   
	                  ((indexOfAt+3)<=(lastIndexOfAt)&&!enddot
	                  )) 
	               {
	                   System.out.println("\"Valid email address\"");
	                   }

	               else 
	               {       
	                  System.out.println("\"Invalid email address\""); 
	                  }

	               System.out.println("User name:"+userName+"\n"+"Domain name:"+domainName);

	               

	    
	}
		
	}
