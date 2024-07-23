class Solution {
    public String solution(String new_id) {
        String tmp = new_id;
        String tmp1 = step1(tmp);
        String tmp2 = step2(tmp1);
        String tmp3 = step3(tmp2);
        String tmp4 =step4(tmp3);
        String tmp5 =step5(tmp4);
        String tmp6 =step6(tmp5);
        String tmp7 =step7(tmp6);
        return tmp7;
    }
    public static String step1(String str){
        return str.toLowerCase();
    }
    public static String step2(String str){
        return str.replaceAll("[^a-z0-9\\-\\_\\.]","");
    }
    public static String step3(String str){
        return str.replaceAll("\\.{2,}", ".");
    }
    public static String step4(String str){
        String tmp = str;
        if(tmp.startsWith(".")){
            tmp = tmp.substring(1);
        }
        if(tmp.endsWith(".")){
            tmp = tmp.substring(0,tmp.length()-1);
        }
        return tmp;
    }
    public static String step5(String str){
        return str.length()==0 ? str+"a" : str;
    }
    public static String step6(String str){
        String tmp = str;
        if(tmp.length() >=16) tmp = tmp.substring(0,15);
        if(tmp.endsWith(".")) tmp = tmp.substring(0, tmp.length()-1);
        return tmp;
    }
    public static String step7(String str){
        StringBuilder sb = new StringBuilder(str);
        if(str.length()<=2){
            char ss = str.charAt(str.length()-1);
            while(sb.length()<3){
                sb.append(ss);
            }
            return sb.toString();
        }else{
            return str;
        }
    }
}