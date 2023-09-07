package com.ndb_2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q05_21941 {
    static FastReader sc = new FastReader();
    static String s;
    static int M;
    static Map<String, Integer> target = new HashMap<>();
    static int[] Dy;
    static void input(){
        s = sc.next();
        Dy = new int[s.length()+1];
        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
           String word = sc.next();
           int score = sc.nextInt();
           target.put(word, score);
        }
    }

    static void func(){

        // 초기값 세팅
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                String current = s.substring(i,j);
                if(target.containsKey(current)){
                    Dy[j] = Math.max(Dy[j], Dy[i] + target.get(current));
                }else{
                    Dy[j] = Math.max(Dy[j], Dy[i] + 1);

                }
            }
        }


        System.out.println(Math.max(Dy[s.length()], Dy[s.length() - 1]));

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
