import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static ArrayList<J> arr = new ArrayList<>();
    static ArrayList<Integer> bags = new ArrayList<>();

    static class J implements Comparable<J>{
        int M, V;

        J(int M, int V) {
            this.M = M;
            this.V = V;
        }


        @Override
        public int compareTo(J o) {
            return this.M - o.M;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.add(new J(m, v));
        }

        for(int i=0; i<K; ++i) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        // M를 기준으로 오름차순 정렬
        arr.sort(null);


        // 가방 무게 기준으로 오름차순 정렬
        bags.sort(null);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;
        int prev = 0;
        // NlogN + KlongN
        for(int i=0; i<K; ++i) {
            int capacity = bags.get(i);
            for(int j=prev; j<N; ++j) {
                if(arr.get(j).M <= capacity) {
                    pq.add(arr.get(j).V);
                    ++prev;
                } else break;
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }


}