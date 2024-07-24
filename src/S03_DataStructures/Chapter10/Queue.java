package S03_DataStructures.Chapter10;

import java.util.Arrays;
import java.util.Stack;

public class Queue {
    static class ArrayQueue{
        int[] queue ;
        int rear ;
        int count ;
        int front ;

        public ArrayQueue(int n){
            queue = new int[n];
        }

        public String toString(){
            return Arrays.toString(queue);
        }

        int dequeue(){
            int item = queue[front];
            queue[front] = 0 ;
            front = (front+1) % queue.length ;
            count-- ;
            return item ;
        }

        void enqueue(int item){
            if(count == queue.length)
                throw new IllegalArgumentException();
            queue[rear] = item;
            rear = (rear+1) % queue.length ;
            count++ ;
        }
    }

    static class QueueWithStack{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enqueue(int item){
            s1.push(item);
        }

        int dequeue(){
            if(s2.isEmpty()) {
                if(s1.isEmpty())
                    throw new IllegalArgumentException();
                while(!s1.isEmpty()){
                    s2.push(s1.pop()) ;
                }
            }
            return s2.pop();
        }

        boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty() ;
        }
    }

    static class PriorityQueue{
        int[] queue ;
        int count ;

        public PriorityQueue(int n){
            queue = new int[n] ;
        }

        boolean isEmpty(){
            return count == 0 ;
        }

        int remove(){
            if(isEmpty())
                throw new IllegalArgumentException() ;
           return queue[--count] ;
        }

        void add(int item){
            if(count == queue.length)
                throw new IllegalArgumentException() ;
            int i ;
            for(i=count-1 ; i>-1 ; --i){
                if(queue[i] > item)
                    queue[i+1] = queue[i];
                else break;
            }
            queue[i+1] = item ;
        }

        public String toString(){
            return Arrays.toString(queue);
        }
    }
}
