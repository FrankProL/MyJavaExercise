package demo.io.file.readwrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ObjectInputStream/ObjectOutputStream 用于读写对象
 * 其他写法类似于DataStreamDemo--->DataOutputStream/DataInputStream 能够以特定数据类型的方式读写数据
 */
public class ObjectStreamDemo {
	private static final String FILENAME = "data/object.dat";

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		Human[] humans = { new Human("zhansan", 32, true),
				new Human("lisi", 33, false) };

		writeToFile(humans);
		humans = readFromFile();
		System.out.println(Arrays.toString(humans));
	}

	private static Human[] readFromFile() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(FILENAME);
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(file)));
		List<Human> list =new ArrayList<Human>();
		
		try {
			while (true){
				Human h=(Human) in.readObject();
				list.add(h);
			}
		} catch (EOFException e) {
			
		}
		in.close();
		return list.toArray(new Human[0]);
	}

	private static void writeToFile(Human[] humans)
			throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		File file = new File(FILENAME);
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)));

		for (Human hu : humans) {
			out.writeObject(hu);
		}
		out.flush();
		out.close();
	}
}

class Human implements Serializable { // 序列化接口，空接口，标志接口，代表这个类有这种功能，可序列化
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;
	Integer age;
	Boolean sex;

	public Human() {
		super();
	}

	public Human(String name, Integer age, Boolean sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}