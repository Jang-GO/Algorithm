import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            root.makeTree(input);
        }
        DFS(root, 0);
    }

    private static void DFS(Node root, int L) {
        if(root.child.isEmpty()) return;
        for (String ss : root.child.keySet()) {
            System.out.println(" ".repeat(L) + ss);
            DFS(root.child.get(ss), L + 1);
        }
    }

    static class Node {
        Map<String, Node> child = new TreeMap<>();

        public void makeTree(String input) {
            Node cur = this;
            for (String token : input.split("\\\\")) {
                // 자식이 없다면
                if (!cur.child.containsKey(token)) cur.child.put(token, new Node());
                cur = cur.child.get(token);
            }
        }
    }
}
