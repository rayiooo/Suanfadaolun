package Exp1;

/*
 * Experience 1��
 * ����һ��100���㡢3000���ߵ��������ͼ
 * ��ѡһ��ΪԴ�㣬����s��������ľ���
 * ע��ͼ���ڽ�����洢
 */

public class Main {
	/*
	 * ����������￪ʼ����
	 */
	public static void main(String[] args) {
		System.out.println("Ҫ���������");
		Graph g = new Graph(100);	//����100����
		g.randomNewEdge(3000);		//����3000����
		g.print();					//���ͼ���ڽ�����
		g.getDistanceOfEveryPoints(50);	//����ÿ���㵽50�ŵ�ľ���

	}

}
