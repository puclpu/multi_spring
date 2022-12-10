package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BbsDAO {

	String url = "";
	String user = "";
	String password = "";
	Connection con;
	
	public BbsDAO() {
		try {
			// 1.드라이버(커넥터) 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.ok----------");
			
			// 2.DB연결(url, id, pw)
			url = "jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
			user = "scott";
			password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.ok----------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 게시글 작성
	public void insert(BbsDTO dto)  {
		System.out.println(dto);
		try {

		// 3.SQL문 결정/생성
		String sql = "insert into BBS values (null,?,?,?)"; //mysql에서 autoincrement면 그 자리에 null
//		String sql = "insert into bbs(title, content, writer) values (?,?,?)"; // oracle 문법
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getTitle());
		ps.setString(2, dto.getContent());
		ps.setString(3, dto.getWriter() );
		
		System.out.println("3.ok----------");

		// 4.DB로 SQL문 전송
		int result = ps.executeUpdate();
		System.out.println("4.ok----------" + result);
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
	}
	
	// 게시글 삭제
	public int delete(String id)  {
		int result = 0;
		try {
		
		// 3.SQL문 결정/생성
		String sql = "delete from bbs where id=?"; //mysql에서 autoincrement면 그 자리에 null
//		String sql = "insert into bbs(title, content, writer) values (?,?,?)"; // oracle 문법
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		System.out.println("3.ok----------");

		// 4.DB로 SQL문 전송
		result = ps.executeUpdate();
		System.out.println("4.ok----------");
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
		return result;

	}
	
	// 게시글 수정
	public int update(BbsDTO dto)  {
		int result = 0;
		try {
		
			// 3.SQL문 결정/생성
			String sql = "update bbs set title=?,content=? where id=?"; //mysql에서 autoincrement면 그 자리에 null
//		String sql = "insert into bbs(title, content, writer) values (?,?,?)"; // oracle 문법
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setInt(3, dto.getId());
			
			System.out.println("3.ok----------");
			
			// 4.DB로 SQL문 전송
			result = ps.executeUpdate();
			System.out.println("4.ok----------");
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
		return result;
		
	}
	
	// 리스트 전체 보기
	public ArrayList<BbsDTO> list() throws Exception {
		// 3.SQL문 결정/생성
		String sql = "select * from bbs order by id desc";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3.ok----------");

		// 4. sql문 mysql서버로 전송
		// 5. 검색결과를 ArrayList에 넣어서 return
		ArrayList<BbsDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { // true이면
			// rs내의 한 행씩 아래로 내려가면서 그 행에 결과가 들어있는지 체크
			// 내부적으로 한 행씩 가르키게 됨: 커서!
			// 가방을 하나 만들어서
			BbsDTO dto = new BbsDTO();
			dto.setId(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setWriter(rs.getString(4));

			// 가방을 list에 넣는다.
			list.add(dto);
		}
		return list;

	}

	// 리스트 중에서 선택한 물건 하나 보기
	public BbsDTO one(int id) throws Exception {
		// 3.SQL문 결정/생성
		String sql = "select * from bbs where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3.ok----------");
		ps.setInt(1, id);

		// 4. sql문 mysql서버로 전송
		ResultSet rs = ps.executeQuery();
		BbsDTO dto2 = new BbsDTO();
		if(rs.next()) { // true이면
			// rs내의 한 행씩 아래로 내려가면서 그 행에 결과가 들어있는지 체크
			// 내부적으로 한 행씩 가르키게 됨: 커서!
			// 가방을 하나 만들어서
			// 각 컬럼의 인덱스를 가지고 꺼내와서 가방에 넣는다.
			dto2.setId(rs.getInt(1));
			dto2.setTitle(rs.getString(2));
			dto2.setContent(rs.getString(3));
			dto2.setWriter(rs.getString(4));
		}
		return dto2;
	}
}