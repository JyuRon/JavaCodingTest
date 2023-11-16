package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 플로이드 워셜 ( i 번째를 경유할때 최소값을 판별하는 알고리즘)
public class Q06_1719 {
    static final int MAXNUM = 201;
    static int n, m;
    static int[][] dist = new int[MAXNUM][MAXNUM];
    static int[][] from = new int[MAXNUM][MAXNUM];

    static void floydwarshall()
    {
        for (int k = 1; k <= n; k++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        from[i][j] = from[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < MAXNUM; i++)
        {
            for (int j = 0; j < MAXNUM; j++)
            {
                if (i == j)
                {
                    dist[i][j] = 0;
                }
                else
                {
                    dist[i][j] = 1000000000;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
            from[a][b] = b;
            from[b][a] = a;
        }

        floydwarshall();

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i == j)
                {
                    System.out.print("- ");
                }
                else
                {
                    System.out.print(from[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
