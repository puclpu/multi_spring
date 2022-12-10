package com.multi.mvc40;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MysongController {
	
	@Autowired
	MysongDAO dao;
	
	@RequestMapping("putmysong")
	public void insert(MysongVO vo) {
		dao.insert(vo);
	}
	
}
