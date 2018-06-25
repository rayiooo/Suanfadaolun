package Ex7;

import Exp6.MatrixGraph;

public class SeventhGraph extends MatrixGraph{
	public int[] distance;
	public Bellman bellman;
	
	public SeventhGraph(int numOfPoints) {
		super(numOfPoints, true);
		// TODO �Զ����ɵĹ��캯�����
	}

	public SeventhGraph(int numOfPoints, int numOfEdges, int minLen, int maxLen) {
		super(numOfPoints, true);
		// TODO �Զ����ɵĹ��캯�����
		for(int i=0; i<numOfEdges; i++)
			this.addOneRandomEdge(minLen, maxLen);
	}
	
	public void bellman_ford(int startPoint) {
		bellman = new Bellman(this);
		bellman.init(startPoint);
		for(int i=0; i<n; i++){
			System.out.println("����������relax֮��"+(i+1)+"�Σ�");
			bellman.relax();
		}
		System.out.println("��Ȧ��⿪ʼ....");
		if(bellman.relax()){
			System.out.println("������������֮��ʾ����ͼ���и�Ȧ��");
		}else{
			System.out.println("������������֮��ʾ����ͼû�и�Ȧ��");
		}
	}

}
