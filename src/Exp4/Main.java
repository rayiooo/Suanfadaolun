package Exp4;

/*
 * Experience 4:
 * �ҳ�һ��100���㡢500���ߵ�����ͼ������ǿ��ͨ��֧��
 * 
 * ˼·��
 * �̶��㷨��ԭͼDFS���������ʱ��f[]��ת��ͼ��f[]����DFS��������������ǿ��ͨ��֧��������ÿ�����Ľڵ㶼��һ��ǿ��ͨ��֧��
 */
public class Main {

	public static void main(String[] args) {
		FourthGraph g = new FourthGraph(6);	//new 100 points
		g.randomNewEdge(8);					//new 500 edges
		g.print();								//print chain
		g.printStrongComponents();
	}

}
