package com.boj_150.b_Sort.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Q01_10814 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<User> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();

            list.add(new User(age, name, i));
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i));
        }
    }

    static class User implements Comparable<User>{
        int age;
        String name;
        int index;

        public User(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(User other){
            if(this.age == other.age){
                return this.index - other.index;
            }

            return (this.age - other.age);
        }

        @Override
        public String toString(){
            return this.age + " " + this.name;
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
