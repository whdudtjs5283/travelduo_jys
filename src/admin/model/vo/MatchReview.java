package admin.model.vo;

import java.io.Serializable;

public class MatchReview implements Serializable{

	private static final long serialVersionUID = 22314L;
	
	private String userName;
	private String email;
	private String phone;
	private String review;
	
	public MatchReview() {}

	public MatchReview(String userName, String email, String phone, String review) {
		super();
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.review = review;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MatchReview [userName=" + userName + ", email=" + email + ", phone=" + phone + ", review=" + review
				+ "]";
	}
	
	
}
