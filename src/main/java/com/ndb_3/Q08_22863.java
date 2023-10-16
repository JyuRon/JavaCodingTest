package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q08_22863 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N;
    static long K;
    static int[] fx, tmp, order, result;
    static boolean[] used;
    static void input(){
        N = sc.nextInt();
        K = sc.nextLong();

        used = new boolean[N+1];
        order = new int[N+1];
        result = new int[N+1];
        fx = new int[N+1];
        tmp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            tmp[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            fx[i] = sc.nextInt();
        }

    }

    static void func(){
        for (int i = 1; i <= N; i++) {

            if(used[i]){
                continue;
            }

            int groupCount = 0, nextIndex = i;

            while (true){
                order[groupCount++] = nextIndex;
                used[nextIndex] = true;
                nextIndex = fx[nextIndex];

                if(i == nextIndex){
                    break;
                }
            }

            for (int j = 0; j < groupCount; j++) {
                int cur = order[j];
                int next = order[(int)((j + K) % groupCount)];
                result[next] = tmp[cur];
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());
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

        public long nextLong(){
            return Long.parseLong(next());
        }
    }
}
