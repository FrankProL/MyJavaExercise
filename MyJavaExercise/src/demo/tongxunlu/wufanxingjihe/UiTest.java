package demo.tongxunlu.wufanxingjihe;

import java.util.ArrayList;
import java.util.Scanner;

public class UiTest {
	public static void main(String[] args) {
		System.out.println("ϵͳ��ʼ����������");
		GroupMgr groupMgr = new GroupMgr();
		Group group01 = new Group(1, "ͬ��", "ͬ��");
		Group group02 = new Group(2, "����", "����");

		groupMgr.addGroup(group01);
		groupMgr.addGroup(group02);

		Scanner input = new Scanner(System.in);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ϵͳ��ʼ��������ɡ�");
		
		System.out.println(groupMgr.getAllGroup());//��ʾ���з���

		System.out.println("========���һ���·���=======");
		System.out.println("����������ID");

		int groupId = input.nextInt();
		System.out.println("��������������");
		String groupName = input.next();
		System.out.println("��������������");
		String groupDesc = input.next();

		Group newGroup = new Group(groupId, groupName, groupDesc);
		groupMgr.addGroup(newGroup);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ӳɹ�������");
		// System.out.println("========��ʾϵͳ����======");
		// ArrayList groups =groupMgr.getAllGroup();
		// for(Object obj:groups){
		// Group _group =(Group)obj;
		// System.out.println(_group);
		// }

		System.out.println("=========ϵͳģ�����������ϵ��======");
		System.out.println("��ѡ��Ҫ��ӵķ���ID");
		ArrayList groups = groupMgr.getAllGroup();
		for (Object obj : groups) {
			Group _group = (Group) obj;
			System.out.println(_group.getId() + "\t" + _group.getName());
		}

		int _groupId = input.nextInt();

		for (int i = 1; i <= 3; i++) {
			Group _group = groupMgr.getGroupById(_groupId);
			Contact contact = new Contact(i, "����" + i, (1386677777 + i) + "",
					"", "", "", _group);
			_group.addContact(contact);
		}
		
		System.out.println(group02.getContactByGroup(_groupId));
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==========ģ�����������ϵ�˳ɹ�����======");
		
		System.out.println("������Ҫ���ҵ����ţ�");
		for (Object obj : groups) {
			Group _group = (Group) obj;
			System.out.println(_group.getId() + "\t" + _group.getName());
		}
		groupId = input.nextInt();
		System.out.println("������Ҫ���ҵ���ϵ�˵绰");
		String mobile = input.next();

		Group group = groupMgr.getGroupById(groupId);
		ArrayList list = group.searchContact(mobile);

		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				Contact contact = (Contact) obj;
				System.out.println(contact);
			}
		}
		
	}
}
