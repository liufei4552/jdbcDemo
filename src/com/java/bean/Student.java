package com.java.bean;

//实体类：和数据表名相同
public class Student {
//	对应数据库字段的名
	private int id;
	private String name;
	private String pwd;
	private int cid;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", pwd=" + pwd + ", cid=" + cid + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String pwd, int cid) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.cid = cid;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
}
