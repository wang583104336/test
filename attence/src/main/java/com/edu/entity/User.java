package com.edu.entity;

public class User {
	
    private Integer id;
    private String uname;
    private String password;
    private Integer phone;
    private Integer cardno;
    private String realname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getCardno() {
		return cardno;
	}

	public void setCardno(Integer cardno) {
		this.cardno = cardno;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
   
}