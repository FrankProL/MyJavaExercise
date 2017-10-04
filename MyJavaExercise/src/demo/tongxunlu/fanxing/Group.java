package demo.tongxunlu.fanxing;

import java.util.ArrayList;

/**
 * ������
 * @author Frank
 *
 */
public class Group {
	private int id;
	private String name;
	private String desc;

	private ArrayList<Contact> contacts;

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
		contacts = new ArrayList<Contact>();
	}

	public Group(int id, String name, String desc) {
		super();
		contacts = new ArrayList<Contact>();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	/**
	 * ������ϵ��id��ȡ��ϵ��ʵ��
	 * 
	 * @param contactId
	 *            ��ϵ��id
	 * @return
	 */
	// ��������id���в���
	public Contact getContactById(int contactId) {

		for (Contact obj : this.contacts) { // ��������
			if (obj.getId() == contactId) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * ��ȡĳһ���������ϵ�˼���
	 * 
	 * @param groupId
	 *            ��id
	 * @return
	 */
	// ��������в���
	public ArrayList<Contact> getContactByGroup(int groupId) {

		ArrayList<Contact> result = new ArrayList<Contact>();

		for (Contact obj : this.contacts) {
			if (obj.getGroup().getId() == groupId) {
				result.add(obj);
			}
		}
		return result;
	}

	// �����ϵ����Ϣ
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	public void addContact(int id, String name, String mobile, String email,
			String birthday, String addr, Group group) {
		Contact contact = new Contact(id, name, mobile, email, birthday, addr,
				group);
		this.addContact(contact); // ���������޸ĺ���չ
		// this.contacts.add(contact);
		// //Ч��ͬ����addContactһ��������addContact�߼��仯ʱ���ﻹҪ�޸ģ�����ֱ�ӵ��ø���
	}

	// �޸���ϵ����Ϣ
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

		// �½�ʱ�������������޸�ʱ�������ܻ����
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
	
	// ɾ����ϵ��
	public void delContact(Contact contact) {
		this.contacts.remove(contact);
	}

	public void delContact(int contactId) {
		Contact contact = this.getContactById(contactId);
		this.delContact(contact);
	}
	
	// ������ϵ��
	public ArrayList<Contact> searchContact(String mobileorname) {
		ArrayList<Contact> result = new ArrayList<Contact>();
		for (Contact contact : this.contacts) {
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
