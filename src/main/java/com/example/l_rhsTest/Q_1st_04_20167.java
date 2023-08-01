package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20167
 */
public class Q_1st_04_20167 {
    static FastReader sc = new FastReader();
    static int N,K, result;
    static int[] value;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        value = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }
    }
    static void func(int start, int count){
        // 마지막인 경우
        if(start > N){
            result = Math.max(result, count);
            return;
        }

        // 먹는 것을 선택하지 않은 경우
        func(start + 1, count);

        // 먹는 것을 선택한 경우
        int tmp = 0;
        while (tmp < K && start <= N){
            tmp += value[start++];
        }

        int plus = 0;
        if(tmp > K){
            plus = tmp - K;
        }
        func(start, count + plus);
    }

    public static void main(String[] args) {
        input();
        func(1, 0);
        System.out.println(result);
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
