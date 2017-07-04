import java.util.Scanner;

/**
 * Created by prajval on 05/07/17.
 */
public class Gol {

    int length;
    int breadth;
    int number_of_generations;
    int[][] grid1;
    int[][] grid2;

    public Gol(int l,int b, int n)
    {
        length = l;
        breadth = b;
        number_of_generations = n;
        grid1 = new int[l+2][b+2];
        grid2 = new int[l+2][b+2];
    }


    public String[] get_input()
    {
        Scanner sc = new Scanner(System.in);
        String[] input_array = new String[length];
        System.out.println("Enter input:");
        for(int i=0;i<length;i++)
        {
            input_array[i] = sc.nextLine();
        }
        return input_array;
    }

    public void convert_input_into_integer_array(String[] input_array)
    {

        for(int i=0;i<=length+1;i++)
        {
            for(int j=0;j<=breadth+1;j++)
            {
                if(i == 0 || j == 0 || i == length+1 || j == breadth+1)
                {
                    grid1[i][j] = 0;
                    grid2[i][j] = 0;
                }
                else
                {
                    char c = input_array[i-1].charAt(j-1);
                    if(c == '.')
                    {
                        grid1[i][j] = 0;
                        grid2[i][j] = 0;
                    }
                    else
                    {
                        grid1[i][j] = 1;
                        grid2[i][j] = 1;
                    }
                }
            }
        }
    }

    public void generate_next_generation()
    {
        for(int k=1;k<=number_of_generations;k++)
        {
            for(int i=1;i<=length;i++)
            {
                for(int j=1;j<=breadth;j++)
                {
                    int count = grid1[i-1][j-1] + grid1[i-1][j] + grid1[i-1][j+1] +
                            grid1[i][j-1] + grid1[i][j+1] +
                            grid1[i+1][j-1] + grid1[i+1][j] + grid1[i+1][j+1];

                    if(grid1[i][j] == 1)
                    {
                        if(count<2 || count>3) {
                            grid2[i][j] = 0;
                        }
                        else {
                            grid2[i][j] = 1;
                        }
                    }
                    else
                    {
                        if(count == 3) {
                            grid2[i][j] = 1;
                        }
                        else {
                            grid2[i][j] = 0;
                        }
                    }
                }
            }

            for(int i=1;i<=length;i++)
            {
                for(int j=1;j<=breadth;j++)
                {
                    grid1[i][j] = grid2[i][j];
                }
            }
        }
    }

    public void print_current_generation()
    {
        for(int i=1;i<=length;i++)
        {
            for(int j=1;j<=breadth;j++)
            {
                if(grid1[i][j] == 1)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
    }

    public void play()
    {
        String[] input_array = get_input();
        convert_input_into_integer_array(input_array);

        for(int i=1;i<=number_of_generations;i++)
        {
            generate_next_generation();
        }
        print_current_generation();

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Gol g = new Gol(3,3,3);
        Gol g = new Gol(6,18,5);
        g.play();
    }
}
