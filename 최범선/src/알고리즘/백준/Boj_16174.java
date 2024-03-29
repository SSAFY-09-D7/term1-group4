package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16174 {
    static int N;
    static boolean flag;
    static int[][] data;
    static boolean[][] v;

    public static void dfs(int x, int y){
        v[x][y] = true;
        int k = data[x][y];
        if (k == -1){
            flag = true;
            return;
        }
        if(k == 0) return;
        if (x + k < N && !v[x+k][y]) dfs(x + k, y);
        if (y + k < N && !v[x][y+k]) dfs(x, y + k);

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        flag = false;
        dfs(0,0);

        System.out.println(flag ? "HaruHaru" : "Hing");

    }
}