package Exp1;

import java.util.LinkedList;

/*
 * �ڽ�����ͼ��
 */
public class Graph {
	protected LinkedList<Integer> points[];	//chain
	protected int edge;
	
	@SuppressWarnings("unchecked")
	public Graph(int numOfPoints) {
		this.edge = 0;
		//���� numOfPoints �����ͼ
		points = new LinkedList[numOfPoints];
		//ÿ�������� header 0~99
		for(int i=0; i<numOfPoints; i++) {
			points[i] = new LinkedList<Integer>();
			points[i].add(i);
		}
	}
	
	/* random new 1 edge */
	public void randomNewOneEdge() {
		int u, v;
		boolean flag = true;
		while(true) {
			//ѡ��������ͬ�ĵ�u,v
			while(true) {
				u = (int)(Math.random()*this.points.length);
				v = (int)(Math.random()*this.points.length);
				if(u!=v)
					break;
			}
			//����u���ڽ��������Ƿ���v�������������ѡ�㣬����ɹ�
			for(int i=0; i<points[u].size(); i++) {
				if(points[u].get(i)==v) {
					flag = false;
					break;
				}
			}
			//if this edge not exist, then add on
			if(flag) {
				this.addEdge(u, v);
				break;
			}else {
				flag = true;
			}
		}
	}
	
	/* random new n edges */
	public void randomNewEdge(int n) {
		for(int i=0; i<n; i++) {
			this.randomNewOneEdge();
		}
	}
	
	/* out print graph */
	public void print() {
		for(int i=0; i<points.length; i++) {
			for(int j=0; j<points[i].size(); j++) {
				System.out.print(points[i].get(j));
				System.out.print(" ����> ");
			}
			System.out.println();
		}
		System.out.println("This graph has " + this.edge + " edges.");
	}

	/* add 1 edge u-->v */
	public void addEdge(int u, int v){
		this.points[u].add(v);
		this.edge += 1;
		System.out.println("Add Edge (" + u + "," + v + ")");
	}
	
	/* delete 1 edge u-->v */
	public void deleteEdge(int u, int v){
		boolean removed = this.points[u].remove((Integer)v);
		if(removed){
			this.edge -= 1;
			System.out.println("Delete Edge (" + u + "," + v + ")");
		}else{
			System.out.println("Failed to delete Edge (" + u + "," + v + ")");
		}
	}

	/* return a reverse graph */
	public Graph getReverseGraph() {
		Graph res = new Graph(this.points.length);
		for(int i=0; i<this.points.length; i++) {
			int u = this.points[i].get(0);
			for(int j=1; j<this.points[i].size(); j++) {
				int v = this.points[i].get(j);
				res.addEdge(v, u);
			}
		}
		return res;
	}
	
	/* clone graph without ���� */
	public Graph clone() {
		Graph ret = new Graph(points.length);
		ret.edge = this.edge;
		for(int i=0; i<points.length; i++) {
			for(int j=1; j<points[i].size(); j++) {
				ret.points[i].add(j, points[i].get(j));;
			}
		}
		return ret;
	}
}
