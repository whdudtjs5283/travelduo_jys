package matchinfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MatchInfo implements Serializable {

	private static final long serialVersionUID = -7561264699998249771L;
	
	private int matchNum;
	private String matchArea;
	private String matchCity;
	private String matchYear;
	private String matchMonth;
	private String matchPlan;
	private String matchPrivate;
	private String matchPhoto;
	private String userId;
	
	
	public MatchInfo() {}


	public MatchInfo(int matchNum, String matchArea, String matchCity, String matchYear, String matchMonth, String matchPlan,
			String matchPrivate, String matchPhoto, String userId) {
		super();
		this.matchNum = matchNum;
		this.matchArea = matchArea;
		this.matchCity = matchCity;
		this.matchYear = matchYear;
		this.matchMonth = matchMonth;
		this.matchPlan = matchPlan;
		this.matchPrivate = matchPrivate;
		this.matchPhoto = matchPhoto;
		this.userId = userId;
	}

	public int getMatchNum() {
		return matchNum;
	}
	
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	
	public String getMatchArea() {
		return matchArea;
	}


	public void setMatchArea(String matchArea) {
		this.matchArea = matchArea;
	}


	public String getMatchCity() {
		return matchCity;
	}


	public void setMatchCity(String matchCity) {
		this.matchCity = matchCity;
	}


	public String getMatchYear() {
		return matchYear;
	}


	public void setMatchYear(String matchYear) {
		this.matchYear = matchYear;
	}


	public String getMatchMonth() {
		return matchMonth;
	}


	public void setMatchMonth(String matchMonth) {
		this.matchMonth = matchMonth;
	}


	public String getMatchPlan() {
		return matchPlan;
	}


	public void setMatchPlan(String matchPlan) {
		this.matchPlan = matchPlan;
	}


	public String getMatchPrivate() {
		return matchPrivate;
	}


	public void setMatchPrivate(String matchPrivate) {
		this.matchPrivate = matchPrivate;
	}


	public String getMatchPhoto() {
		return matchPhoto;
	}


	public void setMatchPhoto(String matchPhoto) {
		this.matchPhoto = matchPhoto;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MatchInfo [matchNum=" + matchNum + " , matchArea=" + matchArea + ", matchCity=" + matchCity + ", matchYear=" + matchYear
				+ ", matchMonth=" + matchMonth + ", matchPlan=" + matchPlan + ", matchPrivate=" + matchPrivate
				+ ", matchPhoto=" + matchPhoto + ", userId=" + userId + "]";
	}

	
	
	


}
