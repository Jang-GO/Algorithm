import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[][] board = new int[9][9];
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        solution(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void solution(int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            isEnd = true;
            return;
        }

        if (board[row][col] != 0) {
            solution(row, col + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (canBatch(row, col, i)) {
                board[row][col] = i;
                solution(row, col + 1);
                if (isEnd) return;
                board[row][col] = 0;
            }
        }
    }

    private static boolean canBatch(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        //0,1,2 => 0
        //3,4,5 => 3

        int rowS = (row / 3) * 3;
        int colS = (col / 3) * 3;
        for (int i = rowS; i < rowS + 3; i++) {
            for (int j = colS; j < colS + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }
}
