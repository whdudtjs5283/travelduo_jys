package matchinfo.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import matchinfo.model.vo.MatchInfo;
import qna.model.vo.QNA;

public class MatchInfoDao {

	public int insertMatchInfo(Connection conn, MatchInfo minfo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into match_info values (seq_matchinfo.nextval,?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, minfo.getMatchArea());
			pstmt.setString(2, minfo.getMatchCity());
			pstmt.setString(3, minfo.getMatchYear());
			pstmt.setString(4, minfo.getMatchMonth());
			pstmt.setString(5, minfo.getMatchPlan());
			pstmt.setString(6, minfo.getMatchPrivate());
		    pstmt.setString(7, minfo.getMatchPhoto());
		    pstmt.setString(8, minfo.getUserId());
	
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public MatchInfo selectLogin(
			Connection conn, String matchPrivate) {
			MatchInfo matchState = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null; //셀렉트문을 쓸거니까
			System.out.println("matchPrivate dao : " + matchPrivate);
			String query = "select * from matchinfo where matchprivate = ?"; //멤버 테이블에서 조회해오기
			
			try {
				pstmt = conn.prepareStatement(query); //prepareStatement로 쿼리문 생성
				pstmt.setString(1, matchPrivate); //값 적용
				
				rset = pstmt.executeQuery(); //셀렉트 쿼리문이니 executeQuery사용
				
				
				if(rset.next()) { //rset이 제목행을 가르키니까 next로 한칸 내림.
					matchState = new MatchInfo();
					//컬럼값 저장. 필드에 값 넣어줌
					matchState.setMatchArea(rset.getString("matcharea")); //rset이 참조하고 있는 위치의 sql 컬럼값 추출
					matchState.setMatchCity(rset.getString("matchcity"));
					matchState.setMatchYear(rset.getString("matchyear"));
					matchState.setMatchMonth(rset.getString("matchmonth"));
					matchState.setMatchPlan(rset.getString("matchplan"));
					matchState.setMatchPrivate(matchPrivate);
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset); 
				close(pstmt);
			}
			
			return matchState;
		}

	public int updateMatchInfo(Connection conn, MatchInfo minfo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update match_info "
				+ "set matcharea = ?, matchcity = ?, "
				+ "matchyear = ?, matchmonth = ?, matchplan = ?, "
				+ "matchprivate = ?";
		
		try {			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, minfo.getMatchArea());
			pstmt.setString(2, minfo.getMatchCity());
			pstmt.setString(3, minfo.getMatchYear());
			pstmt.setString(4, minfo.getMatchMonth());
			pstmt.setString(5, minfo.getMatchPlan());
			pstmt.setString(6, minfo.getMatchPrivate());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<MatchInfo> selectList(Connection conn, String user) {
			ArrayList<MatchInfo> list = 
					new ArrayList<MatchInfo>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
					
			String query = "select * from match_info where userid = ? order by matchnum desc";
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, user);
				rset = pstmt.executeQuery();
				
				
				while(rset.next()) {
					MatchInfo matchInfo= new MatchInfo();
					
					matchInfo.setMatchNum(rset.getInt("matchnum"));
					matchInfo.setMatchArea(rset.getString("matcharea"));
					matchInfo.setMatchCity(rset.getString("matchcity"));
					matchInfo.setMatchYear(rset.getString("matchyear"));
					matchInfo.setMatchMonth(rset.getString("matchmonth"));
					matchInfo.setMatchPlan(rset.getString("matchplan"));
					matchInfo.setMatchPrivate(rset.getString("matchprivate"));
					matchInfo.setMatchPhoto(rset.getString("matchphoto"));
					matchInfo.setUserId(rset.getString("userid"));
					
					list.add(matchInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
	}

	public int deleteMatchInfo(Connection conn, int matchInfoNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from match_info "
				+ "where matchnum = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchInfoNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<MatchInfo> selectSearchAreaList(Connection conn, String matchArea, int currentPage, int limit) {
		ArrayList<MatchInfo> list = new ArrayList<MatchInfo>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, MATCHAREA, " + 
				"MATCHCITY, MATCHYEAR, " + 
				"MATCHMONTH, " + 
				"MATCHPLAN, MATCHPRIVATE, " + 
				"MATCHPHOTO, USERID, " + 
				"FROM (SELECT * FROM MATCH_INFO where matchArea like ? " + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + matchArea + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MatchInfo ms = new MatchInfo();
			
				ms.setMatchArea(rset.getString("matchArea"));
				ms.setMatchCity(rset.getString("matchCity"));
				ms.setMatchYear(rset.getString("matchYear"));
				ms.setMatchMonth(rset.getString("matchMonth"));
				ms.setMatchPlan(rset.getString("matchPlan"));
				ms.setMatchPrivate(rset.getString("matchPrivate"));
				ms.setMatchPhoto(rset.getString("matchPhoto"));
				ms.setUserId(rset.getString("userId"));
			
				
				list.add(ms);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<MatchInfo> profileMatch(Connection conn, String matchArea, String matchYear) {
		 ArrayList<MatchInfo> list = new ArrayList<MatchInfo>();
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         String query ="select * from match_info where matchprivate = 'T' and matcharea like ? and matchyear like ?";
               
               try {
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%" + matchArea + "%");
                  pstmt.setString(2, "%" + matchYear + "%");
                  
                  
                  rset = pstmt.executeQuery();
                  
                  
                  while(rset.next()) {
                     MatchInfo profile = new MatchInfo();
                     
                     profile.setMatchNum(rset.getInt("matchnum"));
                     profile.setMatchArea(rset.getString("matcharea"));
                     profile.setMatchCity(rset.getString("matchcity"));
                     profile.setMatchYear(rset.getString("matchyear"));
                     profile.setMatchMonth(rset.getString("matchmonth"));
                     profile.setMatchPlan(rset.getString("matchplan"));
                     profile.setMatchPrivate(rset.getString("matchprivate"));
                     profile.setMatchPhoto(rset.getString("matchphoto"));
                     profile.setUserId(rset.getString("userid"));

                     list.add(profile);
                  }
                  
               } catch (Exception e) {
                  e.printStackTrace();
               }finally {
                  close(rset);
                  close(pstmt);
               }
               
               return list;
      }

	public MatchInfo selectOne(Connection conn, int matchNum) {
		MatchInfo matchInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from match_info where matchnum = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				matchInfo = new MatchInfo();
				
				matchInfo.setMatchNum(matchNum);
				matchInfo.setMatchArea(rset.getString("matcharea"));
				matchInfo.setMatchCity(rset.getString("matchcity"));
				matchInfo.setMatchYear(rset.getString("matchyear"));
				matchInfo.setMatchMonth(rset.getString("matchmonth"));
				matchInfo.setMatchPlan(rset.getString("matchplan"));
				matchInfo.setMatchPrivate(rset.getString("matchprivate"));
				matchInfo.setMatchPhoto(rset.getString("matchphoto"));
				matchInfo.setUserId(rset.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return matchInfo;
	}
	public MatchInfo selectMatchinfo(Connection conn, String fromUserID) {
		MatchInfo matchInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from match_info where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, matchNum);
			pstmt.setString(1, fromUserID);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				matchInfo = new MatchInfo();
				
				matchInfo.setMatchNum(rset.getInt("matchnum"));
				matchInfo.setMatchArea(rset.getString("matcharea"));
				matchInfo.setMatchCity(rset.getString("matchcity"));
				matchInfo.setMatchYear(rset.getString("matchyear"));
				matchInfo.setMatchMonth(rset.getString("matchmonth"));
				matchInfo.setMatchPlan(rset.getString("matchplan"));
				matchInfo.setMatchPrivate(rset.getString("matchprivate"));
				matchInfo.setMatchPhoto(rset.getString("matchphoto"));
				matchInfo.setUserId(rset.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return matchInfo;
	}

}
