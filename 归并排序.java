package 归并排序;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mergeSort {
    //类似于二叉树后序遍历的规则 左右根
    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length,temp);
    }
    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right - left > 1){
            //拆分
            int mid = left + ((right - left) >> 1);
            //[left,mid)
            mergeSort(array,left,mid,temp);
            //[mid,right)
            mergeSort(array,mid,right,temp);

            //归并
            Sort.sort(array,left,mid,right,temp);

            //将temp中的数据拷贝到array中
            // Arrays.copyOf();   ---->底层调用的就是System.arraycopy()
            //                    ---->并且还需要开辟新的空间
            // System.arraycopy();   ---->效率高
            System.arraycopy(temp,left,array,left,right-left);
        }
    }

    //非递归
    public static void mergeData(int[] array,int left,int mid,int right,int[] temp) {
        int index = left;
        int begin1 = left,end1 = mid;
        int begin2 = mid,end2 = right;
        while (begin1 < end1 && begin2 < end2){
            if(array[begin1] < array[begin2]){
                temp[index++] = array[begin1++];
            }else {
                temp[index++] = array[begin2++];
            }
        }
        while (begin1 < end1){
            temp[index++] = array[begin1++];
        }
        while (begin2 < end2){
            temp[index++] = array[begin2++];
        }
    }
    public static void mergeSortNor(int[] array){
        int[] temp = new int[array.length];
        int gap = 1;

        while (gap < array.length){
            for(int i = 0;i < array.length;i += gap*2){
                int left = i;
                int mid = left + gap;
                int right = mid + gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(right > array.length){
                    right = array.length;
                }
                mergeData(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,array.length);
            gap <<= 1;  //gap*2
        }
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
        int[] array = {3,8,2,6,9,7,1,4,0,5};
//        mergeSort(array);
        mergeSortNor(array);
        printArray(array);
    }
}
