package com.practice.jdmst;

import java.util.ArrayList;
import java.util.List;

public class PermutationT28 {

	public static void main(String[] args) {
		char[] s = "abc".toCharArray();
		// permutation(s);
		perm(s,0,s.length-1);
		List<String> list = new ArrayList<String>();
		select(s, list, 2);
		for (String str : list) {
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
	/**
	 * 
	 * @param buf char数组
	 * @param start	选定char index
	 * @param end 数组end
	 */
	public static void perm(char[] buf, int start, int end) {
		if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			System.out.println(buf);
		} else {// 多个字母全排列
			for (int i = start; i <= end; i++) {
				// 交换数组第一个元素与后续的元素
				char temp = buf[start];
				buf[start] = buf[i];
				buf[i] = temp;

				perm(buf, start + 1, end);// 后续元素递归全排列
				
				// 将交换后的数组还原
				temp = buf[start];
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}

	public static void select(char[] source, List<String> arrayList, int num) {
		int l = source.length;

		char[] temp = new char[num];

		System.arraycopy(source, 0, temp, 0, num);
		System.out.println("temp=" + temp.toString());
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
