import java.util.*;

class Solution {
    static class FileName implements Comparable<FileName> {
        String header;
        int number;
        int idx;
        
        FileName(String header, int number, int idx) {
            this.header = header;
            this.number = number;
            this.idx = idx;
        }
        
        public int compareTo(FileName f) {
            String s1 = this.header.toUpperCase();
            String s2 = f.header.toUpperCase();
            if(s1.equals(s2)) {
                return this.number - f.number;
            }
            
            return s1.compareTo(s2);
        }
    }
    
    public String[] solution(String[] files) {
        ArrayList<FileName> list = new ArrayList<>();
        // 입력 파싱하기
        int fileIdx = 0;
        for(String file : files) {
            // 문자열
            int idx = 0;
            String h = "";
            for(idx = 0; idx < file.length(); ++idx) {
                if(file.charAt(idx) >= '0' && file.charAt(idx) <= '9') break;
                h += Character.toString(file.charAt(idx));
            }
            
            String n = "";
            for(; idx<file.length(); ++idx) {
                if(file.charAt(idx) >= '0' && file.charAt(idx) <= '9') {
                    n += Character.toString(file.charAt(idx));
                } else break;
            }
            
            list.add(new FileName(h, Integer.parseInt(n), fileIdx++));
            
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        int aIdx = 0;
        for(FileName f : list) {
            answer[aIdx++] = files[f.idx];
        }
        
        return answer;
    }
}