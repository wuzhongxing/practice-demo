package com.practice.jdmst;

import java.util.ArrayList;
import java.util.List;

public class PermutationT28 {

	public static void main(String[] args) {
		char[] s = "abcde".toCharArray();
//		permutation(s);
		List<String> list = new ArrayList<String>();
		select(s,list,3);
		for(String str : list) {
			System.out.println(str);
		}
	}

	static void permutation(char[] str) {
		if (str == null) {
			return;
		}
		permutation3(str, 0);
	}

	private static void permutation3(char[] cArrays, int begin) {
		if (begin >= cArrays.length) {
			System.out.println(cArrays);
		} else {
			for (int i = begin; i < cArrays.length; i++) {
				// 交换数组第一个元素与后续的元素
				char temp = cArrays[i];
				cArrays[i] = cArrays[begin];
				cArrays[begin] = temp;
				// 后续元素递归全排列
				permutation3(cArrays, begin + 1);
				// 将交换后的数组还原
				temp = cArrays[i];
				cArrays[i] = cArrays[begin];
				cArrays[begin] = temp;
			}
		}
	}

	public static void select(char[] source, List<String> arrayList,
			int num) {
		int l = source.length;

		char[] temp = new char[num];

		System.arraycopy(source, 0, temp, 0, num);

		arrayList.add(new String(temp));

		for (int i = num; i < l; i++) {
			for (int j = 0; j < num; j++) {
				char tempChar = temp[j];
				temp[j] = source[i];

				arrayList.add(new String(temp));

				temp[j] = tempChar;
			}
		}
	}
}
