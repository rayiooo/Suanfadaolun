package Exp2;

/*
 * Experience 2��
 * ��һ����100���㣬500���ߣ�������ͼ
 * ��������޻�ͼ��DAG��
 * ��ʾ����DFS�����������õݹ�
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(100);	//new 100 points
		g.randomNewEdge(500);					//new 500 edges
		g.print();								//print chain
		
	}

}
