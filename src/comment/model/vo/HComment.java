package comment.model.vo;

import java.io.Serializable;

public class HComment implements Serializable{
	private static final long serialVersionUID = 2141225L;
	
	private int COMMENT_NUM;
	private int BOARD_NUM;
	private String userid;
	private String userpwd;
	private String HCOMMENT_CONTENT;
	
	public HComment() {}

	public int getCOMMENT_NUM() {
		return COMMENT_NUM;
	}

	public void setCOMMENT_NUM(int cOMMENT_NUM) {
		COMMENT_NUM = cOMMENT_NUM;
	}

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getHCOMMENT_CONTENT() {
		return HCOMMENT_CONTENT;
	}

	public void setHCOMMENT_CONTENT(String hCOMMENT_CONTENT) {
		HCOMMENT_CONTENT = hCOMMENT_CONTENT;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.COMMENT_NUM + "," + this.BOARD_NUM
				+ "," + this.userid+ "," + this.userpwd
				+ "," + this.HCOMMENT_CONTENT;
	}

}
