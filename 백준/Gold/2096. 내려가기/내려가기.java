import java.io.*;
import java.util.*;

class Main {
//  private static List<List<Integer>> adj;
//  static int[] dy = {1, -1, 0, 0, 0, 0};
//  static int[] dx = {0, 0, 1, -1, 0, 0};
//  static int[] dz = {0, 0, 0, 0, 1, -1};
//  static int N, M, K;
//  static boolean[] vis;
//  static int[] ans;
//  static int turn = 1;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[3][3];
    int[][] arrMin = new int[3][3];

    arrMin[2][0] = arrMin[2][1] = arrMin[2][2] = Integer.MAX_VALUE;
    // 첫번째 줄
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<3; ++i) {
      arr[0][i] = Integer.parseInt(st.nextToken());
      arrMin[0][i] = arr[0][i];
    }



    // 2번째줄부터
    for(int i=1; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      // 다음줄 입력 받기
      for(int j=0; j<3; ++j) {
        arr[1][j] = Integer.parseInt(st.nextToken());
        arrMin[1][j] = arr[1][j];
      }

      arr[2][0] = Math.max(arr[0][0] + arr[1][0], Math.max(arr[0][1] + arr[1][0], arr[2][0]));
      arr[2][1] = Math.max(arr[0][0] + arr[1][1], Math.max(arr[0][1] + arr[1][1], Math.max(arr[0][2] + arr[1][1], arr[2][1])));
      arr[2][2] = Math.max(arr[0][1] + arr[1][2], Math.max(arr[0][2] + arr[1][2], arr[2][2]));

      arrMin[2][0] = Math.min(arrMin[0][0] + arrMin[1][0], Math.min(arrMin[0][1] + arrMin[1][0], arrMin[2][0]));
      arrMin[2][1] = Math.min(arrMin[0][0] + arrMin[1][1], Math.min(arrMin[0][1] + arrMin[1][1], Math.min(arrMin[0][2] + arrMin[1][1], arrMin[2][1])));
      arrMin[2][2] = Math.min(arrMin[0][1] + arrMin[1][2], Math.min(arrMin[0][2] + arrMin[1][2], arrMin[2][2]));


      // 옮기기
      for(int j=0; j<3; ++j) {
        arr[0][j] = arr[2][j];
        arrMin[0][j] = arrMin[2][j];
      }

      if(i != N-1) {
        arrMin[2][0] = Integer.MAX_VALUE; arrMin[2][1] = Integer.MAX_VALUE; arrMin[2][2] = Integer.MAX_VALUE;
      }
    }

    if(N == 1) {
      System.out.print(Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])) + " ");
      System.out.println(Math.min(arrMin[0][0], Math.min(arrMin[0][1], arrMin[0][2])));
    } else {
      System.out.print(Math.max(arr[2][0], Math.max(arr[2][1], arr[2][2])) + " ");
      System.out.println(Math.min(arrMin[2][0], Math.min(arrMin[2][1], arrMin[2][2])));
    }
  }
}