package palindromechecker;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=sc.next();
		String s1=s;
		String rev="";
		int len=s.length();
        for(int i=len-1;i>=0;i--)
		  {
			rev=rev+s.charAt(i);
		  }
       // System.out.println(rev);
       if(s1.equals(rev))
        {
        	System.out.println("Given string is Palindrome string");
        }
        else
        {
        	System.out.println("Given string is  not Palindrome string");
            
        }
        	
	}

}
