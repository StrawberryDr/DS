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
    public BinTree(){
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(1);
        BTNode n3 = new BTNode(1);
        BTNode n4 = new BTNode(1);
        BTNode n5 = new BTNode(1);
        BTNode n6 = new BTNode(1);

        root = n1;
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n4.left = n5;
        n4.right = n6;

    }

    //前序遍历：根节点--->根的左子树--->根的右子树
    public void preOrder(BTNode root){
        if(null != root){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder((root.right));
        }
    }

    //中序遍历：根的左子树--->根节点--->根的右子树
    public void inOrder(BTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
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

    //后序遍历：根的左子树--->根的右子树--->根节点
    private void postOrder(BTNode root){
        if(null != root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
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
    public int getKLeaveNodeCount(int k){
        return getKLeaveNodeCount(root,k);
    }
    private int getKLeaveNodeCount(BTNode root,int k){
        if(null == root || k < 1){
            return 0;
        }
        if(1 == k){
            return 1;
        }
        return getKLeaveNodeCount(root.left,k-1)+ getKLeaveNodeCount(root.right,k-1);
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



    public static void main(String[] args) {
        BinTree bt = new BinTree();
//        bt.preOrder();
//        bt.inOrder();
//        bt.postOrder();
//        System.out.println(bt.getNodeCount());
//        System.out.println(bt.getLeafNodeCount());
//        System.out.println(bt.getKLeaveNodeCount(3));
    }
}
