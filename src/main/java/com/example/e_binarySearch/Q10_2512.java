package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class Q10_2512 {

    static int N, M;
    static int[] nodes;
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        nodes = new int[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = sc.nextInt();
        }

        M = sc.nextInt();
    }

    static int sumByLimit(int num){
        int sum = 0;

        for (int i = 0; i < N; i++) {
            // 상한선 보다 금액이 작은 경우
            if(num >= nodes[i]){
                sum += nodes[i];
            }else{
                sum += num;
            }
        }

        return sum;
    }

    static boolean valid(int num){
        return num <= M;
    }

    static int choiceMaxValue(int limit){
        int result = 1;
        for (int i = 0; i < N; i++) {
            if(nodes[i] <= limit){
                result = Math.max(nodes[i], result);
            }else{
                result = Math.max(limit, result);
            }
        }
        return result;
    }

    static int func(){
        int bottom = 1;
        int top = 100000;
        int limit = 1;

        while (bottom <= top){
            int mid = (bottom + top)/2 ;

            // 총 예산보다 금액이 적게 나온다면 임계치를 늘려준다.
            if(valid(sumByLimit(mid))){
                bottom = mid + 1;
                limit = mid;
            }else{
                top = mid - 1;
            }
        }

        // 1 ~ 100000 범위인 집합 중 임계치를 고려한 최대값을 구한다.
        return choiceMaxValue(limit);
    }

    public static void main(String[] args) {
        input();
        System.out.println(func());
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
