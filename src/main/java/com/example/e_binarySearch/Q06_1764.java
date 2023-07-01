package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1764
 */
public class Q06_1764 {

    static int N,M;
    static int result = 0;
    static String[] notListen, notSee;
    static StringBuffer sb = new StringBuffer();
    static FastReader sc = new FastReader();
    static void input(){
        N = sc.nextInt();
        notListen = new String[N];

        M = sc.nextInt();
        notSee = new String[M];

        for (int i = 0; i < N; i++) {
            notListen[i] = sc.next();
        }
        Arrays.sort(notListen);
        for (int i = 0; i < N; i++) {
            System.out.println(notListen[i]);
        }

        for (int i = 0; i < M; i++) {
            notSee[i] = sc.next();
        }
        Arrays.sort(notSee);
    }

    static void func(){
        for(String target : notListen){
            int bottom = 0, top = M-1;
            while (bottom <= top){
                int mid = (bottom + top) / 2;
                if(notSee[mid].equals(target)){
                    sb.append(target).append("\n");
                    result++;
                    break;
                }else if(notSee[mid].compareTo(target) > 0){
                    top = mid -1;
                }else{
                    bottom = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        func();
        System.out.println(result);
        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
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
