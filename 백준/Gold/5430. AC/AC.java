import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();
            if (n > 0) {
                String[] nums = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String s : nums) dq.offer(Integer.parseInt(s));
            }

            boolean reverse = false;
            boolean error = false;

            for(char c : str.toCharArray()){
                if(c=='R') reverse = !reverse;
                else{
                    if(dq.isEmpty()){
                        error = true;
                        break;
                    }
                    if(reverse) dq.pollLast();
                    else dq.pollFirst();
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append(print(dq, reverse)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static String print(Deque<?> dq, boolean reverse){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!dq.isEmpty()) {
            if(reverse){
                while(!dq.isEmpty()){
                    sb.append(dq.pollLast()).append(",");
                }
            }else{
                while(!dq.isEmpty()){
                    sb.append(dq.pollFirst()).append(",");
                }
            }
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
}