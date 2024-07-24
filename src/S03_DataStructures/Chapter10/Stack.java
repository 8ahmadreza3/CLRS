package S03_DataStructures.Chapter10;

import java.util.Arrays;

public class Stack {
    int[] stack ;
    int count =0 ;

    public Stack(int n){
        stack = new int[n];
    }

    void push(int item){
        if(count == stack.length){
            throw new StackOverflowError();
        }
        stack[count++] = item ;
    }

    int peek(){
        if (count == 0)
            throw new IllegalArgumentException();
        return stack[count-1];
    }

    boolean stackEmpty(){
        return count == 0 ;
    }

    int pop(){
        if (stackEmpty())
            throw new IllegalArgumentException();
        return stack[--count];
    }

    public String toString(){
        int[] result = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(result);
    }
}
