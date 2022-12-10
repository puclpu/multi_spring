package com.multi.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	
	@RequestMapping("movie")
	public String movie(String movie) {
		if (movie.equals("코미디")) {
			return "comic"; // comic이라는 string을 리턴 받은 스트링은 views 아래에 가서 comic.jsp를 자동호출
		} else if (movie.equals("드라마")) {
			return "drama";
		} else if (movie.equals("액션")) {
			return "action";
		} else
			return "no";
	}
}
