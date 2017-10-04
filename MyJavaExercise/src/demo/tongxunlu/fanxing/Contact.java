package demo.tongxunlu.fanxing;
/**
 * ��ϵ�� ��
 * @author Frank
 *
 */
public class Contact {
	private int id;			//����idͨ�����Ϊint����
	private String name;
	private String mobile;
	private String email;
	private String birthday;
	private String addr;
	//���һ���Ƽ����Ϊ���󣬸����������
//	private int groupId;	//���ڹ������ݿ����
	private Group group;	//�����������ķ�ʽ���
	
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Contact(){
		
	}

	public Contact(int id, String name, String mobile, String email,
			String birthday, String addr, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.birthday = birthday;
		this.addr = addr;
		this.group = group;
	}

	public void call(String toMobile){
		System.out.println(this.mobile+"��绰��"+toMobile);
	}
	
	public void sendSms(String toMobile){
		System.out.println(this.mobile+"�����Ÿ�"+toMobile);
	}
	
	public void sendEmail(String toEmail){
		System.out.println(this.email+"��Email��"+toEmail);
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", birthday=" + birthday + ", addr="
				+ addr + ", group=" + group + "]";
	}
	
	
	
}
