class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;
        String str = s;
        while(true){
            if(str.equals("1")){
                break;
            }
            
            String tmp = "";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0') zeroCnt++;
                else tmp+=str.charAt(i);
            }
            
            int a = tmp.length();
            tmp = convert(a);
            str = tmp;
            cnt++;
        }   
        
        return new int[]{cnt, zeroCnt};
    }
    
    private static String convert(int a){
        String result = "";
        while(a>=1){
            result+= a%2;
            a/=2;
        }
        return result;
    }
}