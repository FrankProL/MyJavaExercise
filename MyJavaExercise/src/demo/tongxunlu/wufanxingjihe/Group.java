package demo.tongxunlu.wufanxingjihe;

import java.util.ArrayList;

/**
 * 分组类
 * @author Frank
 *
 */
public class Group {
	private int id;
	private String name;
	private String desc;

	private ArrayList contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Group() {
		contacts = new ArrayList();
	}

	public Group(int id, String name, String desc) {
		super();
		contacts = new ArrayList();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	/**
	 * 根据联系人id获取联系人实体
	 * 
	 * @param contactId
	 *            联系人id
	 * @return
	 */
	// 根据主键id进行查找
	public Contact getContactById(int contactId) {

		for (Object obj : this.contacts) { // 遍历集合
			Contact contact = (Contact) obj;
			if (contact.getId() == contactId) {
				return contact;
			}
		}
		return null;
	}

	/**
	 * 获取某一组的所有联系人集合
	 * 
	 * @param groupId
	 *            组id
	 * @return
	 */
	// 根据组进行查找
	public ArrayList getContactByGroup(int groupId) {

		ArrayList result = new ArrayList();

		for (Object obj : this.contacts) {
			Contact contact = (Contact) obj;
			if (contact.getGroup().getId() == groupId) {
				result.add(contact);
			}
		}
		return result;
	}

	// 添加联系人信息
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	public void addContact(int id, String name, String mobile, String email,
			String birthday, String addr, Group group) {
		Contact contact = new Contact(id, name, mobile, email, birthday, addr,
				group);
		this.addContact(contact); // 方便代码的修改和扩展
		// this.contacts.add(contact);
		// //效果同调用addContact一样，但当addContact逻辑变化时这里还要修改，所以直接调用更好
	}

	// 修改联系人信息
	public void updateContact(Contact contact) {

		int index = -1;
		for (int i = 0; i < this.contacts.size(); i++) {
			Contact _contact = (Contact) this.contacts.get(i);
			if (_contact.getId() == contact.getId()) {
				index = i;
				break;
			}
		}

		this.contacts.set(index, contact);

	}

	public void updateContact(int id, String name, String mobile, String email,
			String birthday, String addr, Group group) {

		// 新建时可以这样，但修改时这样可能会出错
		// Contact contact = new Contact(id,name,.....);
		// this.updateContact(contact);

		Contact contact = this.getContactById(id);
		contact.setName(name);
		contact.setMobile(mobile);
		contact.setEmail(email);
		contact.setBirthday(birthday);
		contact.setAddr(addr);
		contact.setGroup(group);

		this.updateContact(contact);

	}
	
	// 删除联系人
	public void delContact(Contact contact) {
		this.contacts.remove(contact);
	}

	public void delContact(int contactId) {
		Contact contact = this.getContactById(contactId);
		this.delContact(contact);
	}
	
	// 查找联系人
	public ArrayList searchContact(String mobileorname) {
		ArrayList result = new ArrayList();
		for (Object obj : this.contacts) {
			Contact contact = (Contact) obj;
			if (contact.getMobile().indexOf(mobileorname) != -1 && contact.getGroup().getId()==this.getId()) {
				result.add(contact);
			} else if (contact.getName().contains(mobileorname) && contact.getGroup().getId()==this.getId()) {
				result.add(contact);
			}
		}

		return result;

	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
