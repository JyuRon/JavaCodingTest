package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22857
 */
public class Q07_22862 {
    static FastReader sc = new FastReader();
    static int N,K;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

    }

    static void func(){
        int right = 0;
        int count = 0;
        int removeCount = 0;
        int result = 0;


        for (int i = 0; i < N; i++) {
            while (right < N){
                if(nums[right] % 2 == 0){
                    count++;
                    right++;
                }else if(removeCount + 1 <= K){
                    removeCount++;
                    right++;
                }else{
                    break;
                }

            }

            result = Math.max(result, count);

            // 좌측 포인터에 대한 처리
            if(nums[i] % 2 == 0){
                count--;
            }else{
                removeCount--;
            }

        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
