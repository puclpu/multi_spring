package com.multi.mvc40;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

@Component
public class MusicDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public List<MusicVO> chart() {
		return my.selectList("music.chart");
	}

	public MusicVO one(MusicVO vo) {
		return my.selectOne("music.one", vo);
	}

	public void update(MusicVO vo) {
		my.update("music.update", vo);
	}

	
	// 검색창 메소드
	// 가수 검색
	public List<MusicVO> searchsinger(String singer) {
		return my.selectList("music.searchsinger", singer);
	}

	// 제목 검색
	public List<MusicVO> searchtitle(String title) {
		return my.selectList("music.searchtitle", title);
	}

	
}
