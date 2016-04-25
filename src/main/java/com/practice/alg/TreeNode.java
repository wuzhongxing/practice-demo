package com.practice.alg;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhongxing.wu
 * @since 2016年4月25日
 */
public class TreeNode {
	int nodeNum; // 节点编号
	TreeNode parent = null; // 遍历时的父节点
	int dis = Integer.MAX_VALUE;// 距离源节点的路径
	int discoverTime = 0; // 在DFS遍历时发现的时间
	int finishTime = 0;// DFS遍历时结束的时间
	Color color = Color.WHITE;// 初始时的颜色标记
	List<Integer> edges = new ArrayList<Integer>();// 节点的边集合

	public TreeNode(int i) {
		nodeNum = i;
	}

	public int getNodeNum() {
		return nodeNum;
	}

	public void setNodeNum(int nodeNum) {
		this.nodeNum = nodeNum;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int getDis() {
		return dis;
	}

	public void setDis(int dis) {
		this.dis = dis;
	}

	public int getDiscoverTime() {
		return discoverTime;
	}

	public void setDiscoverTime(int discoverTime) {
		this.discoverTime = discoverTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
}
