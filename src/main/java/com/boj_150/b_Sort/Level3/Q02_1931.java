package com.boj_150.b_Sort.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02_1931 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<Info> group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            group.add(new Info(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(group);

        int end = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(end <= group.get(i).start){
                count++;
                end = group.get(i).end;
            }
        }

        System.out.println(count);
    }

    static class Info implements Comparable<Info>{
        int start;
        int end;
        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Info other){
            if(this.end == other.end){
                return this.start - this.end;
            }

            return this.end - other.end;
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
