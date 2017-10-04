package demo.tongxunlu.wufanxingjihe;

import java.util.ArrayList;

/**
 * 组管理类
 * 
 * @author Frank
 *
 */
public class GroupMgr {
	private ArrayList groups;
	
	public GroupMgr(){
		groups= new ArrayList();
	}
	
	public Group getGroupById(int groupId) {
		for (Object obj : this.groups) {
			Group group = (Group) obj;
			if (group.getId() == groupId) {
				return group;
			}
		}
		return null;
	}
	
	public ArrayList getAllGroup() {
		return this.groups;
	}

	public void addGroup(Group group) {
		this.groups.add(group);
	}

	public void addGroup(int id, String name, String desc) {
		Group group = new Group(id, name, desc);
		this.addGroup(group);
	}

	public void delGroup(Group group) {
		this.groups.remove(group);
	}

	public void delGroup(int groupId) {
		Group group = this.getGroupById(groupId);
		this.delGroup(group);
	}

	public void updateGroup(Group group) {
		int index = -1;
		for (int i = 0; i < this.groups.size(); i++) {
			Group _group = (Group) this.groups.get(i);
			if (_group.getId() == group.getId()) {
				index = i;
				break;
			}
		}

		this.groups.set(index, group);
	}

	public void updateGroup(int id, String name, String desc) {
		Group group = this.getGroupById(id);
		group.setName(name);
		group.setDesc(desc);
		this.updateGroup(group);
	}
}
