package com.boj_150.b_Sort.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q03_11651 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<Info> a = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            a.add(new Info(x,y));
        }

        Collections.sort(a);

        for (int i = 0; i < N; i++) {
            Info info = a.get(i);
            System.out.println(info.x + " " + info.y);
        }
    }

    static class Info implements Comparable<Info>{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Info other){
            if(this.y == other.y){
                return this.x - other.x;
            }

            return this.y - other.y;
        }
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
