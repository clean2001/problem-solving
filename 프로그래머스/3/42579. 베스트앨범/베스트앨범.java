import java.util.*;

class Solution {
    public static class Genre {
        public String gen;
        public int cnt;
        
        public Genre(String gen, int cnt) {
            this.gen = gen;
            this.cnt = cnt;
        }
        
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> cntMap = new HashMap<>(); // 장르, 총수
        Map<String, PriorityQueue<int[]>> genMap = new HashMap<>(); // 장르, 장르별 노래
        
        for(int i=0; i<genres.length; ++i) {
            int cnt = cntMap.getOrDefault(genres[i], 0);
            cntMap.put(genres[i], cnt+plays[i]);
            
            PriorityQueue<int[]> pq = genMap
                .getOrDefault(genres[i], new PriorityQueue<int[]>((a, b) -> {
                if(a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            }));
            pq.add(new int[] {i, plays[i]});
            genMap.put(genres[i], pq);
        }
        
        // 가장 많은 장르 찾기
        PriorityQueue<Genre> genPq = new PriorityQueue<Genre>((a, b) -> {
            return b.cnt - a.cnt;
        });
        
        for(Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            genPq.add(new Genre(entry.getKey(), entry.getValue()));
        }
        // System.out.println(genMap);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!genPq.isEmpty()) {
            Genre cur = genPq.poll();
            PriorityQueue<int[]> tempPq = genMap.get(cur.gen);
            
            
            
            if(tempPq.size() == 1) {
                ans.add(tempPq.poll()[0]); continue;
            }
            
            for(int i=0; i<2; ++i) {
                ans.add(tempPq.poll()[0]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); ++i) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}