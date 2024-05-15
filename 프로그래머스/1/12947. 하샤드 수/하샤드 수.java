class Solution {
    public boolean solution(int x) {
        int aa = x;
        int zz = 0;
        while(aa>0){
            zz += (aa%10);
            aa/=10;
        }
        return (x%zz==0)? true : false;
    }
}