import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static int N;
    public static boolean arr[][];
    public static int ans = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            arr = new boolean[N][N];
            ans = 0;
            dfs(0);
            System.out.println("#" + test_case + " " + ans);
		}
	}
    
    // 한 행(row)에는 하나의 퀸만 놓여야 합니다.
    // 이 함수는 depth번째 말을 depth번째 행에서 어떤 열(col)에 놓을지를 결정하는 함수입니다.
    private static void dfs(int depth) {
        if(depth == N) {          
            ans++;
            return;
        }
        
        for(int i=0; i<N; ++i) {
            // (depth, i) 칸에 퀸을 놓을 수 있는지를 검사합니다.
            if(isOk(depth, i)) {
                arr[depth][i] = true;
                dfs(depth+1);
                arr[depth][i] = false;
            }
        }
    }
    
    private static boolean isOk(int row, int col) {
        // 같은 열 검사
        for(int i=0; i<row; ++i) {
            if(arr[i][col]) return false;
        }
        
        // 왼쪽 대각선 검사
       	int y = row-1, x = col-1;
        while(true) {
            if(y < 0 || y >= N || x < 0 || x >=N) break;
            
            if(arr[y][x]) return false;
            y--; x--;
        }
        
        // 오른쪽 대각선 검사
       	y = row-1; x = col+1;
        while(true) {
            if(y < 0 || y >= N || x < 0 || x >=N) break;
            
            if(arr[y][x]) return false;
            y--; x++;
        }
        return true;
    }
}