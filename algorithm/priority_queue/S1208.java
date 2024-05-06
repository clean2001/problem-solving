
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
// 1208. Flatten
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            PriorityQueue<Integer> biggest = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> smallest = new PriorityQueue<Integer>();
            
            int N = sc.nextInt();
            for(int i=0; i<100; ++i) {
                int num = sc.nextInt();
                biggest.add(num);
                smallest.add(num);
            }
            
            for(int i=0; i<N; ++i) {
                int big = biggest.poll();
                int small = smallest.poll();
                
                if(big > small) {
                    biggest.add(big - 1);
                    smallest.add(small + 1);
                }
            }
            
            System.out.println("#" + test_case + " " + (biggest.poll() - smallest.poll()));
		}
	}
}