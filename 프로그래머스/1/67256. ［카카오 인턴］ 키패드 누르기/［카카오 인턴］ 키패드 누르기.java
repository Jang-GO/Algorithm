class Solution {
    static int[][] keypad = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {11, 0, 22}
    };
    static int[] leftIdx = new int[]{3, 0};
    static int[] rightIdx = new int[]{3, 2};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for (int tar : numbers) {
            if (tar == 1 || tar == 4 || tar == 7) {
                sb.append("L");
                updatePosition(tar, leftIdx);
            } else if (tar == 3 || tar == 6 || tar == 9) {
                sb.append("R");
                updatePosition(tar, rightIdx);
            } else {
                int leftDistance = findDistance(tar, leftIdx);
                int rightDistance = findDistance(tar, rightIdx);
                
                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        updatePosition(tar, rightIdx);
                    } else {
                        sb.append("L");
                        updatePosition(tar, leftIdx);
                    }
                } else {
                    if (leftDistance < rightDistance) {
                        sb.append("L");
                        updatePosition(tar, leftIdx);
                    } else {
                        sb.append("R");
                        updatePosition(tar, rightIdx);
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    private void updatePosition(int tar, int[] idx) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == tar) {
                    idx[0] = i;
                    idx[1] = j;
                    return;
                }
            }
        }
    }
    
    private int findDistance(int tar, int[] idx) {
        int targetX = 0, targetY = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == tar) {
                    targetX = i;
                    targetY = j;
                    break;
                }
            }
        }
        return Math.abs(targetX - idx[0]) + Math.abs(targetY - idx[1]);
    }
}