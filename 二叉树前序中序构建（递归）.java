import java.util.*;

class BTNode{
    BTNode left;  //指向该二叉树的左子树
    BTNode right;  //指向该二叉树的右子树
    int val;

    public BTNode(int val){
        this.val = val;
    }
}

public class BinTree {
    private BTNode root = null;  //引用二叉树的根节点

    //快速给出一棵二叉树作以验证
//    public BinTree(){
//        BTNode n1 = new BTNode(1);
//        BTNode n2 = new BTNode(2);
//        BTNode n3 = new BTNode(3);
//        BTNode n4 = new BTNode(4);
//        BTNode n5 = new BTNode(5);
//        BTNode n6 = new BTNode(6);
//
//        root = n1;
//        n1.left = n2;
//        n1.right = n4;
//        n2.left = n3;
//        n4.left = n5;
//        n4.right = n6;
//
//    }

    //前序遍历：根节点--->根的左子树--->根的右子树
    public void preOrder(BTNode root){
        if(null != root){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder((root.right));
        }
    }

    //前序非递归遍历（栈）
    public void preOrderNor(){
        if(null == root){
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty() ){
            BTNode cur = s.peek();
            System.out.print(cur.val + " ");
            s.pop();
            //如果cur存在右子树，将右子树入栈
            if(null != cur.right){
                s.push(cur.right);
            }
            //如果cur的左子树存在，将左子树入栈
            if(null != cur.left){
                s.push(cur.left);
            }
        }
        System.out.println();
    }

    //前序非递归遍历（顺着cur的左侧路径一直走，如果cur有右子树，则保存）
    public void preOrderLeft(){
        if(null == root){
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            BTNode cur = s.peek();
            s.pop();
            while (null != cur){
                //顺序遍历cur的左侧路径节点，并保存路径中的右子树
                System.out.print(cur.val + " ");
                if(null != cur.right){
                    s.push(cur.right);
                }
                cur = cur.left;
            }
        }
        System.out.println();
    }

    //中序遍历：根的左子树--->根节点--->根的右子树
    public void inOrder(BTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    //后序遍历：根的左子树--->根的右子树--->根节点
    private void postOrder(BTNode root){
        if(null != root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void preOrder(){
        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println("\n");
    }//方便外部调用
    public void inOrder(){
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println("\n");
    }
    public void postOrder(){
        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println("\n");
    }

    //获取二叉树中节点的个数
    public int getNodeCount(){
        int ret = getNodeCount(root);
        return ret;
    }
    private int getNodeCount(BTNode root){
        if(null == root){
            return 0;
        }
        return (1 + getNodeCount(root.left) + getNodeCount(root.right));
    }

    //寻找根节点
    private BTNode find(BTNode root,int val){
        if(null == root){
            return null;
        }
        if(root.val == val){
            return root;
        }
        BTNode retNode = null;
        if(null != (retNode = find(root.left,val)) || null != (retNode = find(root.right,val))){
            return retNode;
        }
        return null;
    }

    //获取二叉树的高度
    public int getHeight(BTNode root){
        if(null == root){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? (leftHeight+1) : (rightHeight+1);
    }

    //获取有多少个叶子节点
    public int getLeafNodeCount(){
        return getLeafNodeCount(root);
    }
    public int getLeafNodeCount(BTNode root){
        if(null == root){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return (getLeafNodeCount(root.left)+getLeafNodeCount(root.right));
    }

    //获取第K层中节点的个数
    public int getKLevelNodeCount(int k){
        return getKLevelNodeCount(root,k);
    }
    private int getKLevelNodeCount(BTNode root,int k){
        if(null == root || k < 1){
            return 0;
        }
        if(1 == k){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+ getKLevelNodeCount(root.right,k-1);
    }

    //判断两个树是否相等：结构相同，并且节点具有相同的值
    public boolean isSameTree(BTNode p, BTNode q) {
        //都为空
        if(null == p && null == q){
            return true;
        }
        //有一个为空
        if(null == p || null == q){
            return false;
        }
        //两树都不为空
        if(q.val != p.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一个树的子树
    public boolean isSubtree(BTNode s, BTNode t) {
        if(null == s && null == t){
            return true;
        }
        if(null == t){
            return true;  //空树可以认为是任意二叉树的子树
        }

        //都不为空
        if(isSameTree(s,t)){
            return true;   //是同一棵树
        }

        return (isSubtree(s.left,t) || isSubtree(s.right,t));
    }

    //判断一颗二叉树是否是平衡二叉树
    public boolean isBalanced(BTNode root) {
        if(null == root){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(rightHeight - leftHeight) > 1){
            //Math.abs(rightHeight - leftHeight)：求绝对值
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }//从上往下递归，时间复杂度高：深度的递归，要多次求解以各个节点为根节点时树的高度
     //从下向上递归，时间复杂度O(N)：笔记二叉树习题（老师讲过改良后的代码）录屏二叉树03（2:20:00）

    //层序遍历（队列）
    public void LevelOrder(){
        if(null == root){
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BTNode cur = queue.poll();  //拿出对头元素并返回
            System.out.print(cur.val);

            //如果cur有左子树，让左子树入队列
            if(null != cur.left){
                queue.offer(cur.left);
            }
            //如果cur有右子树，让右子树入队列
            if(null != cur.right){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

    //层序遍历（返回一个二维数组）
    public List<List<Integer>> levelOrder(BTNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(null == root){
            return ret;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            //队列中保存的就是一层的节点
            //一次性将该层的节点全部遍历完
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for(int i = 0;i < size;++i){
                BTNode cur = q.poll();
                level.add(cur.val);

                //如果有左子树，将左子树入队列
                if(null != cur.left){
                    q.offer(cur.left);
                }
                //如果有右子树，将右子树入队列
                if(null != cur.right){
                    q.offer(cur.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    //判断是否为完全二叉树
    public boolean isCompleteTree() {
        if (null == root) {
            return true;  //空树也是完全二叉树
        }
        //树非空
        //1.找第一个不饱和节点（层序遍历）
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeafOrLeft = false;  //记录是否为叶子节点或者左子树
        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();  //取队头元素
            if(isLeafOrLeft){
                //2.从第一个不饱和节点之后，所有的节点不能由子树，否则一定不是完全二叉树
                if(null != cur.left || null != cur.right){
                    return false;
                }
            }
            //cur的左右子树均存在
            if (null != cur.left && null != cur.right) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else if (null != cur.left) { //只有左子树
                queue.offer(cur.left);
                isLeafOrLeft = true;
            } else if (null != cur.right) { //只有右子树
                return false;
            }else { // cur是叶子节点
                //cur是叶子节点
                isLeafOrLeft = true;

            }
        }
        return true;
    }

    //从前序与中序遍历序列构造二叉树
    //preorder：前序遍历结果
    //inorder：中序遍历结果
    //[left,right)：标记树中节点在inorder中的范围
    int index = -1;
    private BTNode reBuildTree(int[] preorder,int[] inorder,int left,int right){
        if(index > preorder.length-1 || left >= right){
            return null;
        }
        //在前序遍历中找根节点
        BTNode root = new BTNode(preorder[++index]);

        //在中序遍历结果中找根的位置
        //确认根节点的左右子树的区间
        int inrootIdx = left;
        while (inrootIdx < right){
            if(inorder[inrootIdx] == preorder[index]){
                break;
            }
            inrootIdx++;
        }
        //index++;

        //递归创建根节点的左子树
        //[left,inrootIdx)
        root.left = reBuildTree(preorder,inorder,left,inrootIdx);

        //递归创建根节点的右子树
        root.right = reBuildTree(preorder,inorder,inrootIdx+1,right);
        return root;
    }
    public BTNode buildTree(int[] preorder, int[] inorder) {
        return reBuildTree(preorder,inorder,0,inorder.length);
    }

    //从前序与中序遍历序列构造二叉树(递归)--->看哥哥的博客！
    //1.在前序遍历找到根节点
    //2.在中序遍历找到根节点的位置；根节点左边为左子树，右边为右子树
    //3.将根节点的左右子树分别看作一个新的二叉树
    //递归上面的操作
    public BTNode twoBuildTree(int[] preorder,int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        if(preorder.length == 1){
            return new BTNode(rootVal);
        }
        int rootIndex = 0;  //用来在中序遍历中找到根节点
        for(int i = 0;i < inorder.length;i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        BTNode root = new BTNode(rootVal);
        root.left = twoBuildTree(Arrays.copyOfRange(preorder,1,rootIndex+1),Arrays.copyOfRange(inorder,0,rootIndex));
        root.right = twoBuildTree(Arrays.copyOfRange(preorder,rootIndex+1,preorder.length),Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        return root;
    }


    public static void main(String[] args) {
        BinTree bt = new BinTree();
//        if(bt.isCompleteTree()){
//            System.out.println("是完全二叉树");
//        }else {
//            System.out.println("不是完全二叉树");
//        }
//        bt.preOrderLeft();
//        bt.preOrderNor();
//        bt.LevelOrder();
//        bt.preOrder();
//        bt.inOrder();
//        bt.postOrder();
//        System.out.println(bt.getNodeCount());
//        System.out.println(bt.getLeafNodeCount());
//        System.out.println(bt.getKLevelNodeCount(3));
    }
}
