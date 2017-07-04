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
public class DepthFirstSearch {
    
    int[] visited;
    public int[][] adj_matrix;
    int n,e;
            
    public DepthFirstSearch()
    {
        visited = new int[30];
        adj_matrix = new int[30][30];
    }
    
    public void dfs(int source,DepthFirstSearch d)
    {
        if(visited[source] == 0)
        {
            visited[source] = 1;
            System.out.printf("%d ",source);
            for(int i=0;i<n;i++)
            {
                if(adj_matrix[source][i] == 1 && visited[i] == 0)
                    d.dfs(i,d);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the number of vertices and edges\n");
      
        DepthFirstSearch d = new DepthFirstSearch();
         
        d.n = sc.nextInt();
        d.e = sc.nextInt();
        
        
        for(int i=0;i<d.e;i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            d.adj_matrix[v1][v2] = 1;
        }
        
        d.dfs(2,d);
        
    }
}
