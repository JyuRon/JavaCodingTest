package com.example.e_binarySearch;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/7795
 */
public class Q01_7795 {

    static Scanner sc = new Scanner(System.in);
    static int testCount = sc.nextInt();
    static int aSize, bSize;
    static List<Integer> a, b;

    static void input(){
        aSize = sc.nextInt();
        bSize = sc.nextInt();

        a = new ArrayList<>();
        b = new ArrayList<>();

        for (int i = 0; i < aSize; i++) {
           a.add(sc.nextInt());
        }

        for (int i = 0; i < bSize; i++) {
            b.add(sc.nextInt());
        }
    }

    static void func(){
        Collections.sort(a);
        Collections.sort(b);


        int count = 0;

        for (int i = 0; i < aSize; i++) {
//            if(a.get(i) > b.get(bSize-1)){
//                count += bSize;
//            }else if(a.get(i) < b.get(0)){
//                count += 0;
//            }else{
//                count += search(a.get(i), b);
//            }
            count += search(a.get(i), b);
        }

        System.out.println(count);
    }


    static int search(int num, List<Integer> targetList){

        if(targetList.size() == 0){
            return 0;
        }


        int midIndex = targetList.size() / 2;

        // 중간값 보다 큰 경우, b 그룹의 왼쪽 도 살펴야 한다
        if(num > targetList.get(midIndex)){
            return search(num, targetList.subList(midIndex+1, targetList.size())) + midIndex + 1;
        // 중간값 보다 작은 경우, b 그룹의 왼쪽을 살펴야 한다
        }else {
            return search(num, targetList.subList(0, midIndex));
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < testCount; i++) {
            input();
            func();
        }
    }
}
