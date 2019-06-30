package member.model.vo;

import java.io.Serializable;

public class Member implements Serializable{

	private static final long serialVersionUID= 8888L;

	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String phone;
	private int age;
	private String gender;

	

	public Member() {}



	public Member(String userId, String userName, String userPwd, String email, String phone, int age, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPwd() {
		return userPwd;
	}



	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return this.userId+","+this.userPwd+","+this.userName+","+this.phone
				+","+this.email+","+this.age+","+this.gender;
	}
	
}
