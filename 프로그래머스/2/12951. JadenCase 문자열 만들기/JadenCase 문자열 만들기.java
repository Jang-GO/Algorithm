class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean change = true;
        s = s.toLowerCase();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                change = true;
                sb.append(c);
            } else if (change) {
                sb.append(Character.toUpperCase(c));
                change = false;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}