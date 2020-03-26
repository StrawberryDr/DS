package 选择排序;

public class selectSort {
    public static void selsctSort(int[] array){
        //1.选择躺数
        for(int i = 0;i < array.length;++i){
            //找最大元素
            int maxPos = 0;  //标记最大元素的位置
            for(int j = 1;j < array.length-i;++j){
                if(array[j] > array[maxPos]){
                    maxPos = j;
                }
            }
            //把最大元素放在其应该在的位置
            if(array.length-1-i != maxPos){
                swap(array,maxPos,array.length-1-i);
            }
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
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        selsctSort(array);
        printArray(array);
    }
}
