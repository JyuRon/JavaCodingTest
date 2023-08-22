package com.KAKAO_BLIND_RECRUITMENT_2023;
import java.util.*;

/**
 * 트리 + 그리드
 */
public class Q07_1_2_3_떨어트리기 {
    static List<Integer>[] graph;

    // next[node][0] : 해당 노드가 가야할 자식노드
    // next[node][1] : 해당 노드의 자식노드 개수
    static int[][] next;
    static int[] count;
    static List<Integer> tmp;
    static int currentLeafNode;
    static boolean[] visited;

    public int[] solution(int[][] edges, int[] target) {
        init(edges);

        int leafNodeCount = 0;

        for (int i = 0; i < target.length; i++) {
            if(graph[i+1].isEmpty() && target[i] > 0)
                leafNodeCount++;
        }

        // leafNodeCount == 0 : 각 리프 노드들이 최소 조건들을 맞춤
        while (leafNodeCount > 0){
            dfs(1);
            int node = currentLeafNode;
            count[node]++;

            // 모두 1로 채워도 조건을 만족 하지 못한다.
            if(count[node]  > target[node - 1]){
                System.out.println(node);
                int[] ans = {-1};
                return ans;
            }

            tmp.add(node);

            // 해당 리프 노드의 최소 개수를 만족 하는 경우
            if(!visited[node] && target[node - 1] <= count[node] * 3){
                visited[node] = true;
                leafNodeCount--;
            }
        }

        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            int node = tmp.get(i);
            count[node]--;
            for (int j = 1; j <= 3; j++) {
                // j 숫자를 확정 지었을 때 남은 가지 수로 target 를 채울 수 있는지 판단
                if(count[node] <= target[node - 1] - j && target[node -1] - j <= count[node] * 3){
                    target[node -1] -= j;
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }

    // 숫자를 받을 노드 번호를 리턴
    public void dfs(int value) {
        if (next[value][0] == -1) {
            currentLeafNode = value;
            return;
        }


        dfs(graph[value].get(next[value][0]));
        next[value][0] = (next[value][0] + 1) % next[value][1];
    }




    public void init(int[][] edges) {
        graph = new ArrayList[edges.length + 2];
        next = new int[edges.length + 2][2];
        tmp = new ArrayList<>();
        count = new int[edges.length + 2];
        visited = new boolean[edges.length + 2];

        for (int i = 1; i <= edges.length + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int i = 1; i <= edges.length + 1; i++) {
            Collections.sort(graph[i]);

            if (!graph[i].isEmpty()) {
                next[i][0] = 0;  // 자식노드 인덱스 번호
                next[i][1] = graph[i].size(); // 자식노드 크기
            } else {// 리프 노드인 경우
                next[i][0] = -1;
                next[i][1] = 0;
            }
        }
    }


    public static void main(String[] args) {
        Q07_1_2_3_떨어트리기 a = new Q07_1_2_3_떨어트리기();
        int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
        int[] target = 	{0, 0, 0, 3, 0, 0, 5, 1, 2, 3};


        for(int i : a.solution(edges, target)){
            System.out.println(i);
        }

    }

}