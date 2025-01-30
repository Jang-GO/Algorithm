import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MyStack{
    private final Stack<Integer> st;
    MyStack(){
        st = new Stack<>();
    }

    public void push(int x){
        st.push(x);
    }

    public int pop(){
        if(st.isEmpty()) return -1;
        else return st.pop();
    }

    public int size(){
        return st.size();
    }

    public int empty(){
        boolean rt = st.isEmpty();
        return rt ? 1 : 0;
    }

    public int top(){
        if(st.isEmpty()) return -1;
        else return st.peek();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack stack = new MyStack();
        List<Integer> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] arr = br.readLine().split(" ");
            int size = arr.length;

            if(size == 2) stack.push(Integer.parseInt(arr[1]));
            else{
                switch (arr[0]){
                    case "pop": {
                        answer.add(stack.pop());
                        break;
                    }
                    case "size": {
                        answer.add(stack.size());
                        break;
                    }
                    case "empty": {
                        answer.add(stack.empty());
                        break;
                    }
                    case "top": {
                        answer.add(stack.top());
                        break;
                    }
                }
            }
        }
        for(int x:answer){
            System.out.println(x);
        }
    }
}