package com.lec.ch11.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;

public class BContentService implements Service {

	@Override
	public void execute(Model model) {
		Map<String , Object> map = model.asMap();
		int bid = (Integer)map.get("bid"); // bid로 상세보기 니  컨트롤러에서  받아오기
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("bDto", boardDao.contentView(bid));

	}

}
