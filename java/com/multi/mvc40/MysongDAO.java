package com.multi.mvc40;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MysongDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void insert(MysongVO vo) {
		my.insert("mysong.insert", vo);
	}
	
}
