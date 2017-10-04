package demo.tongxunlu.wufanxingjihe;

import java.util.ArrayList;
import java.util.Scanner;

public class UiTest {
	public static void main(String[] args) {
		System.out.println("系统初始化。。。。");
		GroupMgr groupMgr = new GroupMgr();
		Group group01 = new Group(1, "同事", "同事");
		Group group02 = new Group(2, "其他", "其他");

		groupMgr.addGroup(group01);
		groupMgr.addGroup(group02);

		Scanner input = new Scanner(System.in);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("系统初始化工作完成。");
		
		System.out.println(groupMgr.getAllGroup());//显示已有分组

		System.out.println("========添加一个新分组=======");
		System.out.println("请输入新组ID");

		int groupId = input.nextInt();
		System.out.println("请输入新组名称");
		String groupName = input.next();
		System.out.println("请输入新组描述");
		String groupDesc = input.next();

		Group newGroup = new Group(groupId, groupName, groupDesc);
		groupMgr.addGroup(newGroup);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("新组添加成功。。。");
		// System.out.println("========显示系统分组======");
		// ArrayList groups =groupMgr.getAllGroup();
		// for(Object obj:groups){
		// Group _group =(Group)obj;
		// System.out.println(_group);
		// }

		System.out.println("=========系统模拟添加三个联系人======");
		System.out.println("请选择要添加的分组ID");
		ArrayList groups = groupMgr.getAllGroup();
		for (Object obj : groups) {
			Group _group = (Group) obj;
			System.out.println(_group.getId() + "\t" + _group.getName());
		}

		int _groupId = input.nextInt();

		for (int i = 1; i <= 3; i++) {
			Group _group = groupMgr.getGroupById(_groupId);
			Contact contact = new Contact(i, "好友" + i, (1386677777 + i) + "",
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
		System.out.println("==========模拟添加三个联系人成功结束======");
		
		System.out.println("请输入要查找的组编号：");
		for (Object obj : groups) {
			Group _group = (Group) obj;
			System.out.println(_group.getId() + "\t" + _group.getName());
		}
		groupId = input.nextInt();
		System.out.println("请输入要查找的联系人电话");
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
