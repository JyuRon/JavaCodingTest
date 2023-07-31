package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20164
 */
public class Q_1st_01_20164 {
    static FastReader sc = new FastReader();
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static String target;
    static void input(){
        target = sc.next();
    }
    static void func(String value, int count){

        int parse = Integer.parseInt(value);

        if(parse <= 9){
            if(parse % 2 == 1){
                count++;
            }
            max = Math.max(count, max);
            min = Math.min(count, min);
        }else if(parse <= 99){
            if((parse / 10) % 2 == 1){
                count++;
            }

            if((parse % 10) % 2 == 1){
                count++;
            }
            func(String.valueOf((parse / 10) + (parse % 10)), count);
        }else{
            int check = 0;
            for (int i = 0; i < value.length(); i++) {
                if(Integer.parseInt(value.substring(i,i+1)) % 2 == 1){
                    check++;
                }
            }

            for (int i = 1; i < value.length() - 1; i++) {
                for (int j = i ; j < value.length() - 1  ; j++) {
                    String left = value.substring(0,i);
                    String mid = value.substring(i,j+1);
                    String right = value.substring(j+1);

                    int next = Integer.parseInt(left) + Integer.parseInt(mid) + Integer.parseInt(right);
                    func(String.valueOf(next), check + count);

                }
            }
        }

    }

    public static void main(String[] args) {
        input();
        func(target, 0);
        System.out.println(min + " " + max);
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
