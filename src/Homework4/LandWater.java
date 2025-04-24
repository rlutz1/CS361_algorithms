package Homework4;

import java.util.LinkedList;

public class LandWater {

    int[][] mtrx;

    public LandWater() { }

    public int howManyIslands(int[][] map) {

        int islandCount = 0;

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 1) {
                    islandCount++;
                    map = bfsUtil(map, r, c);
                }
            }
        }

        return islandCount;
    }

    public int[][] bfsUtil(int[][] map, int r, int c) {

        LinkedList<Pair> queue = new LinkedList<>();

        map[r][c] = 2;

        int m = map.length;
        int n = map[0].length;

        queue.offer(new Pair(r, c));

        while (!queue.isEmpty()) {
            Pair next = queue.poll();

            int up = next.row() - 1;
            int down = next.row() + 1;
            int left = next.col() - 1;
            int right = next.col() + 1;

            Pair upP = new Pair(up, next.col());
            Pair downP = new Pair(down, next.col());
            Pair leftP = new Pair(next.row(), left);
            Pair rightP = new Pair(next.row(), right);


            if (inBounds(upP, n, m) && map[up][next.col()] == 1) {
                map[up][next.col()] = 2;
                queue.offer(upP);
            }

            System.out.println(n + " " + m);
            System.out.println(inBounds(downP, n, m));
            if (inBounds(downP, n, m) && map[down][next.col()] == 1) {
                map[down][next.col()] = 2;
                queue.offer(downP);
            }
            System.out.println("d");
            if (inBounds(leftP, n, m) && map[next.row()][left] == 1) {
                map[next.row()][left] = 2;
                queue.offer(leftP);
            }

            System.out.println("l");
            rightP.print();
            if (inBounds(rightP, n, m) && map[next.row()][right]  == 1) {
                map[next.row()][right] = 2;
                queue.offer(rightP);
            }
            System.out.println("r");
        }

        print(map);

        return map;



    }

    public boolean inBounds(Pair p, int l, int w) {
//        System.out.println(w);
        return (
                   p.col() < l && p.col() >= 0
                && p.row() < w && p.row() >= 0
                );
    }

    public void print(int[][] map) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                System.out.print(map[r][c] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

}

class Pair {
    int r;
    int c;

    public Pair (int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int row() {
        return r;
    }

    public int col() {
        return c;
    }

    public void print() {
        System.out.println("(" + r + ", " + c + ")");
    }
}
