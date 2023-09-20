package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q08_21944 {
    static FastReader sc = new FastReader();
    static int N,M;
    static TreeSet<Info> allList;
    static TreeSet<Info>[] groupByList;
    static Map<Integer, Info> numByProb;
    static void input(){
        N = sc.nextInt();

        allList = new TreeSet<>();
        groupByList = new TreeSet[101];
        numByProb = new HashMap<>();

        for (int i = 1; i <= 100 ; i++) {
            groupByList[i] = new TreeSet<>();
        }

        for (int i = 0; i < N; i++) {
            int id = sc.nextInt();
            int level = sc.nextInt();
            int group = sc.nextInt();

            allList.add(new Info(level, id));
            groupByList[group].add(new Info(level, id));
            numByProb.put(id, new Info(level, group));
        }

        M = sc.nextInt();
    }

    static void func(){
        for (int i = 0; i < M; i++) {
            String command = sc.next();


            if(command.equals("add")){
                int num = sc.nextInt();
                int level = sc.nextInt();
                int group = sc.nextInt();

                groupByList[group].add(new Info(level, num));
                allList.add(new Info(level, num));
                numByProb.put(num, new Info(level, group));

            }else if(command.equals("recommend")){
                int group = sc.nextInt();
                int type = sc.nextInt();

                if(type == 1){
                    System.out.println(groupByList[group].last().b);
                }else{
                    System.out.println(groupByList[group].first().b);
                }

            }else if(command.equals("recommend2")){
                int type = sc.nextInt();

                if(type == 1){
                    System.out.println(allList.last().b);
                }else{
                    System.out.println(allList.first().b);
                }

            }else if(command.equals("recommend3")){
                int type = sc.nextInt();
                int level = sc.nextInt();

                if(type == 1){
                    // 해당 조건을 만족하는 가장 큰 값
                    Info target = allList.higher(new Info(level, -1));

                    if(target == null){
                        System.out.println(-1);
                    }else{
                        System.out.println(target.b);
                    }

                }else{
                    Info target = allList.lower(new Info(level, -1));
                    if(target == null){
                        System.out.println(-1);
                    }else{
                        System.out.println(target.b);
                    }

                }

            }else if(command.equals("solved")){
                int num = sc.nextInt();
                Info info = numByProb.get(num); // level, group

                groupByList[info.b].remove(new Info(info.a, num));
                allList.remove(new Info(info.a,num));
                numByProb.remove(num);
            }

        }
    }

    public static void main(String[] args) {
        input();
        func();
    }


    static class Info implements Comparable<Info>{
        public int a;
        public int b;
        public Info(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Info info){
            if(this.a == info.a){
                return this.b - info.b;
            }
             return this.a - info.a;
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
    }
}
