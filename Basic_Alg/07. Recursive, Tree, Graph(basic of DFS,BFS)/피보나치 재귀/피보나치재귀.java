public class 피보나치재귀 {
    // 일반적인 재귀
    // public static int DFS(int n){
    //     if(n==1 || n==2) return 1;
    //     else return DFS(n-1) + DFS(n-2);
    // }
    // public static void main(String[] args) {
    //     int n=10;
    //     for(int i=1; i<=n;i++) System.out.print(DFS(i)+" ");
    // }
    static int[] fibo;

    public static int DFS(int n){
        if(fibo[n]!=0) return fibo[n];
        if(n==1 || n==2) return fibo[n]=1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }
    public static void main(String[] args) {
        int n=45;
        fibo = new int[n+1]; 
        DFS(n);
        for(int i=1;i<=n;i++) System.out.print(fibo[i] + " ");
    }
}
