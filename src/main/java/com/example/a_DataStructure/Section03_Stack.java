package com.example.a_DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Section03_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());

        System.out.println("===== make stack by arrayList ====");

        MyStack<Integer> ms = new MyStack<Integer>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
        ms.push(3);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }


    /**
     *
     - JAVA ArrayList 클래스를 활용해서 스택을 다루는 push, pop 기능 구현해보기
     - pop 기능 호출 시, 스택에 데이터가 없을 경우, null 을 리턴하도록 함
     - 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기
     */

    static class MyStack<T>{

        List<T> stack = new ArrayList<>();

        void push(T data){
            stack.add(data);
        }

        T pop(){
            return stack.isEmpty() ? null : stack.remove(0);
        }
    }
}
