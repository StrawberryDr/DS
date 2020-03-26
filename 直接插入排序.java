package 插入排序;

public class insertSort {
    public static void insert(int[] array){
        for(int i = 1;i < array.length;++i){
            //1.找待插入元素在前面已排好序部分的位置
            int key = array[i];
            int end = i - 1;
            //待插入元素为最小元素的情况
            while (end >= 0 && key < array[end]){
                array[end+1] = array[end];
                end--;
            }

            //2.插入元素
            array[end+1] = key;
        }
    }
    public static void printArray(int[] array){
        for(int x:array){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        insert(array);
        printArray(array);
    }
}
