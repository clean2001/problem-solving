import java.util.*;
class Solution {
    static int M, N; // 높이, 너비
    static String[][] boardArr;
    static int change = 0;
    static int ans=0;
    public int solution(int m, int n, String[] board) {
        M = m; N = n;
        
        boardArr = new String[M][N];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; ++j) {
                boardArr[i][j] = Character.toString(board[i].charAt(j));
            }
        }
        
        while(true) {
            change = 0;
            boolean[][] isRemoved = chk();
            if(change == 0) break;
            boardArr = move(isRemoved);
        }
        
        return ans;
    }
    
    static boolean[][] chk() {
        boolean[][] ret = new boolean[M][N];
        for(int i=0; i<M-1; ++i) {
            for(int j=0; j<N-1; ++j) {
                String cur = boardArr[i][j];
                if(cur.equals("-")) continue;

                if(!cur.equals(boardArr[i+1][j])
                   ||!cur.equals(boardArr[i][j+1])
                   || !cur.equals(boardArr[i+1][j+1])) continue;
                
                
                ret[i][j] = true;
                ret[i][j+1] = true;
                ret[i+1][j] = true;
                ret[i+1][j+1] = true;
                change++;
                
            }
        }
        
        return ret;
    }
    
    static String[][] move(boolean[][] remove) {
        String[][] newBoard = new String[M][N];
        // 한 열씩 옮기기
        for(int i=0; i<N; ++i) {
            int cnt = 0;
            LinkedList<String> list = new LinkedList<>();
            for(int j=0; j<M; ++j) {
                if(remove[j][i]) {
                    cnt++;
                    ans++;
                } else {
                    list.addFirst(boardArr[j][i]);
                }
            }
            
            
            for(int j=0; j<cnt; ++j) {
                list.addLast("-");
            }
            
            for(int j=0; j<M; ++j) {
                newBoard[j][i] = list.pollLast();
            }
        }
        
        return newBoard;
    }
}