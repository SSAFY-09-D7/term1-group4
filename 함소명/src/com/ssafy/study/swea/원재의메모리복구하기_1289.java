package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//원재의 메모리 복구하기
//(모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산
public class 원재의메모리복구하기_1289 {

	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= N; test_case++) {
			String str = br.readLine();

			arr = new int[str.length()];

			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i)-'0';
			}

			System.out.print("#" + test_case + " ");
			recursive(0, 0, 0);
			System.out.println();
		}
	}

	public static void recursive(int idx, int temp, int cnt) {

		if (idx == arr.length) {
			System.out.print(cnt);
			return;
		}

		if (temp != arr[idx]) {
			cnt++;
			temp = arr[idx];
		}

		recursive(idx + 1, temp, cnt);
	}
}
