class Solution
{
    public int solution(int n, int a, int b){
        int round = 1;
        int fir = Math.min(a,b);
        int sec = Math.max(a,b);
        
        while(true){
            if(oddAndEven(fir,sec) && diff1(fir,sec)) break;       
            
            if(fir%2==0) fir /=2;
            else fir = (fir+1)/2;
            
            if(sec%2==0) sec /=2;
            else sec = (sec+1)/2;
            
            round++;
        }
        
        return round;
    }
    
    public boolean diff1(int fir, int sec){
        return Math.abs(fir-sec)==1;
    }
    
    public boolean oddAndEven(int fir, int sec){
        return (fir%2!=0) && (sec%2==0);
    }
}