package com.example.leet;

public class UniquePaths12 {

    public static void main(String[] args) {
        // test 1
        int m=4, n=4;
        System.out.println(uniquePaths1(m, n));
    }
    
    public static int uniquePaths1(int m, int n) {
        if(m<=0||n<=0) return 0;
        int[] result=new int[n];
        result[0]=1;
        
        for(int i=0;i<m;i++){
            for(int j=1; j<n;j++){
                if(i==0) result[j]=1;
                else result[j]=result[j]+result[j-1];//amazing!
            }
        }
        return result[n-1];
    }
    
    

}
