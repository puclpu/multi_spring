package com.multi.mvc01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingController {

	@Autowired
	SingDAO dao;
	
	@RequestMapping("insert4.multi")
	public void insert(SingDTO dto) {
		dao.insert(dto);
	}
	
	@RequestMapping("delete4.multi")
	public String delete(String title) {
		int result = dao.delete(title);
		if (result == 1) {
			return "delete4"; // 성공
		} else {
			return "no"; // 실패
		}
	}
	
	@RequestMapping("update4.multi")
	public String update(SingDTO dto) {
		int result = dao.update(dto);
		if (result == 1) {
			return "update4";
		} else {
			return "no";
		}
	}
	
	@RequestMapping("one")
	public void one(String id, Model model) {
		int id2 = Integer.parseInt(id);
		SingDTO dto = dao.one(id2);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("list4")
	public void list(Model model) {
		ArrayList<SingDTO> list = dao.list();
		model.addAttribute("list", list);
	}
}
