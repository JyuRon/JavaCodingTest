package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Q06_10974 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N;
    static boolean[] used;

    public static void main(String[] args) {
        N = sc.nextInt();
        used = new boolean[N + 1];
        func(0, new ArrayList<>());
        System.out.println(sb.toString());
    }

    static void func(int depth, List<Integer> value){
        if(depth == N){
            for (int i = 0; i < N; i++) {
                sb.append(value.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N ; i++) {
            if(used[i]){
                continue;
            }

            used[i] = true;
            value.add(i);
            func(depth + 1, value);
            used[i] = false;
            value.remove(value.size() - 1);
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
