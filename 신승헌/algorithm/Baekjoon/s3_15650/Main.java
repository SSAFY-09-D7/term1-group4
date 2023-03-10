package algo.bj.s3_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 중복 x
 * 순서 상관 없음
 * 조합
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 자연수 최대 값
		int M = Integer.parseInt(st.nextToken()); // 수열 길이
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
			
		}
		
		recursive(arr, new int[M], 0, 0);
		
		
	}

	private static void recursive(int[] arr, int[] select, int aIdx, int sIdx) {
		// basis part
		if (sIdx == select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if (aIdx == arr.length) {
			return;
		}
		
		select[sIdx] = arr[aIdx];
		recursive(arr, select, aIdx + 1, sIdx + 1);
		
		recursive(arr, select, aIdx + 1, sIdx);
		
		
		
	}
}
