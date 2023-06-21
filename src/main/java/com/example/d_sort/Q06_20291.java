package com.example.d_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/20291
 */
public class Q06_20291 {

    static int N;
    static String[] words;
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    static void input(){
        N = sc.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
    }

    public static void main(String[] args) {

        input();
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String word1, String word2){
                return word1.split("\\.")[1].compareTo(word2.split("\\.")[1]);
            }
        });

        int count = 1;
        for (int i = 1; i < N; i++) {
            if(words[i-1].split("\\.")[1].equals(words[i].split("\\.")[1])){
                count++;
            }else{
                sb.append(words[i-1].split("\\.")[1]).append(" ").append(count).append("\n");
                count = 1;
            }
        }
        sb.append(words[N-1].split("\\.")[1]).append(" ").append(count).append("\n");

        System.out.println(sb.toString());
    }

}
