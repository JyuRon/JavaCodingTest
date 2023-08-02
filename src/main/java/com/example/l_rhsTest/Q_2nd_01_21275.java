package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21275
 */
public class Q_2nd_01_21275 {
    static FastReader sc = new FastReader();
    static String A, B;
    static Map<String, Integer> toInt = new HashMap<>();
    static void input(){
        A = sc.next();
        B = sc.next();

        for (int i = 0; i < 10 ; i++) {
            toInt.put(String.valueOf(i), i);
        }

        for (int j = 0; j < 26 ; j++) {
            toInt.put(String.valueOf((char)(97 + j)), 10 + j);
        }
    }

    static void func(){
        int count = 0;
        long original = 0;
        int valueA = 0;
        int valueB = 0;

        for (int i = 2; i <= 36 ; i++) {
            long transA = transTen(i, A);

            // A를 변활할 수 없는 경우 시도할 가치가 없다
            if(transA != -1){
                for (int j = 2; j <= 36 ; j++) {

                    // 문제 조건 : A진수 != B진수
                    if( i != j){
                        long transB = transTen(j, B);
                        if(transA == transB){
                            original = transA;
                            valueA = i;
                            valueB = j;
                            count++;
                        }
                    }
                }
            }

        }

        if(count >= 2){
            System.out.println("Multiple");
        }else if (count == 0){
            System.out.println("Impossible");
        }else{
            System.out.println(original + " " + valueA + " " + valueB);
        }
    }

    // value : 변환하고자 하는 진수, word : 변환 대상
    static long transTen(int value, String word){
        // 진수별 10진수 결과값 구하기
        long trans = 0;
        long multiple = 1;

        for (int j = word.length() - 1; j >= 0 ; j--) {
            // 현재 진수의 수 범위가 아닌 경우 : X진수의 경우 0 ~ X-1 이 범위
            if (toInt.get(String.valueOf(word.charAt(j))) > value - 1) {
                trans = -1;
                break;
            }

            trans += multiple * toInt.get(String.valueOf(word.charAt(j)));

            // 합이 long 범위인 X 를 넘어가는 경우
            if (trans < 0) {
                trans = -1;
                break;
            }
            multiple *= value;
        }

        return trans;
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
