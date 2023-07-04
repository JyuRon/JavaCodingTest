package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2343
 */
public class Q11_2343 {

    static int N,M;
    static int[] lecture;
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        lecture = new int[N];
        for (int i = 0; i < N; i++) {
            lecture[i] = sc.nextInt();
        }
    }


    static void func(){
        int bottom = 1;
        int top = 1000000000;
        int result = top;

        while (bottom <= top){
            int mid = (bottom + top) / 2;
            int cnt = 1;
            int tmp = 0;

            for (int i = 0; i < N; i++) {
                // 강의 크기가 디스크 용량보다 큰 경우 해당 로직을 실행할 수 없기에 디스크 용량을 늘려줘야 한다.
                if(lecture[i] > mid){
                    cnt = M+1;
                    break;
                }else{
                    if(tmp + lecture[i] <= mid){
                        tmp += lecture[i];
                    }else{
                        // 누적 합이 디스크 용량을 초과하는 경우 디스크 카운트롤 증가 시키고 기존 tmp 를 초기화 한다.
                        tmp = lecture[i];
                        cnt++;
                    }
                }
            }

            // cnt 가 기준보다 크면 디스크 크기를 늘려야한다.
            // cnt 가 기준보다 작으면 디스크 크기를 줄여야 한다.
            if(cnt > M){
                bottom = mid + 1;
            }else{
                top = mid - 1;
                result = mid;
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
