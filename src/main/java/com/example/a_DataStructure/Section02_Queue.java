package com.example.a_DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Section02_Queue {

    public static void main(String[] args){
        Queue<Integer> queue_int = new LinkedList<>();

        // Enqueue
        queue_int.add(1);
        queue_int.add(2);
        System.out.println(queue_int);

        // Dequeue
        System.out.println(queue_int.poll());
        System.out.println(queue_int);

        System.out.println(queue_int.remove());
        System.out.println(queue_int);

        // made by ArrayList
        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    /**
     * ArrayList 를 활용하여 enqueue, dequeue 기능 구현
     * dequeue 기능 호출 시, 큐에 데이터가 없을 경우, Null 을 리턴하도록함
     * 다양한 데이터 타입을 다룰 수 있도록, Java 제네릭 타입 문법 활용
     */
    static class MyQueue<T> {
        List<T> queue = new ArrayList<>();

        void enqueue(T data){
            queue.add(data);
        }

        T dequeue(){
            return queue.isEmpty() ? null : queue.remove(0);
        }

    }
}
