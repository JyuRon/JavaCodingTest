package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * N Queen 문제 이해(DFS)
 * 대표적인 백트래킹 문제
 * NxN 크기의 체스판에 N개의 퀸을 서로 공격할 수 없도록 배치하는 문제
 * 퀸은 다음과 같이 이동할 수 있으므로, 배치된 퀸 간에 공격할 수 없는 위치로 배치해야 함
 */
public class Section16_BackTracking {

    public boolean isAvailable(List<Integer> list, int currentCol){
        int currentRow = list.size();
        for (int i = 0; i < list.size(); i++) {

            // 수직 체크(col 이 동일한 경우)
            if(list.get(i) == currentCol){
                return false;
            }

            // 대각선 체크(대상 col - 현재 col = 대상 row - 현재 row)
            if(Math.abs(currentCol - list.get(i)) == (currentRow - i)){
                return false;
            }
        }

        return true;
    }

    public void queenFunc(int num, int currentRow, List<Integer> list){
        if(currentRow == num){
            System.out.println(list);
            return;
        }

        for (int i = 0; i < num; i++) {
            if(isAvailable(list, i)){
                list.add(i);
                queenFunc(num, currentRow + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Section16_BackTracking backTracking = new Section16_BackTracking();
        List<Integer> list = new ArrayList<>();
        backTracking.queenFunc(4,0, list);
    }


}
