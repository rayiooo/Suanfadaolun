package Exp1;

import java.util.LinkedList;

public class FirstGraph extends Graph{

	public FirstGraph(int numOfPoints) {
		super(numOfPoints);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	/* ����ÿ���㵽ָ����s�ľ��� */
	public void getDistanceOfEveryPoints(int n) {
		//�洢ÿ���㵽��n�ľ���
		int distance[] = new int[100];
		for(int i=0; i<distance.length; i++) {
			distance[i] = 999999;//��ʼ��ÿ����ľ���Ϊ999999
		}
		distance[n] = 0;//��n��n�ľ�����0
		
		//���ж�̬�滮BFS����
		LinkedList<Integer> bfs = new LinkedList<Integer>();
		bfs.add(n);
		while(bfs.size()>0) {
			int bfsPoint = bfs.getFirst();
			for(int i=0; i<this.points[bfsPoint].size(); i++) {
				if(distance[bfsPoint]+1 < distance[this.points[bfsPoint].get(i)]) {
					distance[this.points[bfsPoint].get(i)] = distance[bfsPoint]+1;
					bfs.add(this.points[bfsPoint].get(i));
				}
			}
			bfs.remove(0);
		}
		
		//������ս��
		System.out.println("ÿ���㵽��"+n+"�ľ����ǣ�");
		for(int i=0; i<distance.length; i++) {
			System.out.println(i+"��"+distance[i]);
		}
	}
}
