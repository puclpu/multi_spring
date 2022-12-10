package com.multi.mvc40;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {
	
	@Autowired
	MusicDAO dao;
	
	@RequestMapping("top100")
	public void chart(Model model) {
		List<MusicVO> list = dao.chart();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("one")
	public void one(MusicVO vo, Model model) {
		// music table의 hits++
		dao.update(vo);

		MusicVO result = dao.one(vo);
		model.addAttribute("vo", result);
	}
	
	@RequestMapping("puthit")
	public void up(MusicVO vo) {
		dao.update(vo);
	}
	
	
	// 검색창 메소드
	@RequestMapping("search")
	public void search(String search, Model model) {
		model.addAttribute("search", search); // 검색한 단어 model로 add
		List<MusicVO> list = dao.searchsinger(search); // 가수 검색
		model.addAttribute("list", list);
		List<MusicVO> list2 = dao.searchtitle(search); // 제목 검색
		model.addAttribute("list2", list2);
	}
	
}
