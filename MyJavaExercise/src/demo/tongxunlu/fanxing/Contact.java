package demo.tongxunlu.fanxing;
/**
 * 联系人 类
 * @author Frank
 *
 */
public class Contact {
	private int id;			//主键id通常设计为int类型
	private String name;
	private String mobile;
	private String email;
	private String birthday;
	private String addr;
	//外键一般推荐设计为对象，更加面向对象
//	private int groupId;	//基于构建数据库设计
	private Group group;	//更加面向对象的方式设计
	
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
		System.out.println(this.mobile+"打电话给"+toMobile);
	}
	
	public void sendSms(String toMobile){
		System.out.println(this.mobile+"发短信给"+toMobile);
	}
	
	public void sendEmail(String toEmail){
		System.out.println(this.email+"发Email给"+toEmail);
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", birthday=" + birthday + ", addr="
				+ addr + ", group=" + group + "]";
	}
	
	
	
}
