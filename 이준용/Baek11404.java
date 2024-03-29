package FloydWarchall;

import java.util.*;
import java.io.*;

public class Baek11404 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][]map;
	
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) map[i][j]=0;
				else map[i][j]=100000001;	// 연결된 경로의 거리로 표현할 수 없는 큰 수로 초기화.
											// w의 최대값 * N 보다 커야하고 오버플로우 발생 고려한 적당한 크기
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			map[s][e]=Math.min(map[s][e], w);
		}
		
		for(int k=0;k<N;k++) {				// 겅유 정점.
			for(int i=0;i<N;i++) {			// i에서 j로 
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==100000001) bw.write("0 ");	//연결되지 않은 노드. 초기화해준 값에서 변화 없음.
				else bw.write((map[i][j]+" "));
			}
			bw.write("\n");
		}
		bw.close();
	}
}
