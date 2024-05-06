class Solution {
    static class Student{
        int id;
        boolean isLosted;
        boolean isReserve;
        public Student(int id, boolean isLosted, boolean isReserve){
            this.id = id;
            this.isLosted = isLosted;
            this.isReserve = isReserve;
        }
    }
    
    public int solution(int n, int[] lost, int[] reserve) {
        Student[] arr = new Student[n];
        int cnt=0;
        
        for(int i=0;i<n;i++){
            arr[i] = new Student(i+1,false,false);
            for(int j=0;j<lost.length;j++){
                if(i+1==lost[j]) arr[i].isLosted = true;
            }
            for(int j=0;j<reserve.length;j++){
                if(i+1==reserve[j]) arr[i].isReserve = true;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i].isLosted && arr[i].isReserve){
                arr[i].isLosted = false;
                arr[i].isReserve = false;
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(i==0){
                if(arr[i].isLosted){
                    if(arr[i+1].isReserve && !arr[i+1].isLosted){
                        cnt++;
                        arr[i+1].isReserve = false;
                        arr[i].isLosted = false;
                    }
                }else cnt++;
            }
            else if(i==arr.length-1){
                if(arr[i].isLosted){
                    if(arr[i-1].isReserve && !arr[i-1].isLosted){
                        cnt++;
                        arr[i-1].isReserve = false;
                        arr[i].isLosted = false;
                    }
                }
                else cnt++;
            }else{
                if(arr[i].isLosted){
                    if(arr[i-1].isReserve && !arr[i-1].isLosted){
                        cnt++;
                        arr[i-1].isReserve = false;
                        arr[i].isLosted = false;
                    }
                    else if(arr[i+1].isReserve && !arr[i+1].isLosted){
                        cnt++;
                        arr[i+1].isReserve = false;
                        arr[i].isLosted = false;
                    }
                }
                else cnt++;
            }
        }
        // cnt=0;
        // for(int i=0;i<arr.length;i++){
        //     if(!arr[i].isLosted){
        //         cnt++;
        //     }
        // }
        return cnt;
    }
}