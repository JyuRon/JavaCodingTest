package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3055
 */
public class Q07_3055 {
    static FastReader sc = new FastReader();
    static int R,C;
    static String[] graph;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int result = Integer.MAX_VALUE;
    static int[][] distance;
    static boolean[][] visited;
    static int[][] existWater;
    static int waterCount = 0;
    static boolean[][] waterVisited;

    static void input(){
        R = sc.nextInt();
        C = sc.nextInt();

        distance = new int[R][C];
        visited = new boolean[R][C];
        waterVisited = new boolean[R][C];

        graph = new String[R];

        existWater = new int[R*C][2];

        for (int i = 0; i < R; i++) {
            graph[i] = sc.next();
        }
    }

    static void func(){
        int animalX = -1, animalY = -1;
        int houseX = -1, houseY = -1;

        // 고슴도치, 집 , 물 위치 파악
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i].charAt(j) == 'S'){
                    animalX = i; animalY = j;
                }else if(graph[i].charAt(j) == 'D'){
                    houseX = i; houseY = j;
                }else if(graph[i].charAt(j) == '*'){
                    existWater[waterCount][0] = i;
                    existWater[waterCount][1] = j;
                    waterCount++;
                }
            }
        }

        for (int i = 0; i < waterCount; i++) {
            addWater(existWater[i][0], existWater[i][1], animalX, animalY);
        }

        moveAnimal(animalX, animalY);

        result = distance[houseX][houseY];

    }

    static void moveAnimal(int animalX, int animalY){
        Queue<Integer> Q = new LinkedList<>();
        visited[animalX][animalY] = true;
        distance[animalX][animalY] = 0;
        Q.add(animalX);
        Q.add(animalY);

        while (!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = x + dir[i][0];
                int nextY = x + dir[i][1];

                if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && !visited[nextX][nextY] && graph[nextX].charAt(nextY) == '.'){
                    distance[nextX][nextY] = distance[x][y] + 1;
                    visited[nextX][nextY] = true;
                    Q.add(nextX);
                    Q.add(nextY);
                }
            }
        }

    }

    static void addWater(int x, int y, int animalX, int animalY){
        if(animalX == x && animalY == y){
            return;
        }

        waterVisited[x][y] = true;


        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && !waterVisited[nextX][nextY] && graph[nextX].charAt(nextY) != 'X'){

                for (int j = 0; j < 4; j++) {

                    int nextAnimalX = x + dir[i][0];
                    int nextAnimalY = x + dir[i][1];

                    if(nextAnimalX >= 0 && nextAnimalY >= 0 && nextAnimalX < R && nextAnimalY < C && !visited[nextAnimalX][nextAnimalY] && graph[nextAnimalX].charAt(nextAnimalY) == '.'){
                        distance[nextAnimalX][nextAnimalY] = distance[animalX][animalY] + 1;
                        visited[nextAnimalX][nextAnimalY] = true;
                        addWater(nextX, nextY, nextAnimalX, animalY);
                        distance[nextAnimalX][nextAnimalY] = 0;
                        visited[nextAnimalX][nextAnimalY] = false;
                    }
                }
            }

        }

        if(animalX == ho)
    }

    public static void main(String[] args) {
        input();
        func();



        if(result == 0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(result);
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
