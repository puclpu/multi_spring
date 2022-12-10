package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

// 싱글톤은 미리 램에 만들어 두는 방법 : 자주 사용하지 않는다면 오히려 램에 무리가 되는 방식
// 자주 사용하느냐에 따라 싱글톤으로 만들지 말지를 결정

// 자바,서버 프로그램에서 싱글톤으로 만들어진 객체 : 컴포넌트
@Component // 스프링에 MemberDAO를 싱글톤으로 만들어서 준비해달라 명령
public class MemberDAO {
	String url = "";
	String user = "";
	String password = "";
	Connection con;

	public MemberDAO() {
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

	// 가입
	public int insert(MemberDTO dto) {
		int result = 0;

		try {
			// 3.SQL문 결정/생성
			String sql = "insert into member values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			System.out.println("3.ok----------");
			// 4.DB로 SQL문 전송
			result = ps.executeUpdate();
			System.out.println("4.ok----------");
		} catch (Exception e) {
			System.out.println("에러가 발생함.");
		}
		return result;
	}

	// 로그인
	public boolean login(MemberDTO dto) throws Exception {

		// 3.SQL문 결정/생성
		String sql = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		System.out.println("3.ok----------");

		// 4.DB로 SQL문 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4.ok----------");
		boolean result = false;
		if (rs.next()) {
			result = true;
		}
		return result;
	}

	// 탈퇴
	public int delete(String id) {
		int result = 0;
		try {
			// 3. sql문을 만든다
			String sql = "delete from MEMBER where id =?";
			// 준비된 문장(Prepared Statement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 1번 물음표에 id에 저장해놓은 것을 스트링으로 넣어줘!
			System.out.println("3. sql문 객체 생성 성공");

			// 4. sql문을 db서버에 보낸다 --> 결과가 어떻게 되었는지 자바프로그렘에 알려줌
			result = ps.executeUpdate(); // r의 결과는 table, cud는 숫자(실행된 row 수)
			System.out.println("4. sql문 db서버로 전송 성공. 반영 row 수 >> " + result);

			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 회원 1명 검색
	public MemberDTO one(String id) {
		MemberDTO bag = null;
		try {
			// 3. sql문을 만든다
			String sql = "select * from MEMBER where id =?";
			// 준비된 문장(Prepared Statement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 1번 물음표에 id에 저장해놓은 것을 스트링으로 넣어줘!
			System.out.println("3. sql문 객체 생성 성공");

			// 4. sql문을 db서버에 보낸다 --> 결과가 어떻게 되었는지 자바프로그렘에 알려줌
			ResultSet rs = ps.executeQuery(); // java.sql의 Resultset
			// ResultSet은 키와 값을 가지는 테이블 형태

//				System.out.println("4. sql문 db서버로 전송 성공. 반영 row 수 >> " + rs.next());
			// rs.next() true면 결과가 있음. false면 결과가 없음

			if (rs.next()) { // 결과값이 true면
				System.out.println("검색결과가 있음");
				String id2 = rs.getString(1); // 컬럼의 순서 1번 id값 추출
				String pw = rs.getString("pw");
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println("검색한 결과 >> " + id2 + " " + pw + " " + name + " " + tel);

				// ui에서 사용자가 검색한 결과를 볼 수 있어야 한다.
				// 4개의 데이터를 ui에게 return해주자
				// 1) 가방을 만들어서,
				bag = new MemberDTO();
				// 2) 데이터를 넣고
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				// 3) return하자.
			}
			// db처리와 관련된 메모리 할당된 것 해제시켜주자.
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bag;
	}
	
	public ArrayList<MemberDTO> list() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			// 3. sql문을 만든다
			String sql = "select * from MEMBER";
			// 준비된 문장(Prepared Statement)
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. sql문 객체 생성 성공");

			// 4. sql문을 db서버에 보낸다 --> 결과가 어떻게 되었는지 자바프로그렘에 알려줌
			ResultSet rs = ps.executeQuery(); // java.sql의 Resultset
			// ResultSet은 키와 값을 가지는 테이블 형태

//			System.out.println("4. sql문 db서버로 전송 성공. 반영 row 수 >> " + rs.next());
			// rs.next() true면 결과가 있음. false면 결과가 없음

			while (rs.next()) { // 결과값이 true면
				System.out.println("검색결과가 있음");
				String id = rs.getString(1); // 컬럼의 순서 1번 id값 추출
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);

				// ui에서 사용자가 검색한 결과를 볼 수 있어야 한다.
				// 4개의 데이터를 ui에게 return해주자
				// 1) 가방을 만들어서,
				MemberDTO bag = new MemberDTO();
				// 2) 데이터를 넣고
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				// 3) list에 넣자
				list.add(bag);
				System.out.println("list에 들어간 갯수>>" + list.size());
			}
			// db처리와 관련된 메모리 할당된 것 해제시켜주자.
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
