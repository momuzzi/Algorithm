package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 1001;
    static boolean[][] edge;
    static boolean[] visited;
    static int vertexNum;
    static int edgeNum;
    static int startVertex;
    static LinkedList<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        vertexNum = Integer.parseInt(tokenizer.nextToken());
        edgeNum = Integer.parseInt(tokenizer.nextToken());
        startVertex = Integer.parseInt(tokenizer.nextToken());
        edge = new boolean[SIZE][SIZE];
        visited = new boolean[SIZE];

        for (int i = 0; i < edgeNum; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            edge[x][y] = edge[y][x] = true;
        }

        dfs(startVertex);
        System.out.println();
        bfs(startVertex);

    }

    static void dfs(int vertex) {
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (int i = 1; i <= vertexNum; i++) {
            if (!visited[i] && edge[i][vertex]) {
                dfs(i);
            }
        }
    }

    static void bfs(int vertex) {
        visited = new boolean[SIZE];
        q = new LinkedList<>();

        visited[vertex] = true;
        q.add(vertex);

        while (!q.isEmpty()) {
            int idx = q.poll();
            System.out.print(idx + " ");

            for (int i = 1; i <= vertexNum; i++) {
                if (!visited[i] && edge[i][idx]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
