package com.example.e_binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/7795
 */
public class Q01_7795_2 {

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
        Collections.sort(b);

        int count = 0;

        for (int i = 0; i < aSize; i++) {
            count += search(b, 0, bSize-1, a.get(i));

        }

        System.out.println(count);
    }


    static int search(List<Integer> A, int L, int R, int X){

        // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 L - 1 을 return 한다

        int res = L;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A.get(mid) < X) {
                res = mid + 1;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        for (int i = 0; i < testCount; i++) {
            input();
            func();
        }
    }
}
