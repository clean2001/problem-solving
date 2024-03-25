// 자물쇠와 열쇠
class Solution {
    static int N, M;
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        
        for(int i=0; i<4; ++i) {
            if(i > 0) key = rotate(key); 
            for(int y=-(N-1); y<N; ++y) {
                for(int x=-(N-1); x<N; ++x) {
                    if(chk(y, x, key, lock)) return true;
                }
            
            }
        }
        
        return false;
    }
    
    public static boolean chk(int y, int x, int[][] key, int[][] lock) {
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(y+i < 0 || y+i >= M || x+j < 0 || x+j >= M) {
                    if(lock[i][j] == 0) return false;
                } else if(lock[i][j] == key[y+i][x+j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] rotate(int[][] key){
        int new_key[][] = new int[M][M];
        
        for(int i=0; i<M; ++i) {
            for(int j=0; j<M; ++j) {
                new_key[i][j] = key[M-1-j][i];
            }
        }
        
        return new_key;
    }
    
    
}