package Exp5;

/*
 * Exercise 5��
 * ����1��100���㣬300���ߵ�����ͼ������ͼ�е�ÿ����ͨ��֧���������еĸ�㡣
 * ��㣺����ͨ��֧��ɾ���õ㣬�ᵼ�·�֧������ͨ��
 * ��ʾ����ÿ����ͨ��֧����DFS������DFS��������
 * 		���ڵ��Ǹ�� <=> ���ڵ���������������
 * ���壺l[v]=min{d[v],d[w]:u��v�ĺ����w��v�����ȣ���(u,w)��E��(u,w)�Ƿ��ر�}
 * 		�Ǹ����u�Ǹ�� <=> (u,v)�����ߣ���l[v]>=d[u]
 * �ɲ���problem 22-2
 * 
 * ˼·��
 * ����ÿ���ڵ㶼����һ��ɾ������ɾ������ͨ��֧û�����Ǹ�㣬����ͨ��֧����1���Ǹ�㣨�����ⷨ����
 */

public class Main {

	public static void main(String[] args) {
		FifthGraph g = new FifthGraph(100);	//new 100 points
		g.randomNewEdge(300);					//new 300 edges
		g.print();								//print chain
		g.printGedian();
	}

}
