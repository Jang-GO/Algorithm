class Solution {
    public int solution(String s) {
        int cnt = 0;  // 문자열 분리 횟수 카운트
        char x = s.charAt(0); // 첫 번째 문자 저장
        int xCnt = 0;  // 첫 문자의 카운트
        int nxCnt = 0;  // 첫 문자가 아닌 나머지 문자의 카운트
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                xCnt++;  // 현재 문자가 첫 문자와 같으면 xCnt 증가
            } else {
                nxCnt++;  // 다르면 nxCnt 증가
            }
            
            // x와 x가 아닌 문자의 수가 같아지는 지점을 찾으면
            if (xCnt == nxCnt) {
                cnt++;  // 분리한 문자열 수 증가
                xCnt = 0;  // 카운트 초기화
                nxCnt = 0;  // 카운트 초기화
                if (i + 1 < s.length()) x = s.charAt(i + 1);  // 다음 문자열 첫 문자 갱신
            }
        }

        // 마지막으로 카운트된 부분에서 끝나지 않았다면 남은 부분도 문자열로 취급
        if (xCnt != 0 || nxCnt != 0) cnt++;

        return cnt;
    }
}
