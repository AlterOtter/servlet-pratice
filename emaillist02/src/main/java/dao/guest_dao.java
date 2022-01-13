package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.GuestbookVO;

public class guest_dao {
	public boolean insert(GuestbookVO vo) {
		boolean result = true;
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `webdb`.`guestbook` (`name`, `password`, `message`, `reg_date`) VALUES (?, ?, ?, now());");){
			pstmt.setString(1,vo.getname());
			pstmt.setString(2,vo.getpassword());
			pstmt.setString(3,vo.getmessage());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return result;
	}
	
	

	public List<GuestbookVO> select() {
		List<GuestbookVO> volist = new ArrayList<>();
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("select * from guestbook order by no desc;");){
			ResultSet rs=pstmt.executeQuery();	
			while(rs.next()) {
				GuestbookVO vo = GuestbookVO.Builder()
						.no(rs.getInt("no"))
						.name(rs.getString("name"))
						.password(rs.getString("password"))
						.message(rs.getString("message"))
						.reg_date(rs.getString("reg_date"))
						.build();
				volist.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return volist;
	}
	
	public List<GuestbookVO> delete(GuestbookVO vo) {
		List<GuestbookVO> volist = new ArrayList<>();
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM `webdb`.`guestbook` WHERE (`no` = ? and `password`=?);");){
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getpassword());
			pstmt.executeUpdate();	
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return volist;
	}
}
