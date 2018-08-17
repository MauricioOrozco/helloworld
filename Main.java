

import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {        
        System.out.println("What is the numerator?");
        Scanner scan = new Scanner(System.in);
        int numer = scan.nextInt(); 
        
        System.out.println("What is the denominator?");
        //Scanner scan = new Scanner(System.in);
        int denom = scan.nextInt(); 
        
        getSimpFrac(numer,denom);
    }
    
    public static void getSimpFrac(int n,int d)
    {
        int greatCom = 0;
        int low = 0;
        if(n < d)
        {
            low = n;
        } 
        else
        {
            low = d;
        }
        for(int i = low; i > 0; i--)
        {
            if(n%i == 0 && d%i == 0 && i > greatCom)
            {
                greatCom = i;
            }
        }
        
        
        System.out.println("The simplified fraction is " + n/greatCom + "/" + d/greatCom);
    }
}
