package com.practice.alg;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author zhongxing.wu
 * @since 2016年4月25日
 */
public class GraphicModelII {
	TreeNode[] heads = null;
	final int NODENUM;
	static int systemTime = 0;
	Stack<TreeNode> topoSortUtil = new Stack<TreeNode>();
	TreeNode[] heads_reverse = null;

	public GraphicModelII(int nodeNum) {
		NODENUM = nodeNum;
		heads = new TreeNode[NODENUM + 1];
		heads_reverse = new TreeNode[NODENUM + 1];

		for (int i = 1; i <= nodeNum; i++) {
			heads[i] = new TreeNode(i);
			heads_reverse[i] = new TreeNode(i);
		}
	}

	public void addEdge(int src, int des) {
		heads[src].edges.add(des);
	}

	public void BFS(int src) {
		Queue<TreeNode> searchs = new LinkedList<TreeNode>();

		heads[src].color = Color.GRAY;
		heads[src].dis = 0;
		searchs.add(heads[src]);
		while (!searchs.isEmpty()) {
			TreeNode cur = searchs.poll();
			System.out.println("Node : " + cur.nodeNum);
			for (Integer des : cur.edges) {
				TreeNode now = heads[des];
				if (now.color == Color.WHITE) {
					now.color = Color.GRAY;
					now.dis = cur.dis + 1;
					now.parent = cur;
					searchs.add(now);
				}
			}
			cur.color = Color.BLACK;
		}

	}

	public void DFS() {
		systemTime = 0;
		for (int i = 1; i <= NODENUM; i++) {

			TreeNode node = heads[i];
			if (node.color == Color.WHITE) {
				DFS_Visit(node);
			}
		}
	}

	public void DFS_Visit(TreeNode node) {
		node.color = Color.GRAY;
		systemTime++;
		node.discoverTime = systemTime;
		for (Integer des : node.edges) {
			TreeNode now = heads[des];
			if (now.color == Color.WHITE) {
				now.parent = node;
				DFS_Visit(now);
			}
		}
		node.color = Color.BLACK;
		systemTime++;
		node.finishTime = systemTime;
		topoSortUtil.push(node);
		System.out.println(node.nodeNum + "start:\t" + node.discoverTime + " end:\t" + node.finishTime);
	}

	public void topoSort() {
		topoSortUtil.clear();
		DFS();
		while (!topoSortUtil.isEmpty()) {
			System.out.println(topoSortUtil.pop().nodeNum);
		}
	}

	public void SCC() {

		DFS();
		List<TreeNode> scc = new ArrayList<TreeNode>();
		reverTopo();
		while (!topoSortUtil.isEmpty()) {
			TreeNode cur = heads_reverse[topoSortUtil.pop().nodeNum];
			if (cur.color == Color.WHITE) {
				DFS_Visit_Scc(cur, scc);
			}
			for (TreeNode node : scc) {
				System.out.print(node.nodeNum);
			}
			System.out.println();
			scc.clear();
		}
	}

	public void DFS_Visit_Scc(TreeNode node, List<TreeNode> scc) {
		node.color = Color.GRAY;
		systemTime++;
		node.discoverTime = systemTime;
		for (Integer des : node.edges) {
			TreeNode now = heads_reverse[des];
			if (now.color == Color.WHITE) {
				now.parent = node;
				DFS_Visit_Scc(now, scc);
			}
		}
		node.color = Color.BLACK;
		systemTime++;
		node.finishTime = systemTime;
		scc.add(node);
	}

	private void reverTopo() {
		for (int i = 1; i <= NODENUM; i++) {
			TreeNode node = heads[i];
			int src = node.nodeNum;
			for (Integer des : node.edges) {
				TreeNode reverNode = heads_reverse[des];
				reverNode.edges.add(src);
			}
		}
	}

	public static void main(String[] args) {
		// GraphicModelII graph = new GraphicModelII(5);
		// graph.addEdge(1, 2);
		// graph.addEdge(1, 5);
		// graph.addEdge(2, 1);
		// graph.addEdge(2, 5);
		// graph.addEdge(2, 4);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 2);
		// graph.addEdge(3, 4);
		// graph.addEdge(4, 2);
		// graph.addEdge(4, 5);
		// graph.addEdge(5, 4);
		// graph.addEdge(5, 2);
		// graph.addEdge(5, 1);
		// graph.BFS(1);
		// graph.DFS();
		// GraphicModelII graph = new GraphicModelII(9);
		// graph.addEdge(1, 2);
		// graph.addEdge(1, 8);
		// graph.addEdge(2, 3);
		// graph.addEdge(2, 8);
		// graph.addEdge(3, 6);
		// graph.addEdge(4, 3);
		// graph.addEdge(4, 5);
		// graph.addEdge(5, 6);
		// graph.addEdge(7, 8);
		// graph.topoSort();

		// test scc
		GraphicModelII graph = new GraphicModelII(8);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(4, 8);
		graph.addEdge(5, 1);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 6);
		graph.addEdge(7, 8);
		graph.addEdge(8, 8);
		// graph.topoSort();
		graph.SCC();
	}
}
