package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21279
 */
public class Q_2nd_05_21279 {
    static FastReader sc = new FastReader();
    static int N, C;
    static List<Info>[] criteriaX, criteriaY;
    static void input(){
        N = sc.nextInt();
        C = sc.nextInt();
        criteriaX = new ArrayList[100001];
        criteriaY = new ArrayList[100001];

        for (int i = 0; i < 100001; i++) {
            criteriaX[i] = new ArrayList<>();
            criteriaY[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long v = sc.nextLong();

            criteriaX[(int)x].add(new Info(y,v));
            criteriaY[(int)y].add(new Info(x,v));
        }
    }
    static void func(){
        long result = 0;
        long tmpResult = 0;
        int count = 0;
        int currentY = 100000;


        // i : x 좌표 0 ~ 100001 까지 순차적으로 늘림
        for (int i = 0; i < 100001; i++) {

            // x 좌표가 i 인 모든 값을 순회, 기준점 y를 넘어가면 스킵
            for (int j = 0; j < criteriaX[i].size(); j++) {
                if(criteriaX[i].get(j).point > currentY){
                    continue;
                }
                tmpResult += criteriaX[i].get(j).value;
                count++;
            }

            // 최대개수를 초과하는 경우 기준점 y를 -1 낮춤
            while (count > C){
                for (int j = 0; j < criteriaY[currentY].size(); j++) {

                    // 현재 x 기준점을 넘어가는 것을 볼 필요가 없음
                    if(criteriaY[currentY].get(j).point > i){
                        continue;
                    }

                    tmpResult -= criteriaY[currentY].get(j).value;
                    count--;
                }
                currentY--;
            }

            result = Math.max(result, tmpResult);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
    }
    static class Info{
        long point;
        long value;
        public Info(long point, long value){
            this.point = point;
            this.value = value;
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
        public long nextLong(){
            return Long.parseLong(next());
        }
    }
}
