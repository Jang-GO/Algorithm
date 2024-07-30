import java.util.stream.*;
import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i=0, j=B.length-1;i<A.length;i++, j--){
            int aa = A[i] * B[j];
            sum+= aa;
        }
        return sum;
    }
}