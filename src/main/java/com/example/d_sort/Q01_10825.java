package com.example.d_sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10825
 */
public class Q01_10825 {

    static class Student implements Comparable<Student>{

        int korean;
        int english;
        int math;
        String name;

        @Override
        public int compareTo(Student student){
            // 국어 점수 : 내림차순
            // 영어 점수 : 오름차순
            // 수학 점수 : 내림차순
            // 이름 : 오름차순

            int diffKorean = this.korean - student.korean;
            int diffEnglish = this.english- student.english;
            int diffMath = this.math- student.math;

            if(diffKorean != 0){
                return diffKorean * -1;
            }

            if(diffEnglish != 0){
                return diffEnglish;
            }

            if(diffMath != 0){
                return diffMath * -1;
            }


            return name.compareTo(student.name);
        }
    }

    static int N;
    static Scanner sc = new Scanner(System.in);
    static Student[] students;

    static void input(){
        N = sc.nextInt();
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Student();
            students[i].name = sc.next();
            students[i].korean = sc.nextInt();
            students[i].english = sc.nextInt();
            students[i].math = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(students);
        for (int i = 0; i < N; i++) {
            System.out.println(students[i].name);
        }
    }
}
