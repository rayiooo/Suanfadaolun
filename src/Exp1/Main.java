package Exp1;

public class Main {
	/*
	 * ����������￪ʼ����
	 */
	public static void main(String[] args) {
		System.out.println("Ҫ���������");
		Graph g = new Graph(100);//����100����
		g.randomNewEdge(3000);//����3000����
		g.print();//���ͼ���ڽ�����
		g.getDistanceOfEveryPoints(50);

	}

}
