package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "D:\\webPro\\source\\08_Spring\\ch19_memberBookUp\\src\\main\\webapp\\bookImgFileUpload\\"; // 날라가지 않게 백업Path에 저장 webapp밑에폴더
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum, 3, 3); //(전체갯수 , 페이지넘) 실행화면 보면 페이지사이즈3 블락 3  (Paging.java 사이즈 디폴트 1010 해놨음 그래서 3 3 다시설정
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() { // 등록한 책 전체 갯수 
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) { // bnum으로 책 상세보기 
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) { // mRequest 파일에 대한 정보 , book Book dto
		//파일 업로드 로직
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1 , tempBimg2 
		String[] bimg = new String[2]; // 이미지 두개 들어오니 배열로 
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 생성 ! 
			bimg[idx] = mFile.getOriginalFilename(); // 맨처음에 첨부한 파일 이름 이걸 받아서 똑같은게 있으면 변경하고 없으면 그대로 
			if(bimg[idx]!=null && !bimg[idx].equals("")) { // 첨부함 
				if(new File(uploadPath + bimg[idx]).exists()){ // 서버에 같은 파일이름이 있을 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
					
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);// 백업 : 껐다가 켰을때 안사라지게
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx + "번째 백업성공" : idx +"번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				//파일 첨부 안 하면 bimg[idx] = ""  빈스트링이 들어감 
				//bimg[idx] = "";
			}//if
			idx ++;
		}// while
		book.setBimg1(bimg[0]); // 첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]); // 두번째 첨부한 파일 이름 
		return bookDao.registerBook(book); // DB insert
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1 , tempBimg2 
		String[] bimg = new String[2]; // 이미지 두개 들어오니 배열로 
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 생성 ! 
			bimg[idx] = mFile.getOriginalFilename(); // 맨처음에 첨부한 파일 이름 이걸 받아서 똑같은게 있으면 변경하고 없으면 그대로 
			if(bimg[idx]!=null && !bimg[idx].equals("")) { // 첨부함 
				if(new File(uploadPath + bimg[idx]).exists()){ // 서버에 같은 파일이름이 있을 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
					
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);// 백업 : 껐다가 켰을때 안사라지게
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx + "번째 백업성공" : idx +"번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				//파일 첨부 안 하면 bimg[idx] = ""  빈스트링이 들어감 
				//bimg[idx] = "";
			}//if
			idx ++;
		}// while - bimg에 배열에 파일이름 저장 
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1 , tempBimg2 
		String[] bimg = new String[2]; // 이미지 두개 들어오니 배열로 
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 생성 ! 
			bimg[idx] = mFile.getOriginalFilename(); // 맨처음에 첨부한 파일 이름 이걸 받아서 똑같은게 있으면 변경하고 없으면 그대로 
			if(bimg[idx]!=null && !bimg[idx].equals("")) { // 첨부함 
				if(new File(uploadPath + bimg[idx]).exists()){ // 서버에 같은 파일이름이 있을 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
					
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);// 백업 : 껐다가 켰을때 안사라지게
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx + "번째 백업성공" : idx +"번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				//파일 첨부 안 하면 bimg[idx] = ""  빈스트링이 들어감 
				//bimg[idx] = "";
			}//if
			idx ++;
		}// while - bimg에 배열에 파일이름 저장 
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
	}
	// fileCopy 메소드 ch13 에서 복붙
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		InputStream is = null; 
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
