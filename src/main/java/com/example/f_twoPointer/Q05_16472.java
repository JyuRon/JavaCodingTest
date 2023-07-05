package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16472
 */
public class Q05_16472 {

    static FastReader sc = new FastReader();
    static int N;
    static String words;
    static int[] check;

    static void input(){
        N = sc.nextInt();
        words = sc.next();
        check = new int[26];
    }

    static boolean valid(int nextRight, int count){

        // 다음 인덱스가 문장 길이를 넘어간 경우
        if(nextRight >= words.length()){
            return false;
        }

        // 새로운 단어인 경우 추가했을 때 문자 종류가 N을 넘어가는 경우
        int checkIndex = (int)words.charAt(nextRight) - (int)'a';
        if(check[checkIndex] == 0 &&  count +1 > N){
            return false;
        }

        return true;
    }

    static void func(){

        int right = -1;
        int result = 0;
        int count = 0;

        for (int i = 0; i < words.length(); i++) {

            while (valid(right + 1, count)){

                right++;
                char tmp = words.charAt(right);

                // 새롭게 추가되는 단어 종류인 경우
                if(check[(int)tmp - (int)'a'] == 0){
                    count++;
                }

                check[(int)tmp - (int)'a']++;
            }

            result = Math.max(right - i + 1, result);


            // left 포인터를 움직이면서 변경되는 카운팅 적용
            check[(int)words.charAt(i) - (int)'a']--;
            if(check[(int)words.charAt(i) - (int)'a'] == 0){
                count--;
            }


        }
        System.out.println(result);

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
