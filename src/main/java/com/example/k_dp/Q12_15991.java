package com.example.k_dp;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15991
 */
public class Q12_15991 {
    static FastReader sc = new FastReader();
    static int testCase, MOD = 1000000009;
    static long[] result;

    static void input() {
        testCase = sc.nextInt();
        result = new long[100005];

        // 대칭인 경우의 수 양쪽에 1[]1, 2[]2, 3[]3 을 불이는 방법
        result[1] = 1;
        result[2] = 2;
        result[3] = 2;
        result[4] = 3;
        result[5] = 3;
        result[6] = 6;

        for (int i = 7; i <= 100000 ; i++) {
            result[i] = (result[i-2] + result[i-4] + result[i-6]) % MOD;
        }
    }

    static void func(int value) {
        System.out.println(result[value]);
    }

    public static void main(String[] args) {
        input();

        for (int i = 0; i < testCase; i++) {
            func(sc.nextInt());
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}