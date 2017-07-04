/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practise;

/**
 *
 * @author Prajval
 */
public class BasicClass {
    private String name;
    private int age;
    
    public BasicClass(int a,String n)
    {
        name = n;
        age = a;
    }
    
    void print_details()
    {
        System.out.printf("Hello %s,you are %d years old.",name,age);
    }
    
    public static void main(String[] args){
        System.out.println("Basic Class example\n");
        BasicClass b = new BasicClass(22,"Prajval");
        b.print_details();
    }
}
