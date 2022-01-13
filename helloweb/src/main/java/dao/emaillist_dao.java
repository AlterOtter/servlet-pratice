package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import VO.EmaillistVO;

public class emaillist_dao {
	public boolean insert(EmaillistVO vo) {
		boolean result = true;
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `webdb`.`emaillist` (`first_name`, `last_name`, `email`) VALUES (?, ?, ?);");){
			pstmt.setString(1,vo.getFirst_name());
			pstmt.setString(2,vo.getLast_name());
			pstmt.setString(3,vo.getEmail());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return result;
	}
	
	

	public List<EmaillistVO> select() {
		List<EmaillistVO> volist = new ArrayList<>();
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("select * from emaillist order by no desc;");){
			ResultSet rs=pstmt.executeQuery();	
			while(rs.next()) {
				EmaillistVO vo = EmaillistVO.Builder()
						.no(rs.getInt("no"))
						.first_name(rs.getString("first_name"))
						.last_name(rs.getString("last_name"))
						.email(rs.getString("email"))
						.build();
				volist.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return volist;
	}
}
