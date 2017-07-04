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
public class LinkedList {
    
    LinkedListNode head = null;
    
    public void insert(int d)
    {
        if(head == null)
        {
            head = new LinkedListNode(d);
        }
        else
        {
            LinkedListNode current = head;
            while(current.next!=null)
            {
                current = current.next;
            }
            current.next = new LinkedListNode(d);
        }
    }
    
    public void print_list()
    {
        LinkedListNode current = head;
        while(head!=null)
        {
            System.out.printf("%d ",head.data);
            head = head.next;
        }
    }
    
    public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);
         LinkedList l = new LinkedList();
         System.out.printf("Enter the numbers\n");
         int d = sc.nextInt();
         while(d!=-1)
         {
             l.insert(d);
             d = sc.nextInt();
         }
         l.print_list();
    }
}
