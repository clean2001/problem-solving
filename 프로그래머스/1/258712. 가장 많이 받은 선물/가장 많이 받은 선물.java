import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] count = new int[friends.length];
        int[][] table = new int[friends.length][friends.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        // 맵 만들기
        for(int i=0; i<friends.length; ++i) {
            map.put(friends[i], i);
        }
        
        // 초기화
        for(int i=0; i<friends.length; ++i) {
            for(int j=0; j<friends.length; ++j) {
                table[i][j] = 0;
            }
            count[i] = 0;
        }
        
        // 선물 테이블 만들기
        for(int i=0; i<gifts.length; ++i) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int giver = map.get(st.nextToken());
            int taker = map.get(st.nextToken());
            
            table[giver][taker] += 1;
        }
        
//         // 출력
//         for(int i=0; i<friends.length; ++i) {
//             for(int j=0; j<friends.length; ++j) {
//                 System.out.print(table[i][j] + " ");
//             }
            
//             System.out.println();
//         }
        
        // 1을 이중 포문으로 돌기
        for(int i=0; i<friends.length; ++i) {
            for(int j=0; j<friends.length; ++j) {
                // if(i==j) continue;
                if(i >= j) continue; // 중복
                
                int i_give = table[i][j], j_give = table[j][i];
                if(i_give > j_give) {
                    count[i] += 1;
                } else if(i_give < j_give) {
                    count[j] += 1;
                } else { // 같음. 선물 지수 구하기
                    int i_score = 0;
                    int give = 0, take = 0;
                    for(int k=0; k<friends.length; ++k) {
                        give += table[i][k];
                        take += table[k][i];
                    }
                    i_score = give - take;
                    
                    int j_score = 0;
                    give = 0; take = 0;
                    for(int k=0; k<friends.length; ++k) {
                        give += table[j][k];
                        take += table[k][j];
                    }
                    j_score = give - take;
                    
                    if(i_score > j_score) {
                        count[i] += 1;
                    } else if(i_score < j_score) {
                        count[j] += 1;
                    }
                }
            }
        }
        
        // 가장 큰 값 구하기
        answer = count[0];
        for(int cnt : count) {
            if(answer < cnt) answer = cnt;
        }
        return answer;
    }
    
}