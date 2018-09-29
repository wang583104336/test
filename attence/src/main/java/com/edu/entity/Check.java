package com.edu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Check {
	
	private Integer id;
	private Integer fcheck;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date fcreatetime;
	private Integer lcheck;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date lcreatetime;
	private String uname;
	private Integer uid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFcheck() {
		return fcheck;
	}
	public void setFcheck(Integer fcheck) {
		this.fcheck = fcheck;
	}
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
	public Date getFcreatetime() {
		return fcreatetime;
	}
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
	public void setFcreatetime(Date fcreatetime) {
		this.fcreatetime = fcreatetime;
	}
	public Integer getLcheck() {
		return lcheck;
	}
	public void setLcheck(Integer lcheck) {
		this.lcheck = lcheck;
	}
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
	public Date getLcreatetime() {
		return lcreatetime;
	}
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
	public void setLcreatetime(Date lcreatetime) {
		this.lcreatetime = lcreatetime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	
	
}
