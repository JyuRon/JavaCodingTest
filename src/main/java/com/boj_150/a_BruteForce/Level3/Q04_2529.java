package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q04_2529 {
    static FastReader sc = new FastReader();
    static int N;
    static boolean min, max;
    static String[] group;
    static boolean[] used;
    static void input(){
        N = sc.nextInt();
        group = new String[N];

        used = new boolean[10];

        for (int i = 0; i < N; i++) {
            group[i] = sc.next();
        }
    }

    static void func(){
        findMax(0,"");
        findMin(0,"");
    }

    static void findMax(int depth, String value){
        if(depth == N + 1){
            max = true;
            System.out.println(value);
            return;
        }

        for (int i = 9; i >= 0 ; i--) {

            // 사용중인 경우
            if(used[i]){
                continue;
            }

            if(depth != 0){
                if(group[depth - 1].equals("<") && value.charAt(depth - 1) > (char)(48 + i)){
                    continue;
                }else if(group[depth - 1].equals(">") && value.charAt(depth - 1) < (char)(48 + i)){
                    continue;
                }
            }

            used[i] = true;
            findMax(depth + 1, value + i);
            used[i] = false;

            if(max) break;
        }
    }


    static void findMin(int depth, String value){
        if(depth == N + 1){
            min = true;
            System.out.println(value);
            return;
        }

        for (int i = 0; i <= 9 ; i++) {

            // 사용중인 경우
            if(used[i]){
                continue;
            }

            if(depth != 0){
                if(group[depth - 1].equals("<") && value.charAt(depth - 1) > (char)(48 + i)){
                    continue;
                }else if(group[depth - 1].equals(">") && value.charAt(depth - 1) < (char)(48 + i)){
                    continue;
                }
            }

            used[i] = true;
            findMin(depth + 1, value + i);
            used[i] = false;

            if(min) break;
        }
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
