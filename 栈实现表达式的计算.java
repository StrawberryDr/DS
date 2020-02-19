public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        ArrayStack1 numStack = new ArrayStack1(10);
        ArrayStack1 operStack = new ArrayStack1(10);
        int index = 0;  //用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;  //运算符
        int res = 0;  //保存结果
        char ch = ' ';  //每次扫描得到的char保存到ch
        String keepNum = "";  //拼接多位数
        while (true){
            //依次得到每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，做相应处理
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    //当前操作符的优先级<=栈中的操作符
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //运算结果入数栈
                        numStack.push(res);
                        //当前操作符入栈
                        operStack.push(ch);
                    }else {
                        //当前操作符优先级 > 栈中的操作符，直接入栈
                        operStack.push(ch);
                    }
                }else {
                    //为空直接入栈
                    operStack.push(ch);
                }
            }else {
                //为数字直接入数栈
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }
            }
            //index+1，判断是否扫描到表达式最后
            index ++;
            if(index >= expression.length()){
                break;
            }
        }
        while (true){
            //符号栈为空且数栈中只有一个数字，计算结束
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式的结果是：%d",res2);
    }
}

//先创建一个栈
class  ArrayStack1{
    private int maxSize;  //栈的大小
    private int[] stack;  //模拟栈,数据放在该数组中
    private int top = -1;  //表示栈顶,初始值-1

    //构造器
    public ArrayStack1(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //查看栈顶值
    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈：需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，数字越大优先级越高
    public int priority(int oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}