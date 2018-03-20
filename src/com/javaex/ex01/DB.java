package com.javaex.ex01;

public class DB {

	private String name;
	private String num;
	private String company;

	public DB(String name, String num, String company) {
		super();
		this.name = name;
	    this.num = num;
		this.company = company;
	}

	public void showinfo() {

		System.out.println("이름:" + name + "번호:" + num + "회사:" + company);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
