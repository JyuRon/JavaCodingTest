package com.boj_150.b_Sort.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q01_1744 {
    static FastReader sc = new FastReader();
    static int N, result;
    static List<Integer> plus, minus;
    static void input(){
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();

            if(target > 1){
                plus.add(target);
            }else if(target == 1){
                result++;
            }else{
                minus.add(target);
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);
    }


    public static void main(String[] args) {
        input();

        if(plus.size() > 1){
            for (int i = 0; i < plus.size() - 1; i+=2) {
                result += plus.get(i) * plus.get(i+1);
            }
        }

        if(plus.size() % 2 == 1){
            result += plus.get(plus.size() - 1);
        }


        if(minus.size() > 1){
            for (int i = 0; i < minus.size() - 1; i+=2) {
                result += minus.get(i) * minus.get(i+1);
            }
        }

        if(minus.size() % 2 == 1){
            result += minus.get(minus.size() - 1);
        }

        System.out.println(result);

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
