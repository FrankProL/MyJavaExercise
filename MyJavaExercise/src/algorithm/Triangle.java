package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 符号三角形问题
 * 同号为+，异号为－
 * 代码中实际以0代表-，以1代表+
 * @author Frank
 *
 */
public class Triangle {
	static int n;// 第一行的符号个数
	static int half;// n*(n+1)/4
	private int count = 0;// 当前-的个数		//应该是+的个数
	private int p[][];// 符号三角形矩阵
	private static long sum = 0;// 已找到的符号三角形个数

	public static void main(String args[]) {
		try {
			Triangle t = new Triangle();
			System.out.print("请输入首行符号个数：");
			BufferedReader str = new BufferedReader(new InputStreamReader(
					System.in));
			int temp1 = Integer.parseInt(str.readLine());
			n = temp1;
			half = n * (n + 1) / 2;
			t.p = new int[n + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					t.p[i][j] = 0;
				}
			}
			if (half % 2 == 1) {
				System.out.println("不存在这样的符号三角形");
			} else {
				half = half / 2;
				t.BackTrack(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void BackTrack(int t)// t，第一行第t个符号
	{
		if ((count > half) || (t * (t - 1) / 2 - count > half))// 剪枝函数
		{
			return;
		}
		if (t > n)// 符号填充完毕
		{
			sum++;
			System.out.println("\n第" + sum + "个三角形：");
			printTriangle();
		} else {
			for (int i = 0; i < 2; i++) {
				p[1][t] = i; // t，第一行第t个符号
				count = count + i;// 减号统计
				for (int j = 2; j <= t; j++)// 当第一行符号>=2时，可以运算出下面行的某些符号，j可代表行号
				{
					if (p[j - 1][t - j + 1] == p[j - 1][t - j + 2]) {
						p[j][t - j + 1] = 1;
					} else {
						p[j][t - j + 1] = 0;
					}
					count = count + p[j][t - j + 1];
				}
				BackTrack(t + 1);// 在第一行增加下一个符号
				for (int j = 2; j <= t; j++)// 回溯，判断另一种符号情况
											// 像是出栈一样，恢复所有对counter的操作
				{
					count = count - p[j][t - j + 1];
				}
				count = count - i;
			}
		}
	}

	public void printTriangle() {
		int temp = n;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= temp; j++) {
				if (p[i][j] == 0) {
					System.out.print("- ");
				} else {
					System.out.print("+ ");
				}
			}
			System.out.println();
			temp--;
		}
	}
}