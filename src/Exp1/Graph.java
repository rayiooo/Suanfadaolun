package Exp1;

import java.util.LinkedList;

/*
 * �ڽ�����ͼ��
 */
public class Graph {
	LinkedList<Integer> points[];//�ڽ�������
	
	/* ���췽�� */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Graph(int numOfPoints) {
		//���� numOfPoints �����ͼ
		points = new LinkedList[numOfPoints];
		//ÿ�������� header 0~99
		for(int i=0; i<numOfPoints; i++) {
			points[i] = new LinkedList();
			points[i].add(i);
			//System.out.println(points[i].getFirst());
		}
	}
	
	/* ��ͼ���������1���� */
	public void randomNewOneEdge() {
		int u, v;
		boolean flag = true;
		while(true) {
			//ѡ��������ͬ�ĵ�u,v
			while(true) {
				u = (int)(Math.random()*100);
				v = (int)(Math.random()*100);
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
			//�������߲����ڣ���ô������
			if(flag) {
				points[u].add(v);
				break;
			}else {
				flag = true;
			}
		}
		System.out.println("randomNewOneEdge(" + u + "," + v + ")");
	}
	
	/* ��ͼ���������n���� */
	public void randomNewEdge(int n) {
		for(int i=0; i<n; i++) {
			this.randomNewOneEdge();
		}
	}
	
	/* ���ͼ */
	public void print() {
		for(int i=0; i<points.length; i++) {
			for(int j=0; j<points[i].size(); j++) {
				System.out.print(points[i].get(j));
				System.out.print(" ����> ");
			}
			System.out.println();
		}
	}

	
}
