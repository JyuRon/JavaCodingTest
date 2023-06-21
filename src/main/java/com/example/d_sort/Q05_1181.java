package com.example.d_sort;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1181
 */
public class Q05_1181 {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static Set<String> words;

    static void input(){
        N = sc.nextInt();
        words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(sc.next());
        }
    }

    public static void main(String[] args) {
        input();

        List<String> wordsList = new ArrayList<>(words);
        wordsList.sort(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                }

                return word1.length() - word2.length();
            }
        });

        for(String word : wordsList){
            System.out.println(word);
        }

    }
}
