package demo.mulitithread;

/**
 * 多线程下载调度程序
 */
import java.io.File;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

public class MultiThreadGetFile extends Thread {
	long startPos = 0, endPos = 0;
	String currentFileThreadName;// 要带上完整的路径
	String urlFile;// 网络文件地址
	String urlFileName;// 网络文件名
	String localFileAddress;// 下载文件要存放的地址
	int threadNum;// 要同时下载的线程数
	long[] eachThreadLength;// 每个线程要下载的文件分块的大小
	long urlFileLength;// 网络文件的大小
	URL url;
	HttpURLConnection httpURLConnection;
	public static boolean[] checkList;// 检测线程

	public MultiThreadGetFile(String urlFile, int threadNum,
			String localFileAddress) {
		this.urlFile = urlFile;//要下载的网络资源
		this.threadNum = threadNum;// 要同时下载的线程数
		this.localFileAddress = localFileAddress;  //要保存的本地路径

	}

	private void init_getEachThreadLength()// 确定每个线程文件最终要写的文件的大小
	{
		long l;
		l = urlFileLength / threadNum;
		for (int i = 0; i < threadNum; i++) {
			if (i == threadNum - 1)// 如果是分配最后一个线程了
			{
				eachThreadLength[i] = urlFileLength - i * l;
			} else
				eachThreadLength[i] = l;
		}
	}

	//得到传递过来的带路径的文件的文件名
	//eg:GetFileName("d://test/test.txt")
	//返回为：test.txt
	private String GetFileName(String file) {
		StringTokenizer st = new StringTokenizer(file, "/");
		while (st.hasMoreTokens()) {
			file = st.nextToken();
		}
		return file;
	}

	private void init() {
		if (!new File(localFileAddress + "tmp").mkdir())// 创建一个临时文件夹
		{
			//System.out.println("创建文件夹失败！");
		}
		eachThreadLength = new long[threadNum];
		try {
			url = new URL(urlFile);
			//此处的Connection仅仅是用于获取服务端的要下载的
			//资源的名称资源的大小，所以一旦得到后就关闭
			httpURLConnection = (HttpURLConnection) url.openConnection();
			urlFileLength = Long.parseLong(httpURLConnection
					.getHeaderField("Content-Length"));
			urlFileName = url.getFile();// 取得在服务器上的路径及文件名
			urlFileName = GetFileName(urlFileName);// 只得文件名
			init_getEachThreadLength();// 确定每个线程文件最终要写的文件的大小
			httpURLConnection.disconnect();
			checkList = new boolean[threadNum + 1];//用于记载每一个线程是否下载完毕!
			for (int i = 1; i <= threadNum; i++) {
				if (i > 1)startPos = startPos + eachThreadLength[i - 2];
				endPos = startPos + eachThreadLength[i - 1];
				currentFileThreadName = localFileAddress + "tmp//"
						+ urlFileName + ".part" + i;
				// System.out.println("startPos:"+(startPos));
				// System.out.println("endPos:"+(endPos));
				// System.out.println("Size:"+(endPos-startPos));
				Thread thread = new Thread(new GetFileThread(urlFile, startPos,
						endPos, currentFileThreadName, i));
				thread.start();
				checkList[i] = false;// 表示该线程开始
			}
			//用于监视九个线程是否已经下载完毕，如果已经下载完毕，则开始
			//启动合并文件的操作
			Thread policeThread = new Thread(new PoliceThread(threadNum,
					localFileAddress, localFileAddress + "tmp"));
			policeThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		init();
	}
}
