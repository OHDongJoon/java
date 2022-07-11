package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//insert 로직(DAO 생성 -request.getP~ 파라미터 받아 dto 객체 생성 - dao.insert 호출
		int result = 1;  // 결과가 1이나 0 
		request.setAttribute("insertResult", result);  // 이걸  실행 하면 함수가 호출되고 FrontController간다 
	}

}
