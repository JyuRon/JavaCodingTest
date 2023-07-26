package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2011
 */
public class Q14_2011 {
    static FastReader sc = new FastReader();
    static String enc;
    static int N, mod = 1000000;
    static int[] Dy;
    static void input(){
        enc = sc.next();
        N = enc.length();
        Dy = new int[N];
    }
    static void func(){
        if(enc.charAt(0) != '0'){
            Dy[0] = 1;
        }


        for (int i = 1; i < N; i++) {

            // 하나를 추가하였을 때 문자열을 추가 할 수 있는 경우
            if(enc.charAt(i) != '0'){
                Dy[i] = Dy[i-1];
            }

            // 왼쪽 문자열과 합칠 경우 새로운 문자열이 생기는 경우
            if(check(enc.charAt(i-1), enc.charAt(i))){
                if(i >= 2){
                    Dy[i] += Dy[i-2];
                }else{
                    Dy[i] += 1;
                }
                Dy[i] %= mod;
            }
        }
        System.out.println(Dy[N-1]);

    }

    // 두가지 문자를 조합하여 10 이상 26 이하의 숫자가 만들어 지는지 판단
    static boolean check(char a, char b){
        if(a == '0') return false;
        if(a == '1') return true;
        if(a >= '3') return false;
        return b <= '6';
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
