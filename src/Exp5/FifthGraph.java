package Exp5;

import java.util.LinkedList;
import java.util.Stack;

import Exp1.Graph;

public class FifthGraph extends Graph{

	public FifthGraph(int numOfPoints) {
		super(numOfPoints);
	}

	/* ��ȡ��㲢��� */
	public void printGedian() {
		System.out.println("��ǰͼ�ĸ���У�");
		for(int i=0; i<points.length; i++) {
			FifthGraph extraGraph = this.clone();
			extraGraph.deleteAllEdgeOfPoint(i);
			int ltfz1 = this.getLiantongfenzhiAmount();
			int ltfz2 = extraGraph.getLiantongfenzhiAmount();
			if(ltfz2 - ltfz1 == 2)
				System.out.print(i + ",");
			extraGraph = null;
		}
	}
	
	/* ��ȡ��ͨ��֧���� */
	public int getLiantongfenzhiAmount() {
		int[] flag = new int[points.length];
//		Color[] color = new Color[points.length];
		for(int i=0; i<flag.length; i++) {
			flag[i] = 0;
//			color[i] = Color.WHITE;
		}
		
		// DFS all points and flag every liantongfenzhi
		Stack<Integer> st = new Stack<Integer>();
		int max = 0;
		for(int i=0; i<points.length; i++) {
			if(flag[i] > 0)
				continue;
			else if(flag[i] == 0){
				max++;
				st.push(i);
				while(!st.isEmpty()) {
					int c = st.pop();	//current
					flag[c] = max;
					for(int j=1; j<points[c].size(); j++) {
						int child = points[c].get(j);
						if(flag[child] > 0)
							continue;
						else if(flag[child] == 0)
							st.push(child);
					}
				}
			}
		}
		return max;
	}
	
	/* delete all edge of point n */
	public void deleteAllEdgeOfPoint(int n) {
		this.points[n] = new LinkedList<Integer>();
		this.points[n].add(n);
		for(int i=0; i<this.points.length; i++) {
			for(int j=1; j<this.points[i].size(); j++) {
				if(this.points[i].get(j) == n)
					this.points[i].remove(j);
			}
		}
	}
	
	/* ����ͼ random new 1 double direction edge */
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
				this.addEdge(v, u);	//double direction
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
	
	/* clone graph without ���� */
	public FifthGraph clone() {
		FifthGraph ret = new FifthGraph(points.length);
		ret.edge = this.edge;
		for(int i=0; i<points.length; i++) {
			for(int j=1; j<points[i].size(); j++) {
				ret.points[i].add(j, points[i].get(j));;
			}
		}
		return ret;
	}
}
