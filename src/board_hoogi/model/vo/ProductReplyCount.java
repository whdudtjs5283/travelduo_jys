package board_hoogi.model.vo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;

public class ProductReplyCount implements Serializable{
	private static final long serialVersionUID = 13334588L;
	
	private int boardnum;
	private String userid;
	private String btitle;
	private String bcontent;
	private Date boarddate;
	private String productnum;
	private String boardOriginalFileName;
	private String boardRenameFileName;
	private int hoogireadcount;
	private int replycount;
	
	public ProductReplyCount( ) {}

	public ProductReplyCount(int boardnum, String userid, String btitle, String bcontent, Date boarddate,
			String productnum, String boardOriginalFileName, String boardRenameFileName, int hoogireadcount,
			int replycount) {
		super();
		this.boardnum = boardnum;
		this.userid = userid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.boarddate = boarddate;
		this.productnum = productnum;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
		this.hoogireadcount = hoogireadcount;
		this.replycount = replycount;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public String getProductnum() {
		return productnum;
	}

	public void setProductnum(String productnum) {
		this.productnum = productnum;
	}

	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}

	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}

	public String getBoardRenameFileName() {
		return boardRenameFileName;
	}

	public void setBoardRenameFileName(String boardRenameFileName) {
		this.boardRenameFileName = boardRenameFileName;
	}

	public int getHoogireadcount() {
		return hoogireadcount;
	}

	public void setHoogireadcount(int hoogireadcount) {
		this.hoogireadcount = hoogireadcount;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.boardnum + ", " + this.userid+ ", " + this.btitle
				+ ", " + this.bcontent + ", " + this.bcontent
				+ ", " + this.boarddate+ ", " + this.productnum
				+ ", " + this.boardOriginalFileName + ", " + this.boardRenameFileName
				+ ", " + this.hoogireadcount + ", " + this.replycount;
		
	}

	
	

}
