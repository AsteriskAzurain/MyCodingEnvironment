package com.ishang.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(getNum(4950, 100));
	}
	

	/*
	## 题目描述
		给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我们需要找出长度最小的那个。
		例如 N = 18 L = 2：
		5 + 6 + 7 = 18
		3 + 4 + 5 + 6 = 18
		都是满足要求的，但是我们输出更短的 5 6 7
		
	## 输入描述:
		> 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
		
	## 输出描述:
		> 从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
	 */
	private static String getNum(int N, int L) {
		int len = L;
		for (; len <= 100; len++) {
			int a1 = (N - (len * (len - 1) / 2)) / len;
			if (a1 < 0)
				break;
			// an=a1+(n-1)*d
			int an = a1 + (len - 1);
			int sn = (a1 + an) * len / 2;
			if (N == sn) {
				List<String> opList = new ArrayList<String>();
				for (int op = a1; op <= an; op++) {
					opList.add(String.format("%d", op));
				}
				return String.join(" ", opList);
			}
		}
		System.out.println(len);
		return "No";
	}
}
