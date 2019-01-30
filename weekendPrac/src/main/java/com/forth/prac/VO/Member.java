package com.forth.prac.VO;

public class Member {
	  private String memberseq;
	  private String id;
	  private String pw;
	  private String name;
	  private int age;
	  private int grade;
	public Member(String memberseq, String id, String pw, String name, int age, int grade) {
		super();
		this.memberseq = memberseq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public Member() {
		super();
	}
	public String getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Member [memberseq=" + memberseq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age
				+ ", grade=" + grade + "]";
	}
	
	  
}
