package com.boj_150.b_Sort.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q01_1946 {
    static FastReader sc = new FastReader();
    static int T, N;

    public static void main(String[] args) {
        T = sc.nextInt();

        while (T-- > 0){
            N = sc.nextInt();
            List<Info> paperList = new ArrayList<>();



            for (int i = 0; i < N; i++) {
                int paper = sc.nextInt();
                int talk = sc.nextInt();
                paperList.add(new Info(paper, talk));
            }
            Collections.sort(paperList, Comparator.comparingInt(a -> a.a));

            int pivot = paperList.get(0).b;
            int result = 1;
            for (int i = 1; i < N; i++) {
                if(pivot > paperList.get(i).b){
                    pivot = paperList.get(i).b;
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    static class Info{
        int a;
        int b;
        public Info(int a, int b){
            this.a = a;
            this.b = b;
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
