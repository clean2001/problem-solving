## 2805. 농작물 수확하기
![IMG_CFD772C440FD-1](https://github.com/clean2001/problem-solving/assets/64718002/3f0c436b-227b-4753-811d-bf880fe38517)


---

## 2806. N-Queen

![IMG_C36B86814C39-1](https://github.com/clean2001/problem-solving/assets/64718002/fd252bab-f3da-48a4-8e8e-462a65d291f2)

---
## 5215. 햄버거 다이어트

dfs(백트래킹)으로 모든 가능한 경우의 수 따지기
재료의 수가 20개이므로 최대 2^20 ~= 10^6 정도의 경우의 수

처음에 틀렸던 부분
아래처럼 짜게 되면, `N-1`번째 재료는 무조건 선택하는 경우만 따지게 됩니다. (`N-1`번째를 버리는 경우를 셀수가 없음)
따라서 `ans` 값을 갱신하는 부분을 `depth == N`일 때 뿐만 아니라, `dfs`메소드에 들어오면 항상 체크해주는 방식으로 바꾸었습니다.
```java
    private static void dfs(int depth, int calSum, int tasteSum) {
        if(depth == N) {
            if(calSum <= L)  {
                ans = Math.max(tasteSum, ans);
            }
            return;
        }
         
        for(int i=depth; i<N; ++i) {
            vis[i] = true;
            dfs(i+1, calSum + arr[i][1], tasteSum + arr[i][0]);
            vis[i] = false;
        }
    }
```
