package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21942
 */
public class Q06_21942 {
    static FastReader sc = new FastReader();
    static int N, amount;
    static String period;
    static Map<String, LocalDateTime> list;
    static Map<String,Long> result;

    static void input(){
        N = sc.nextInt();
        period = sc.next();
        amount = sc.nextInt();

        list = new HashMap<>();
        result = new HashMap<>();
    }


    static void func(){

        String[] splitPeriod = period.split("/");

        int dayPeriod = Integer.parseInt(splitPeriod[0]) * 24 * 60;
        int hourPeriod = Integer.parseInt(splitPeriod[1].split(":")[0]) * 60;
        int minutePeriod = Integer.parseInt(splitPeriod[1].split(":")[1]);
        int resultPeriod = dayPeriod + hourPeriod + minutePeriod;



        for (int i = 0; i < N; i++) {
            String[] date = sc.next().split("-");
            String[] time = sc.next().split(":");

            LocalDateTime current = LocalDateTime.of(
                    Integer.parseInt(date[0]),
                    Integer.parseInt(date[1]),
                    Integer.parseInt(date[2]),
                    Integer.parseInt(time[0]),
                    Integer.parseInt(time[1])
            );

            String object = sc.next();
            String id = sc.next();
            String key = object + ":" + id;

            // 반납인 경우
            if(list.containsKey(key)){
                LocalDateTime before = list.get(key);
                long diff = ChronoUnit.MINUTES.between(before, current) - resultPeriod;

                // 반납 기한을 넘긴 경우
                if(diff > 0){
                    if(result.containsKey(id)){
                        result.put(id, result.get(id) + diff);
                    }else{
                        result.put(id, diff);
                    }
                }

                list.remove(key);
            }else{
                list.put(key, current);
            }
        }

        if(result.isEmpty()){
            System.out.println(-1);
            return;
        }
        List<String> tmp = new ArrayList<>(result.keySet());
        Collections.sort(tmp);


        for(String key : tmp){
            long money = result.get(key) * amount;
            System.out.println(key + " " + money);
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
