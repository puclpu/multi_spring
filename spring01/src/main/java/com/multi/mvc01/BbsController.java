package com.multi.mvc01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BbsController {
	
	@Autowired
	BbsDAO dao;
	
	// 글 작성
	@RequestMapping("insert2.multi") 
	public void insert(BbsDTO dto) { 
		System.out.println(dto);
		dao.insert(dto);
	}
	
	@RequestMapping("delete2.multi")
	public String delete(String id) {
		int result = dao.delete(id);
		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
	}
	
	@RequestMapping("one2.multi")
	public void one(int id, Model model) throws Exception {
		BbsDTO dto = dao.one(id);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("list2.multi")
	public void list(Model model) throws Exception {
		ArrayList<BbsDTO> list = dao.list();
		model.addAttribute("list", list);
	}
}
