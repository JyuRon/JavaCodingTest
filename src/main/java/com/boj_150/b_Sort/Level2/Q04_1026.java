package com.boj_150.b_Sort.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q04_1026 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            a.add(sc.nextInt());
        }
        Collections.sort(a);

        for (int i = 0; i < N; i++) {
            b.add(sc.nextInt());
        }
        Collections.sort(b);
        Collections.reverse(b);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (a.get(i) * b.get(i));
        }

        System.out.println(sum);
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
