package Exp6;

import java.awt.Color;
import java.util.Random;
import java.util.Stack;

/*
 * ��ɫ�ıߣ�δѡ�еı�
 * ��ɫ�ıߣ�ѡ�еı�
 * ��ɫ�ıߣ����õı�
 * 
 * Ĭ�ϵ���ͼΪ����ͼ
 */
public class SixthGraph extends MatrixGraph{
	Color[][] edgeColor;
	
	public SixthGraph(int numOfPoints) {
		super(numOfPoints, false);
		edgeColor = new Color[n][n];
		this.cleanAllSelectedEdge();
	}

	public boolean selectRandomTree() {
		Random r = new Random();
		int startPoint = r.nextInt(n);
		Color[] pointColor = new Color[n];
		pointColor[startPoint] = Color.BLACK;
		for(int i=0; i<n; i++)
			pointColor[i] = Color.WHITE;
		Stack<Integer> s = new Stack<Integer>();
		s.push(startPoint);
		while(!s.isEmpty()) {
			int point = s.pop();
			for(int i=0; i<n; i++) {
				if(matrix[point][i]>0 && pointColor[i]==Color.WHITE) {
					pointColor[i] = Color.BLACK;	// seen this point
					edgeColor[point][i] = Color.BLACK;	// select this edge
					edgeColor[i][point] = Color.BLACK;
					s.push(i);
				}
			}
		}
		for(int i=0; i<n; i++) {
			if(pointColor[i] == Color.WHITE) {
				System.out.println("It's a ɭ��, not ��!");
				return false;
			}
		}
		return true;
	}
	
	/* �ֲ����� */
	public void localSearch() {
		System.out.println("Local search begin:");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] > 0 && edgeColor[i][j] == Color.WHITE) {
					edgeColor[i][j] = Color.BLACK;
					edgeColor[j][i] = Color.BLACK;
					System.out.println("Add 1 edge��(" + i + ", " + j + "), length��" + matrix[i][j]);
					int deleteLength = this.unselectMaxEdgeInLoop(i);
					assert(deleteLength>matrix[i][j]);
				}
			}
		}
	}
	
	/* ����������red�����������ߵĳ��� */
	public int unselectMaxEdgeInLoop(int start) {
		// System.out.println("start="+start);
		SixthGraph g = this.getSelectedTree();
		int[] pai = new int[n];	// �������ÿ�����ǰһ�����
		int[] wantToBePai = new int[n]; // �������ÿ����ı���ǰ��
		for(int i=0; i<n; i++) {
			pai[i] = -1;
			wantToBePai[i] = -1;
		}
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			if(edgeColor[start][i]==Color.BLACK && g.matrix[start][i]>0) {
				wantToBePai[i] = start;
				s.push(i);
			}
		}
		
		// �������or���Ѱ�����õ�pai�Լ�������ʼ��startLoopPoint
		// ��һ��д��bug�������ˣ�ɾ����д֮���ڶ���д��bug̫���������ǵ�����д��
		while(!s.empty()) {
			int current = s.pop();
			if(current != start)	// ��ֹ���ʹ���
				pai[current] = wantToBePai[current];
			for(int i=0; i<n; i++) {
				if(edgeColor[current][i] == Color.BLACK && g.matrix[current][i] > 0 && pai[i] == -1) {
					wantToBePai[i] = current;
					// System.out.println("wantToBePai["+i+"]="+current+";");
					s.push(i);
					// System.out.println("s.push("+i+");");
				}
			}
		}
		pai[start] = wantToBePai[start];
		
		//������startLoopPointΪ���Ļ�����߲�red��
		int u = start, v = pai[start];
		int current = u;
		int max = 0;
		// run
		for(int i=0; i<n; i++) {
			if(g.matrix[current][pai[current]] > max) {
				max = g.matrix[current][pai[current]];
				u = current;
				v = pai[current];
			}
			current = pai[current];
		}
		edgeColor[u][v] = Color.RED;
		edgeColor[v][u] = Color.RED;
		System.out.print("Delete edge:(" + u + ", " + v + "), length=" + g.matrix[u][v] + "\t");
		
		// syslog ��
		System.out.print("�У�[" + start + ", ");
		for(int i=pai[start]; i!=start; i=pai[i]) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
		return g.matrix[u][v];
	}
	
	public SixthGraph getSelectedTree() {
		SixthGraph g = new SixthGraph(n);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(edgeColor[i][j] == Color.BLACK)
					g.addEdge(i, j, matrix[i][j]);
			}
		}
		return g;
	}
	
	public void printSelectedTree() {
		this.printSelectedGraphOrTreeSumLength();
		System.out.println("Current selected tree:");
		this.getSelectedTree().print();
	}
	
	public void cleanAllSelectedEdge(){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				edgeColor[i][j] = Color.WHITE;
			}
		}
	}

	public int printSelectedGraphOrTreeSumLength() {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(edgeColor[i][j] == Color.BLACK) {	// selected edge
					sum += matrix[i][j];
				}
			}
		}
		sum /= 2;
		System.out.println("Current selected edges sum length��" + sum);
		return sum;
	}

	public void prim(){
		Color[] pointColor = new Color[n];
		for(int i=0; i<n; i++){
			pointColor[i] = Color.WHITE;
		}
		pointColor[0] = Color.BLACK;
		for(int i=0; i<n-1; i++){
			int u = 0, v = 0;
			int minEdge = 999999;
			// for every point
			for(int j=0; j<n; j++){
				if(pointColor[j] == Color.BLACK){
					// for every edge of the point j
					for(int k=0; k<n; k++){
						if(edgeColor[j][k] != Color.BLACK && matrix[j][k]>0 && matrix[j][k]<minEdge){
							u = j;
							v = k;
							minEdge = matrix[j][k];
						}
					}
				}
			}
			// then we get the min edge from black point
			edgeColor[u][v] = Color.BLACK;
			edgeColor[v][u] = Color.BLACK;
			pointColor[v] = Color.BLACK;
		}
	}
}
