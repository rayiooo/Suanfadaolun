package Exp6;

/*
 * Exercise 6��
 * �þֲ������㷨����һ������ͼ����С��������
 * ����һ��������ͨͼ����100���㣬1000���ߣ����ϵ�Ȩ����1-20֮������������
 * �ֲ������㷨�Ļ���˼·��
 * 1.�Լ��跨�õ�һ��������T��
 * 2.��鲻��T�ϵıߣ��������һ���ߣ�����һ��������ɾ��һ�����ϵ����Ȩ�صıߡ�
 * 3.�ظ�2��ֱ�����б߶������Ż�Ϊֹ��
 * ��Kruskal��Prim�㷨��ø�ͼ����С����������֤�ֲ������㷨�ĶԴ�
 */

public class Main {

	public static void main(String[] args) {
		SixthGraph g = new SixthGraph(10);	//��������ͼ
		for(int i=0; i<20; i++)
			g.addOneRandomEdge(1, 20);
		System.out.println("******ԭʼ����ͼ�ڽӾ���******");
		g.print();
		if(g.selectRandomTree()) {
			System.out.println("******������ɵ�Tree******");
			g.printSelectedTree();
			System.out.println("******�ֲ���������******");
			g.localSearch();
			System.out.println("******�������ɵ�MST******");
			g.printSelectedTree();
			// ����һ����֤�㷨

			// prim
			System.out.println("******Prim�㷨֤����MST******");
			g.cleanAllSelectedEdge();
			g.prim();
			g.printSelectedTree();
		}
		
	}

}
