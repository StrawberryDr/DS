public class solution {
    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(int[] tree,int n,int i){
        if(i >= n){
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    public static void build_heap(int[] tree,int n){
        int last_node = n - 1;
        int parent = (last_node -1) / 2;
        for(int i = parent;i >= 0;i--){
            heapify(tree,n,i);
        }
    }

    public static void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        for(int i = n - 1;i >= 0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }

    public static void main(String[] args) {
        int[] tree = new int[]{2,5,3,1,10,4};
        int n = 6;
        heap_sort(tree,n);
        for (int x:tree) {
            System.out.print(x + " ");
        }
    }
}