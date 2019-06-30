package Match.vo;

import java.io.Serializable;
import java.sql.Date;

public class MatchMessage implements Serializable{
	private static final long serialVersionUID = 1233554L;
	
	private int Message_No;
	private String fromUser;
	private String toUser;
	private String content;
	private Date messageDate;
	private int messagereadcount;
	
	public MatchMessage() {}

	

	public MatchMessage(int message_No, String fromUser, String toUser, String content, Date messageDate,
			int messagereadcount) {
		super();
		Message_No = message_No;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.messageDate = messageDate;
		this.messagereadcount = messagereadcount;
	}



	public int getMessage_No() {
		return Message_No;
	}

	public void setMessage_No(int message_No) {
		Message_No = message_No;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
	

	public int getMessagereadcount() {
		return messagereadcount;
	}



	public void setMessagereadcount(int messagereadcount) {
		this.messagereadcount = messagereadcount;
	}



	@Override
	public String toString () {
	
		return this.Message_No + ", " + this.fromUser
				+ ", " + this.toUser+ ", " +this.content + "," 
				+ this.messageDate + ", " + this.messagereadcount;
	}
			  
	
}
