public class Solution {
    public int[] multiply(int[] A){
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for(int i = 1;i < A.length;i++){
            B[i] = B[i-1] * A[i-1];  //上三角
        }
        int temp= 1;
        for(int j = length-2;j >= 0;j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
