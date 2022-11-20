package fibonacci;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Fibonacci_Rec {
	public static int fib(int n) {
		if((n==0)||(n==1)) {
			return n;
		}
		return(fib(n-1)+fib(n-2));
	}
	public static void main(String args[]) 
    {
        System.out.println("Enter numbers you want to display in fibonacci series");
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        long start1 = System.nanoTime();
        System.out.println("Fibonaci("+n+") is:");
        
        for(int i=0;i<n;i++)
        {
            System.out.print(fib(i)+" ");
        }
        long end1 = System.nanoTime();
        System.out.println();
        
       
        System.out.println("Total time required   "+(end1-start1));     
    }   
}
