package com.ssafy.study.beakjoon.파이프옮기기_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Main {
	static int N, Ans;
	static int[][] arr;
	static boolean[][] v;

	// 가로,세로,대각선
	// 0,1,2
	// 오,아,대
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		BFS();
		DFS(0,1,0);
		System.out.println(Ans);
	}
	
	
	private static void DFS(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			Ans++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			if(dir==0 && d==1) continue;
			if(dir==1 && d==0) continue;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean isEmpty = true;
			if(d==2) {
				for (int j = 0; j < 2; j++) {
					int nr2 = r + dr[j];
					int nc2 = c + dc[j];
					if (nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < N && arr[nr2][nc2] != 0)
						isEmpty = false;
				}
			}
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0 && isEmpty)
				DFS(nr, nc, d);
		}
	}


//	// 시간초과..
//	static Queue<Point> Q = new LinkedList<>();
//	private static void BFS() {
//		Q.add(new Point(0, 1, 0));
//
//		while (!Q.isEmpty()) {
//			Point p = Q.poll();
//
//			boolean isEmpty = true;
//			for (int j = 0; j < 2; j++) {
//				int nr = p.r + dr[j];
//				int nc = p.c + dc[j];
//				if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 0)
//					isEmpty = false;
//			}
//
//			if (isEmpty)
//				rotation(p, 2);
//			if (p.dir == 0) {
//				rotation(p, 0);
//			} else if (p.dir == 1) {
//				rotation(p, 1);
//			} else if (p.dir == 2) {
//				rotation(p, 0);
//				rotation(p, 1);
//			}
//		}
//
//		System.out.println(Ans);
//	}
//
//	private static void rotation(Point p, int i) {
//		int nr = p.r + dr[i];
//		int nc = p.c + dc[i];
//
//		if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
//			Q.add(new Point(nr, nc, i));
//
//			if (nr == N - 1 && nc == N - 1)
//				Ans++;
//		}
//	}

}
