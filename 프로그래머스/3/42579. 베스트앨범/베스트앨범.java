import java.util.*;

class Solution {
    public static class Music {
        String genre;
        int total;
        List<int[]> arr;
        
        public Music(String genre, int total) {
            this.genre = genre;
            this.total = total;
            arr = new ArrayList<>();
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Music> map = new HashMap<>();
        for(int i=0; i<genres.length; ++i) {
            Music m = map.getOrDefault(genres[i], null);
            if(m == null) {
                m = new Music(genres[i], plays[i]);
                m.arr.add(new int[]{i, plays[i]});
                map.put(genres[i], m);
            } else {
                m.arr.add(new int[]{i, plays[i]});
                m.total += plays[i];
            }
        }
        
        PriorityQueue<Music> pq = new PriorityQueue<>((a, b) -> {
            return b.total - a.total;
        });
        
        for(Map.Entry<String, Music> e : map.entrySet()) {
            pq.add(e.getValue());
        }
        
        ArrayList<Integer> ansList = new ArrayList<>();
        while(!pq.isEmpty()) {
            Music cur = pq.poll();
            
            // 많은 순으로 정렬
            Collections.sort(cur.arr, (a, b) -> {
               return b[1] - a[1]; 
            });
            
            for(int i=0; i<cur.arr.size(); ++i) {
                ansList.add(cur.arr.get(i)[0]);
                if(i == 1) break;
            }
        }
        
        int[] answer = new int[ansList.size()];
        for(int i=0; i<ansList.size(); ++i) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
}