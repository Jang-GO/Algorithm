import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        if (score.length == 0) return new int[0]; // Handling empty input

        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // Min-Heap for smallest of top k scores
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            if (pQ.size() < k) {
                pQ.offer(score[i]);
            } else if (pQ.peek() < score[i]) {
                pQ.poll();
                pQ.offer(score[i]);
            }
            answer.add(pQ.peek());
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}
