package Exp2;

/*
 * Experience 2��
 * ��һ����100���㣬500���ߣ�������ͼ
 * ��������޻�ͼ��DAG��
 * ��ʾ����DFS�����������õݹ�
 * 
 * ˼·��
 * ɾ����ÿ������ʼ�Ļ�·���һ���ߣ���ջʵ��DFS��
 * 
 * Experience 3��
 * ��������DAG���·��
 * 
 * ˼·��
 * ��ÿ������ʼ����̬�滮BFS��DFS��ȡ�·�������е����·�������·����
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(6);	//new 100 points
		g.randomNewEdge(15);					//new 500 edges
		g.print();								//print chain
		g.destroyAllLoop();
		g.print();
		g.culMaxWayOfDag();
	}

}
