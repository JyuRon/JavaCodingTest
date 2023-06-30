package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2110
 * 거리가 주어졌을 때 해당 거리만큼 노드를 설치 할 수 있는가?
 */
public class Q04_2110 {

    static FastReader sc = new FastReader();
    static int N,C;
    static int[] nodes;

    static void input(){
        N = sc.nextInt();
        C = sc.nextInt();
        nodes = new int[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = sc.nextInt();
        }

        Arrays.sort(nodes);
    }

    static boolean valid(int mid){
        int cnt = 1;
        int lastIndex = 0;
        for (int i = 1; i < N; i++) {
            if(nodes[i] - nodes[lastIndex] >= mid){
                cnt++;
                lastIndex = i;
            }
        }

        return cnt == C;
    }

    static void func(){
        int min = 0;
        int max = 1000000000;
        int result = 0;

        while (min <= max){
            int mid = (min + max) / 2;
            if(valid(mid)){
                min = mid + 1;
                result = mid;
            }else{
                max = mid - 1;
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
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e ){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
