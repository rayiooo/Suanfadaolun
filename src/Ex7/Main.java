package Ex7;

/*
 * ʵ��7����֪Bellman-Ford�㷨���ж�һ�������Ȩͼ�Ƿ��и�Ȩ�ص�Ȧ��
 * �����һ���㷨����ͼ���ҳ�һ����Ȧ��
 * ͼ��100���㡢500���ߣ�ÿ���ߵ�Ȩ����[-5,5]֮����������������
 * Ҫ�󣺶���������������ͼ��ֱ�����ָ�ȦΪֹ��
 */
public class Main {

	public static void main(String[] args) {
		SeventhGraph g = new SeventhGraph(100, 500, -5, 5);
		g.bellman_ford(0);
	}

}
