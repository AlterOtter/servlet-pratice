package daoTest;

import VO.EmaillistVO;
import dao.emaillist_dao;

public class EmaillistDAOTest {

	public static void main(String[] args) {
		testInset();

	}
	
	private static void testInset() {
		EmaillistVO vo = EmaillistVO.Builder().first_name("권").last_name("순모").email("213@gmail.com").build();
		
		boolean result = new emaillist_dao().insert(vo);
		System.out.println("결과 : "+result);
	}
}
