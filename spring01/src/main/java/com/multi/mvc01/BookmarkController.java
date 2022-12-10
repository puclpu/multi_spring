package com.multi.mvc01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BookmarkController {
	
	// 이미 ram에 만들어서 저장해놓은 주소를 찾아서(wired) 자동으로 아래 변수에 그 주소를 넣어라!
	@Autowired
	BookmarkDAO dao;
	
	@RequestMapping("insert3.multi")
	public void insert(BookmarkDTO dto) {
		dao.insert(dto);
	}
	
	@RequestMapping("delete3.multi")
	public void delete(int id) {
		dao.delete(id);
	}
	
	@RequestMapping("one3.multi")
	public void one(int id, Model model) {
		BookmarkDTO dto = dao.one(id); // orm에 의해 dto로 return
		// model의 속성으로 지정하면, views아래까지 전달이 된다!
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("list3.multi")
	public void list(Model model) {
		ArrayList<BookmarkDTO> list = dao.list();
		// list.jsp를 호출, 결과는 list를 전달해야 함.
		// 전달하고 싶으면, model객체의 속성으로 추가하자.
		model.addAttribute("list", list);
	}
}

// 싱글톤으로 사용할 클래스는 표시해주어야 함
// controller역할을 하는 클래스
// 이 클래스를 컨트롤러로 스프링 프로그램에 등록
// + 싱글톤으로 만들어 준비
// --> Controller