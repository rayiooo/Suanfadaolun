package Exp2;

/*
 * Experience 2��
 * ��һ����100���㣬500���ߣ�������ͼ
 * ��������޻�ͼ��DAG��
 * ��ʾ����DFS�����������õݹ�
 * 
 * Experience 3��
 * ��������DAG���·��
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(6);	//new 100 points
		g.randomNewEdge(15);					//new 500 edges
		g.print();								//print chain
		g.destroyAllLoop();					//print chain
		g.destroyAllLoop();					//print chain
		g.destroyAllLoop();
		g.print();
		g.culMaxWayOfDag();
	}

}
