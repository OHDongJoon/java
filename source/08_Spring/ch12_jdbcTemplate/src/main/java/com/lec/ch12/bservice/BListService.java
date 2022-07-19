package com.lec.ch12.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(Model model) {
		// model에 getAttribute 없기 때문에
		// Map 사용   인덱스가 없음 키값 , 밸류
		// Map 예)
		// HashMap<String , String > 
		// hashMap.put("11" , "str11"); // 11key값에 매핑되는 데이터 "str11" 추가 
		// HashMap<키값 , 벨류 > 
		// 컨트롤러에서 pageNUm 받는데 널일수도있다 
		Map<String, Object> map = model.asMap(); // model을 Map화 , asMap : Map<String, Object>
		//model.addAttribute("pageNum" , null) pageNum이 String 이니 형변환
		String pageNum =(String)map.get("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("boardList" , boardDao.boardList(startRow, endRow));
		int orderNum = startRow; // 출력될 순차번호(1,2,3 순) 을 위해 사용
		int totCnt = boardDao.getBoardTotCnt(); //전체 글 갯수 
		int inverseNum = totCnt - startRow + 1 ; //출력될 역순번호 (10, 9 , 8 순)
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage - 1)/BLOCKSIZE ) * BLOCKSIZE +1;
		startPage = currentPage - (currentPage-1)%BLOCKSIZE;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("orderNum" , orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("pageCnt",pageCnt);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("BLOCKSIZE",BLOCKSIZE);
		model.addAttribute("pageNum",currentPage);
		
	}

}










