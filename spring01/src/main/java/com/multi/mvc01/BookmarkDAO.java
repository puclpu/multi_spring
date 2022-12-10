package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BookmarkDAO {

	String url = "";
	String user = "";
	String password = "";
	Connection con;

	public BookmarkDAO() {
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

	// 북마크 등록
	public void insert(BookmarkDTO dto) {

		try {
			// 3.SQL문 결정/생성
			String sql = "insert into BOOKMARK values (null,?,?,?)"; // mysql에서 autoincrement면 그 자리에 null
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getUrl());
			ps.setString(3, dto.getImg());

			System.out.println("3.ok----------");

			// 4.DB로 SQL문 전송
			int result = ps.executeUpdate();
			System.out.println("4.ok----------" + result);
		} catch (Exception e) {
			System.out.println("에러가 발생함.");
		}
	}

	// 북마크 삭제
	public void delete(int id) {

		try {

			// 3.SQL문 결정/생성
			String sql = "delete from BOOKMARK where id=?"; // mysql에서 autoincrement면 그 자리에 null
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			System.out.println("3.ok----------");

			// 4.DB로 SQL문 전송
			int result = ps.executeUpdate();
			System.out.println("4.ok----------" + result);
		} catch (Exception e) {
			System.out.println("에러가 발생함.");
		}
	}

	// 북마크 전체 검색
	public ArrayList<BookmarkDTO> list() {

		ArrayList<BookmarkDTO> list = new ArrayList<BookmarkDTO>();
		BookmarkDTO dto = null;
		try {
			// 3.SQL문 결정/생성
			String sql = "select * from BOOKMARK order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.ok----------");

			ResultSet rs = ps.executeQuery();
			System.out.println("4.ok----------");
			while (rs.next()) {
				dto = new BookmarkDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setUrl(rs.getString(3));
				dto.setImg(rs.getString(4));

				// 가방을 list에 넣는다.
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	// 북마크 하나 검색
	public BookmarkDTO one(int id){
		BookmarkDTO dto = null;
		try {
			// 3.SQL문 결정/생성
			String sql = "select * from BOOKMARK where id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.ok----------");
			ps.setInt(1, id);

			// 4. sql문 mysql서버로 전송
			ResultSet rs = ps.executeQuery();
			dto = new BookmarkDTO();
			if(rs.next()) {
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setUrl(rs.getString(3));
				dto.setImg(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
