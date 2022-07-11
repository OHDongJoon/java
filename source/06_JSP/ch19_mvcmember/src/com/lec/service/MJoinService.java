package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberdao.MemberDao;
import com.lec.memberdto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024; // 사진 업로드 제한 용량
		String mphoto = "";// 첨부된 파일이 저장된 파일 이름

		try {
			// mRequest 객체 생성 후 mphoto 파일이름 얻어옴
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			// while(params.hasMoreElements()) {
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);

			// }
			// mRequest을 이용하여 파라미터 받아와서 DB 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto == null ? "NOIMG.JPG" : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if (!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = request.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			// mid 중복체크
			int result = mDao.confirmId(mid); // dao 아이디 중복체크 함수 호출
			if (result == MemberDao.NONEXISTENT) {// 가입 가능한 mid니까 회원가입
				MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				// 회원가입
				result = mDao.joinMember(member);
				if (result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession(); // 세션은 request로 부터
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료 되었습니다");
				} else {
					request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
				}
			} else {
				request.setAttribute("joinErrorMsg", "중복된 id는 회원가입이 불가합니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 서버에 업로드된 파일을 소스폴더로 복사
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG")) { // serverFile이 있으면서 NOIMG.JPG가 아닌애일때
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);// 파일을 읽어올때
				os = new FileOutputStream("D:\\webPro\\source\\06_JSP\\ch19_mvcmember\\WebContent\\memberPhotoUp\\" + mphoto); // 파일을 쏴?
				byte[] bs = new byte[(int) serverFile.length()]; // 바이트 있는거 만큼 읽어오고 
				while (true) { // 
					int readByteCnt = is.read(bs); 
					if (readByteCnt == -1) // 끝까지가면 break ; 만나서 
						break; 
					os.write(bs, 0, readByteCnt);  // bs 0번 방부터 readByteCnt 까지 출력 ?
				}
			} catch (IOException e) {

			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					// TODO: handle exception
				}

			}
		}

	}
}
