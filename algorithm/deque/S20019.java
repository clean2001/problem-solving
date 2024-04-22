import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String line = sc.next();
            
            int N = line.length();

            if(!isPal(line) || !isPal(line.substring(0, N/2)) || !isPal(line.substring(N-N/2, N))) {
                System.out.println("#" + test_case + " " + "NO");
                continue;
            }
            
           System.out.println("#" + test_case + " " + "YES");
            
        }
		
			
	}
    
    static boolean isPal(String s) {

            Deque<Character> dq = new LinkedList<>();
            for(int i=0; i<s.length(); ++i) {
                dq.addLast(s.charAt(i));
		    }
            
            // 회문 검사
        	int len = s.length();
            for(int i=0; i<len/2; ++i) {
                char f = dq.pollFirst();
                char l = dq.pollLast();
                
                if(f != l) {
                    return false;
                }
        }
        
        return true;
    }
}