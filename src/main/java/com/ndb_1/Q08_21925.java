package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21925
 */
public class Q08_21925 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }
    static void func(){
        int result = 0;
        int end = 0;
        for (int i = 0; i < N - 1; i = end) {
            boolean useAble = false;

            for ( int j = end + 1; j < N; j+=2) {
                int left = i;
                int right = j;


                boolean check = true;

                // 팰린드롬 을 만족하는지 검사
                while (check && left < right){
                    if(A[left] != A[right]){
                        check = false;
                    }
                    left++; right--;
                }

                // 최대의 팬린드롬 수열을 만들기 위해서는 최소의 원소를 사용해야 한다.
                if(check){
                    useAble = true;
                    end = j + 1;
                    result++;
                    break;
                }
            }

            // i ~ N 구간까지 조건을 만족하지 못하는 경우
            if(!useAble){
                System.out.println(-1);
                return;
            }

        }

        System.out.println(result);
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
