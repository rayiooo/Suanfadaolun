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
		FirstGraph g = new FirstGraph(100);	//����100����
		g.randomNewEdge(500);		//����500����
		g.print();					//���ͼ���ڽ�����
		g.getDistanceOfEveryPoints(50);	//����ÿ���㵽50�ŵ�ľ���

	}

}
