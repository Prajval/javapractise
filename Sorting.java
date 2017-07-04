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
public class Sorting {
    
    void bubblesort(int[] a,int n)
    {
        
        for(int i=0;i<n;i++)
        {
                System.out.printf("%d ",a[i]);
        }
        
        System.out.printf("Bubble Sort\n");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j+1]<a[j])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
                System.out.printf("%d ",a[i]);
        }
        
    }
    
    void insertionsort(int[] a,int n)
    {
        System.out.printf("Insertion Sort\n");
        for(int i=1;i<n;i++)
        {
            int key = a[i];
            int j = i-1;
            while(j>=0 && key<a[j])
            {
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = key;
        }
        
        for(int i=0;i<n;i++)
        {
                System.out.printf("%d ",a[i]);
        }
    }
    
    void selectionsort(int[] a,int n)
    {
        System.out.printf("Selection Sort\n");
        for(int i=0;i<n;i++)
        {
            int smallest = i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]<a[smallest])
                    smallest = j;
            }
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
        
        for(int i=0;i<n;i++)
        {
                System.out.printf("%d ",a[i]);
        }
        
    }
    
    void Merge(int[] a,int x,int y,int mid)
    {
        int[] b = new int[30];
        int i = x;
        int j = mid+1;
        int k = x;
        while(i<=mid && j<=y)
        {
            if(a[i]<=a[j])
            {
                b[k] = a[i];
                k = k + 1;
                i = i + 1;
            }
            else
            {
                b[k] = a[j];
                k = k + 1;
                j = j + 1;
            }
        }
        while(i<=mid)
        {
            b[k] = a[i];
            k = k + 1;
            i = i + 1;
        }
        while(j<=y)
        {
            b[k] = a[i];
            k = k + 1;
            j = j + 1;
        }
        
        for(int xx=x;xx<=y;xx++)
        {
            a[xx] = b[xx];
        }
    }
    
    void Mergesorthelper(int[] a,int i,int j,Sorting s)
    {
        if(i<j)
        {
            int mid = (i+j)/2;
            s.Mergesorthelper(a,i,mid,s);
            s.Mergesorthelper(a,mid+1,j,s);
            s.Merge(a,i,j,mid);
        }
    }
    
    void mergesort(int[] a,int n,Sorting s)
    {
        System.out.printf("Merge Sort\n");
        
        s.Mergesorthelper(a,0,n-1,s);
        
        for(int i=0;i<n;i++)
        {
                System.out.printf("%d ",a[i]);
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n and n numbers");
        int n = sc.nextInt();
        int[] a = new int[30];
        
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        
        Sorting s = new Sorting();
        //s.bubblesort(a, n);
        //s.insertionsort(a, n);
        //s.selectionsort(a, n);
        s.mergesort(a,n,s);
    }
    
}
