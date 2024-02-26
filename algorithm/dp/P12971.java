class P12971 {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        int len = sticker.length;
        int[] dp0 = new int[len + 1]; // 0번째 안뜯음
        int[] dp1 = new int[len + 1]; // 0번째 뜯음

        dp0[0] = 0;
        dp0[1] = sticker[1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i=2; i<len-1; ++i) {
            dp0[i] = Math.max(dp0[i-2] + sticker[i], dp0[i-1]);
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);

        }

        dp0[len-1] = Math.max(dp0[len-3] + sticker[len-1], dp0[len-2]);
        dp1[len-1] = dp1[len-2];

        answer = Math.max(dp0[len-1], dp1[len-1]);

        return answer;
    }
}