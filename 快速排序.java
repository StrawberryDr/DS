package 快速排序;

public class quickSort {
    public static void quickSort(int[] array,int left,int right){
        if(right - left > 1){
            //说明区间中至少有两个元素
            //按照基准值对[left，right]区间进行分割
            int div = partion(array,left,right);

            //递归排序基准值的左半侧
            quickSort(array,left,div);

            //递归排序基准值的右半侧
            quickSort(array,div+1,right);
        }
    }
    public static int partion(int[] array,int left,int right){
        int begin = left;
        int end = right - 1;
        int key = array[end];

        while (begin < end){
            //1.begin从前往后找，找比基准值大的元素
            while (begin < end && array[begin] <= key){
                begin++;
            }
            //2.right从后往前找，找比基准值小的元素
            while (begin < end && array[end] >= key){
                end--;
            }
            if(begin < end){
                swap(array,begin,end);
            }
        }
        swap(array,begin,right-1);
        return begin;
    }

    public static void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void printArray(int[] array){
        for(int x:array){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        quickSort(array,0,array.length);
        printArray(array);
    }
}
