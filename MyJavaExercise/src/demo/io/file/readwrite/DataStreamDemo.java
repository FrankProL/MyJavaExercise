package demo.io.file.readwrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1.DataOutputStream/DataInputStream 能够以特定数据类型的方式读写数据
 * 流 可以层层包装，传进的是InputStream/OutputStream抽象类就可以了
 * 2.把集合转换为数组 list.toArray(new Person[0])
 * 3.更加方便的输出数组的内容，方便调试 Arrays.toString(persons)
 */

public class DataStreamDemo {
	private static final String FILENAME = "data/data.dat";

	public static void main(String[] args) throws IOException {
		Person[] persons = { new Person("zhansan", 32, true),
				new Person("lisi", 31, false) };

		writeToFile(persons);
		persons = readFromFile();
		
		/*
		System.out.println(persons);	//这样输出是对象
		*/
		//*******前提是类中要重新toString方法
		//直接调用Arrays的静态方法
		System.out.println(Arrays.toString(persons));
		
		//循环输出
		for(Person p:persons){
			System.out.println(p);
		}
	}

	private static void writeToFile(Person[] persons) throws IOException {
		// 以指定数据类型方式写入数据
		File file = new File(FILENAME);
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(file)));
		for (Person p:persons){
			out.writeUTF(p.name);
			out.writeInt(p.age);
			out.writeBoolean(p.sex);
		}
		out.flush();	//清空缓冲区
		out.close();
	}

	private static Person[] readFromFile() throws IOException {
		// 以指定数据类型的方式读数据
		File file = new File(FILENAME);
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(file)));
		List<Person> list = new ArrayList<Person>();	//不知有多长，所以用集合

		try {						//不好判断何时读完，使其读完报错抛出
			while (true) {
				Person p = new Person();
				p.name = in.readUTF();
				p.age = in.readInt();
				p.sex = in.readBoolean();
				list.add(p);
			}
		} catch (EOFException e) {
			
		}
		in.close();

		return list.toArray(new Person[0]);		//泛型集合转化为数组的方式（常用）
	}
}

class Person {
	String name;
	Integer age;
	Boolean sex;

	public Person() {

	}

	public Person(String name, Integer age, Boolean sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}