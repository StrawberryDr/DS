import java.util.Scanner;

//接口类型的题目，必须要给一个public类型的Main类
class BTNode{
    BTNode left;
    BTNode right;
    char val;
    public BTNode(char val){
        this.val = val;
    }
}

class BinTree{
    private BTNode root = null;
    int index = 0;
    BinTree(String s,char invalid){
        root = createBinTree(s,invalid);
    }
    private BTNode createBinTree(String s,char invalid){
        BTNode newRoot = null;
        if(index < s.length() && s.charAt(index) != invalid){
            newRoot = new BTNode(s.charAt(index));
            
            ++index;
            newRoot.left = createBinTree(s,invalid);
            ++index;
            newRoot.right = createBinTree(s,invalid);
        }
        return newRoot;
    }
    
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(BTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
            //System.out.print(root.val + " ");
        }
    }
}

public class Main{
    public static void main(String[] args){
        //必须通过标准输入来接收前序的结果
        Scanner scanner = new Scanner(System.in);
        //对于IO类型的OJ题目，必须要循环输入
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            BinTree bt = new BinTree(s,'#');
            bt.inOrder();
        }
    }
}