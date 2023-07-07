package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15565
 */
public class Q08_15565 {
    static FastReader sc = new FastReader();
    static int N, K;
    static int[] dolls;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        dolls = new int[N];
        for (int i = 0; i < N; i++) {
            dolls[i] = sc.nextInt();
        }
    }

    static void func(){
        int result = Integer.MAX_VALUE;
        int count = 0;
        int right = -1;

        for (int i = 0; i < N; i++) {
            while (valid(right + 1, count)){
                right++;

                if(dolls[right] == 1){
                    count++;
                }
            }

            if(count == K){
                result = Math.min(result, right - i + 1);
            }

            // 왼쪽 포인터 이동 시 1번 인형이면 카운트를 감소 시킨다.
            if(dolls[i] == 1){
                count--;
            }
        }

        if(result == Integer.MAX_VALUE){
            result = -1;
        }

        System.out.println(result);
    }

    static boolean valid(int nextRightIndex, int count){
        if(nextRightIndex >= N){
            return false;
        }

        // 이미 필요한 인형의 개수가 K개인 경우
        if(count == K){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        func();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            try{
                while (st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
