package com.dr.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //先创建一个原始的二维数组 11*11
        //0：没有棋子  1：黑子  2：蓝子

        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        for(int[] row :chessArray1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //1.先遍历整个数组，确定有效数据个数
        int sum = 0;
        for(int i = 0;i < chessArray1.length;i++){
            for(int j = 0;j < chessArray1[i].length;j++){
                if(chessArray1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.printf("sum=%d",sum);
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //3.给稀疏数组赋值
        sparseArr[0][0] = chessArray1.length;
        sparseArr[0][1] = chessArray1[0].length;
        sparseArr[0][2] = sum;
        //4.把二维数组中的有效数据赋给稀疏数组
        int count = 0; //用于记录是第几个有效数据
        for(int i = 0;i < chessArray1.length;i++){
            for(int j = 0;j < chessArray1[i].length;j++){
                if(chessArray1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }
        }
        //5.输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组：");
        for(int i = 0;i < sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为原始的二维数组
        //1.先读取稀疏数组的第一行，根据第一行的数据创建原始二维数组；
        int[][] chessArray2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.在读取稀疏数组后几行的数据，并赋给原始的二维数组；第二行开始读取
        for (int i = 1;i < sparseArr.length;i++){
            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组：");
        for(int[] row :chessArray2){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
