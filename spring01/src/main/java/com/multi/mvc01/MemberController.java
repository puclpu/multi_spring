package com.multi.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에 컨트롤러 역할을 하는 클래스라고 등록
public class MemberController {
	
	// 이미 만들어서 준비된 MemberDAO 객체의 주소를 찾아서
	// 그 주소를 아래의 변수인 dao에 넣어주세요!
	@Autowired 
	MemberDAO dao;
	
	// 처리 하나 당 서버의 컨트롤러 함수 하나
	
	//회원가입처리
	@RequestMapping("insert.multi") // insert.multi를 요청하면 insert()호출
	public void insert(MemberDTO bag, MemberDAO dao) { // 어느 dto에 넣어서 받아올지 지정만 해주면 알아서 처리
		System.out.println("클라이언트 회원가입 처리 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		
		// DAO를 이용해서 db처리를 해보자.
		// 메서드의 변수로 선언해주면, 스프링이 프로토타입으로 만들어서 준다
		dao.insert(bag);
	}
	//로그인처리
	@RequestMapping("login.multi")
	public String login(MemberDTO bag) throws Exception { 
		// MemberDTO는 넘어온 name과 동일한 id를 찾고 setId를 자동호출함
		// name값과 DTO의 변수명이 동일해야 함!
		System.out.println("클라이언트 로그인 처리 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		
//		String id2 = "root";
//		String pw2 = "1234";
//		// 페이지가 무조건 login.jsp로 가는 것이 아닌 성공 여부에 따라 다른 jsp로 가도록
//		if (id2.equals(bag.getId()) && pw2.equals(bag.getPw())) {
//			// 로그인 성공 --> ok.jsp
//			return "ok";
//		} else {
//			// 로그인 실해 --> no.jsp
//			// return "no";
//			// 실패했을 때, webapp 아래에 있는 member.jsp를 다시 호출하려고 하면
//			// webapp아래 jsp는 클라이언트(브라우저)가 호출하는 브라우저이므로
//			// 서버가 브라우저에게 member.jsp를 호출하라고 하면 됨
//			return "redirect:member.jsp";
//		}
		boolean success = dao.login(bag);
		if (success) {
			return "ok";
		} else {
			return "no";
		}
	}
	//회원탈퇴처리
	@RequestMapping("delete.multi")
	public String delete(String id) {
//		// 파라메터 전달 값과 받는 값의 이름이 다르면
//		// delete(@RequestParam("id") String writer)
//		System.out.println("클라이언트 회원탈퇴 처리 요청됨");
//		System.out.println("받은 아이디는 " + id);
//		// 결과를 담는 페이지로 넘어가게 되어있음
//		// /WEB-INF/views/delete.jsp 자동호출
		int result = dao.delete(id);
		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
	}
	//회원수정처리
	//전체회원정보처리
	//회원정보처리
}
