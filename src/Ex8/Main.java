package Ex8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int numOfPoint = 10;
		EighthGraph g = new EighthGraph(numOfPoint);
		while(!g.triangle_check())
			g.triangle_repaire();
		g.print();
		g.fk_run();
		
		System.out.println("========");
		
		g.prim();
		ArrayList<Integer> loop = g.MSTConstruct().getDLR();
		loop.add(0);
		g.getLength(loop);

		System.out.println("========");
		System.out.println("����MST�������ĵ㣬�����·�ĳ���ΪMST���ȵ�2����");
		System.out.println("��MST����С�ڵ���TSPȦ�ĳ��ȣ�����MST����Ȧ�ĳ���С�ڵ���TSPȦ���ȡ�");
		System.out.println("�������������ߺʹ��ڵ����飬ȥ�ظ���ı���Ȧ����С�ڵ���MST����Ȧ���ȣ�");
		System.out.println("�������·���Ȳ�����TSPȦ���ȵ�2����");
	}

}
