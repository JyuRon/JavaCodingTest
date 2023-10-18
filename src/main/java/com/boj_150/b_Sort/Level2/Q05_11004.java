package com.boj_150.b_Sort.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q05_11004 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(sc.nextInt());
        }

        Collections.sort(a);
        System.out.println(a.get(K-1));
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
