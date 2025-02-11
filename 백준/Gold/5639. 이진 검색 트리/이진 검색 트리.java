import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = new ArrayList<>();

        String ss;
        while((ss=br.readLine())!=null && !ss.isEmpty()){
            inputs.add(Integer.parseInt(ss));
        }

        divideLeftOrRight(inputs);
    }

    private static void divideLeftOrRight(List<Integer> inputs) {
        if(inputs.isEmpty()){
            return;
        }

        int root = inputs.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i=1;i<inputs.size();i++){
            if(inputs.get(i) > root) right.add(inputs.get(i));
            else left.add(inputs.get(i));
        }
        divideLeftOrRight(left);
        divideLeftOrRight(right);
        System.out.println(root+ " ");
    }
}
