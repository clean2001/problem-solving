import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String NStr = br.readLine();
    int N = 0;
    int cnt = 0;
    if(NStr.length() > 1) {
      N = trans(NStr);
      cnt++;
    } else {
      N = Integer.parseInt(NStr);
    }

    while(N > 0 && N / 10 > 0) {
      N = transform(N);
      cnt++;
    }

    bw.write(cnt + "\n");
    if(N > 0 && N % 3 == 0) {
      bw.write("YES\n");
    } else {
      bw.write("NO\n");
    }

    bw.flush();
  }

  public static int transform(int n) {
    int ret = 0;
    while(n > 0 && n / 10 > 0) {
      ret += (n % 10);
      n /= 10;
    }

    ret += n;

    return ret;
  }

  public static int trans(String n) {
    int ret = 0;
    for(int i=0; i<n.length(); ++i) {
      ret += (n.charAt(i) - '0');
    }
    return ret;
  }
}