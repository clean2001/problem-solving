import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String original = br.readLine();
    String[] target = br.readLine().split("");
    String[] arr1 = original.split("");
    String[] arr2 = original.split("");

    // 첫번째 켜지 않기
    int cnt1 = 0;
    for(int i=1; i<arr1.length; ++i) {
      if(!arr1[i-1].equals(target[i-1])) { // 누르기
        for(int j=i-1; j<=i+1; ++j) {
          if(j >= arr1.length) break;

          if(arr1[j].equals("0")) {
            arr1[j] = "1";
          } else {
            arr1[j] = "0";
          }
        }

        cnt1++;
      }
    }

    int cnt2 = 1;
    // 첫번째 켜기
    if(arr2[0].equals("0")) {
      arr2[0] = "1";
    } else {
      arr2[0] = "0";
    }

    if(arr2[1].equals("0")) {
      arr2[1] = "1";
    } else {
      arr2[1] = "0";
    }
    for(int i=1; i<arr2.length; ++i) {
      if(!arr2[i-1].equals(target[i-1])) { // 누르기
        for(int j=i-1; j<=i+1; ++j) {
          if(j >= arr2.length) break;

          if(arr2[j].equals("0")) {
            arr2[j] = "1";
          } else {
            arr2[j] = "0";
          }
        }
        cnt2++;
      }

    }

    // 비교
    for(int i=0; i<arr1.length; ++i) {
      if(!arr1[i].equals(target[i])) {
        cnt1 = 100001; break;
      }
    }

    // 비교
    for(int i=0; i<arr2.length; ++i) {
      if(!arr2[i].equals(target[i])) {
        cnt2 = 100001; break;
      }
    }

    if(cnt1 == 100001 && cnt2 == 100001) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(cnt1, cnt2));
    }

  }
}