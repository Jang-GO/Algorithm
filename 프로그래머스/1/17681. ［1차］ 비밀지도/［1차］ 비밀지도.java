class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<arr1.length;i++){
            String binary = makeBinaryString(n,arr1[i]);
            String binary2 = makeBinaryString(n,arr2[i]);
            String tmp = "";
            for(int j=0;j<binary.length();j++){
                if(binary.charAt(j)=='0' && binary2.charAt(j)=='0') tmp +=" ";
                else tmp += "#";
            }
            answer[i] = tmp;
        }
        return answer;
    }
    public String makeBinaryString(int n, int value){
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(value));
        while(sb.toString().length()<n){
            sb.insert(0,"0");
        }
        return sb.toString();
    }
}