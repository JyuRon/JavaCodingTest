package com.KAKAO_BLIND_RECRUITMENT_2023;

import java.util.*;

/**
 * bfs + 구현
 */
public class Q05_표_병합 {

   static class Info{
        int x;
        int y;

        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static StringBuffer sb = new StringBuffer();
    static List<Info>[][] table = new ArrayList[51][51];
    static String[][] value = new String[51][51];
    static boolean visited[][];

    static String[] solution(String[] commands) {
        init();
        List<String> tmp = new ArrayList<>();

        for(String command : commands){
            String[] splitCommand = command.split(" ");

            if(splitCommand[0].equals("UPDATE")){
                if(splitCommand.length == 4){
                    update(
                            Integer.parseInt(splitCommand[1]),
                            Integer.parseInt(splitCommand[2]),
                            splitCommand[3]
                    );
                }else{
                    update(splitCommand[1], splitCommand[2]);
                }
            }else if(splitCommand[0].equals("MERGE")){
                merge(
                        Integer.parseInt(splitCommand[1]),
                        Integer.parseInt(splitCommand[2]),
                        Integer.parseInt(splitCommand[3]),
                        Integer.parseInt(splitCommand[4])
                );
            }else if(splitCommand[0].equals("UNMERGE")){
                unmerge(
                        Integer.parseInt(splitCommand[1]),
                        Integer.parseInt(splitCommand[2])
                );
            }else if(splitCommand[0].equals("PRINT")){
                String printWord = print(
                        Integer.parseInt(splitCommand[1]),
                        Integer.parseInt(splitCommand[2])
                );

                if(printWord.equals("")){
                    tmp.add("EMPTY");
                }else{
                    tmp.add(printWord);
                }

            }
        }

        String[] answer = new String[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }

    static void init(){
        for(int i = 1 ; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                table[i][j] = new ArrayList<>();
                value[i][j] = "";
            }
        }
    }

    static void bfs(int x, int y, int command){
        visited = new boolean[51][51];
        Queue<Info> Q = new LinkedList<>();
        Q.add(new Info(x,y));
        visited[x][y] = true;

        String word = value[x][y];

        while(!Q.isEmpty()){
            Info current = Q.poll();

            for(Info next : table[current.x][current.y]){
                if(!visited[next.x][next.y]){
                    Q.add(next);
                    visited[next.x][next.y] = true;
                }
            }

            if(command == 1){
                value[current.x][current.y] = word;
            }else if(command == 2){
                value[current.x][current.y] = "";
                table[current.x][current.y] = new ArrayList<>();
            }
        }

        value[x][y] = word;
    }

    static void update(int x, int y, String word){
        value[x][y] = word;
        bfs(x,y,1);
    }

    static void update(String before, String after){
        for(int i = 1; i <= 50 ; i++){
            for(int j = 1; j <= 50; j++){
                if(value[i][j].equals(before)){
                    value[i][j] = after;
                }
            }
        }
    }

    static void merge(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2){
            return;
        }

        if(value[x1][y1].equals("") && !value[x2][y2].equals("")){
            value[x1][y1] = value[x2][y2];
        }

        table[x1][y1].add(new Info(x2, y2));
        table[x2][y2].add(new Info(x1, y1));
        bfs(x1, y1, 1);
    }

    static void unmerge(int x, int y){
        bfs(x, y, 2);
    }

    static String print(int x, int y){
        return value[x][y];
    }

    public static void main(String[] args) {
        String[] commands = {
                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant",
                "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
                "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
        };

        String[] answer = solution(commands);
        sb.append("[ ");
        for(String current : answer){
            sb.append(current).append(" ");
        }
        sb.append("]");

        System.out.println(sb.toString());

    }
}
