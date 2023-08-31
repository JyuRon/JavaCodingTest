package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q03_21939 {
    static FastReader sc = new FastReader();
    static int N, M;
    static TreeSet<Integer>[] qSet; // index = level => 레벨별로 treeSet 구성
    static int[] qToLevel;  // index 번호 = 문제번호 ==> 문제 번호에 맞는 level를 출력하기 위함
    static TreeSet<Integer> levelSet = new TreeSet<>(); // 문제의 level 집합 중 최소와 최대를 구하기 위함
    static void input(){
        N = sc.nextInt();

        qSet = new TreeSet[100001];
        qToLevel = new int[100001];
        for (int i = 1; i < 100001 ; i++) {
            qSet[i] = new TreeSet<>();
        }

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int level = sc.nextInt();

            qSet[level].add(num);
            qToLevel[num] = level;
            levelSet.add(level);
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            func(sc.next());
        }
    }

    static void func(String command){

        int left = sc.nextInt();
        int right;

        if(command.equals("add")){
            right = sc.nextInt();
            qSet[right].add(left);
            qToLevel[left] = right;
            levelSet.add(right);
        }else if(command.equals("recommend")){
            if(left == 1){
                System.out.println(qSet[levelSet.last()].last());
            }else{
                System.out.println(qSet[levelSet.first()].first());
            }
        }else if (command.equals("solved")) {
            int level = qToLevel[left];
            qSet[level].remove(left);

            if(qSet[level].isEmpty()){
                levelSet.remove(level);
            }
        }

    }

    public static void main(String[] args) {
         input();
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
