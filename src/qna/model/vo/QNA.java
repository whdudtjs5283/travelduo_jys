package qna.model.vo;
import java.io.Serializable;
import java.sql.Date;

public class QNA implements Serializable {
	private static final long serialVersionUID = 6666L;
	
	private int qnaNo;
	private String qnaTitle;
	private Date qnaDate;
	private String qnaWriter;
	private String qnaContent;
	private int qnaReply;
	private int qnaRef;
	
	public QNA() {}

	public QNA(int qnaNo, String qnaTitle, Date qnaDate, 
			String qnaWriter, String qnaContent,
			int qnaReply, int qnaRef) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaWriter = qnaWriter;
		this.qnaContent = qnaContent;
		this.qnaReply = qnaReply;
	}

	public int getQNANo() {
		return qnaNo;
	}

	public void setQNANo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQNATitle() {
		return qnaTitle;
	}

	public void setQNATitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public Date getQNADate() {
		return qnaDate;
	}

	public void setQNADate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQNAWriter() {
		return qnaWriter;
	}

	public void setQNAWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public String getQNAContent() {
		return qnaContent;
	}

	public void setQNAContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	
	public int getQNAReply() {
		return qnaReply;
	}
	
	public void setQNAReply(int qnaReply) {
		this.qnaReply = qnaReply;
	}
	
	public int getQNARef() {
		return qnaRef;
	}
	
	public void setQNARef(int qnaRef) {
		this.qnaRef = qnaRef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.qnaNo + ", " + this.qnaTitle + ", "
			+ this.qnaWriter + ", " + this.qnaDate
			+ ", " + this.qnaContent + ", " 
			+ this.qnaReply + ", " + this.qnaRef;
	}
}