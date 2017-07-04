/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practise;

import java.util.Scanner;

/**
 *
 * @author Prajval
 */
public class GameOfLifeHackerEarth {    
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = 0,n,s;
        int[][] a = new int[30][1000];
        int[][] b = new int[30][1000];
        String[] ss = new String[30];
        
        n = sc.nextInt();  
        //System.out.printf("n = %d\n",n);
        s = sc.nextInt();
        //System.out.printf("s = %d\n",s);
        
        String temp = sc.nextLine();
        
        for(int i=0;i<s;i++)
        {
            String input;
            ss[i] = sc.nextLine();
            m = ss[i].length();
        }
        
        for(int i=0;i<=s+1;i++)
	{
		for(int j=0;j<=m+1;j++)
		{
			if(i == 0 || j == 0 || i == s+1 || j == m+1)
			{
				a[i][j] = 0;
				b[i][j] = 0;
			}
			else
			{
                                char c = ss[i-1].charAt(j-1);
				if(c == '.')
					a[i][j] = 0;
				else
					a[i][j] = 1;
			}
		}
	}
        
        for(int k=1;k<=n;k++)
	{
		for(int i=1;i<=s;i++)
		{
			for(int j=1;j<=m;j++)
			{
				int count = a[i-1][j-1] + a[i-1][j] + a[i-1][j+1] + a[i][j-1] + a[i][j+1] + a[i+1][j-1] + a[i+1][j] + a[i+1][j+1];
				if(a[i][j] == 1)
				{
					if(count<2 || count>3)
						b[i][j] = 0;
					else
						b[i][j] = 1;
				}
				else
				{
					if(count == 3)
						b[i][j] = 1;
					else
						b[i][j] = 0;
				}
				
			}
		}
		for(int i=1;i<=s;i++)
		{
			for(int j=1;j<=m;j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	
	for(int i = 1;i<=s;i++)
	{
		for(int j=1;j<=m;j++)
		{
			if(a[i][j] == 1)
				System.out.printf("X");
			else
				System.out.printf(".");
		}
		System.out.printf("\n");
	}
        
    }
}
