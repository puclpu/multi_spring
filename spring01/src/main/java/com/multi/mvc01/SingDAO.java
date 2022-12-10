package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class SingDAO {

	String url = "";
	String user = "";
	String password = "";
	Connection con;
	
	public SingDAO() {
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
	
	// 노래 등록
	public void insert(SingDTO dto)  {
		System.out.println(dto);
		try {

		// 3.SQL문 결정/생성
		String sql = "insert into SING values (null,?,?,?)"; //mysql에서 autoincrement면 그 자리에 null
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getTitle());
		ps.setString(2, dto.getSinger());
		ps.setString(3, dto.getWriter());
		
		System.out.println("3.ok----------");

		// 4.DB로 SQL문 전송
		int result = ps.executeUpdate();
		System.out.println("4.ok----------" + result);
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
	}
	
	// 노래 삭제
	public int delete(String title)  {
		int result = 0;
		try {
		
		// 3.SQL문 결정/생성
		String sql = "delete from SING where title=?"; //mysql에서 autoincrement면 그 자리에 null
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		
		System.out.println("3.ok----------");

		// 4.DB로 SQL문 전송
		result = ps.executeUpdate();
		System.out.println("4.ok----------");
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
		return result;

	}
	
	// 노래 수정
	public int update(SingDTO dto)  {
		int result = 0;
		try {
		
			// 3.SQL문 결정/생성
			String sql = "update SING set title=?,singer=?,writer=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getSinger());
			ps.setString(3, dto.getWriter());
			ps.setInt(4, dto.getId());
			
			System.out.println("3.ok----------");
			
			// 4.DB로 SQL문 전송
			result = ps.executeUpdate();
			System.out.println("4.ok----------");
		}catch(Exception e) {
			System.out.println("에러가 발생함.");
		}
		return result;
		
	}

	// 노래 검색
	public SingDTO one(int id){
		SingDTO dto = null;
		try {
			// 3.SQL문 결정/생성
			String sql = "select * from SING where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.ok----------");
			ps.setInt(1, id);

			// 4. sql문 mysql서버로 전송
			ResultSet rs = ps.executeQuery();
			dto = new SingDTO();
			if(rs.next()) {
				dto.setId(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setSinger(rs.getString(3));
				dto.setWriter(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 노래 목록 검색
	public ArrayList<SingDTO> list() {
		
		ArrayList<SingDTO> list = new ArrayList<SingDTO>();
		SingDTO dto = null;
		try {
			// 3.SQL문 결정/생성
			String sql = "select * from SING order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.ok----------");

			ResultSet rs = ps.executeQuery();
			System.out.println("4.ok----------");
			while (rs.next()) {
				dto = new SingDTO();
				dto.setId(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setSinger(rs.getString(3));
				dto.setWriter(rs.getString(4));

				// 가방을 list에 넣는다.
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
}
