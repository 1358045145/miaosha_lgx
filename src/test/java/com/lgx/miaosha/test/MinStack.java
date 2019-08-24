package com.lgx.miaosha.test;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class MinStack {
    //利用一个辅助栈类实现
    Stack<Integer> helpStack = new Stack<Integer>();
    Stack<Integer> dataStack = new Stack<Integer>();

    public void push(Integer n){
        dataStack.push(n);
        helpStack.push(helpStack.isEmpty()? n : Math.min(n,helpStack.peek()));
    }

    public Integer min(){
        return helpStack.peek();
    }

    public void pop(){
        dataStack.pop();
        helpStack.pop();
    }
}
