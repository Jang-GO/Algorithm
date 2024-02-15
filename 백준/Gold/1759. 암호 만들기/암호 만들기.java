import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] arr;
    static ArrayList<String> list = new ArrayList<>();

    public static void DFS(int start, String str) {
        if (str.length() == l) {
            if (isContainMo(str) && isContainsTwoJa(str)) {
                list.add(str);
            }
            return;
        }

        for (int i = start; i < c; i++) {
            DFS(i + 1, str + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];

        String tmp = br.readLine().replaceAll(" ", "");
        arr = tmp.toCharArray();
        Arrays.sort(arr);

        DFS(0, "");

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static boolean isContainMo(String str) {
        return str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u");
    }

    private static boolean isContainsTwoJa(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                count++;
            }
        }
        return count >= 2;
    }
}
