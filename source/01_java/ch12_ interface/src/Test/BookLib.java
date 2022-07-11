package Test;


public class BookLib extends BookInfo implements ILendable2 {
	private String borrower;
	private String checkoutDate;
	private byte state;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo,bookTitle,writer);
	}
	
	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) {// 대출중이면 메세지 뿌리고 끝
			System.out.println(getBookTitle()+ " 도서는 대출중입니다.");
			return;
		} else {// 대출 처리 // state가 0이라 대출처리 진행
			this.borrower = borrower;
			this.checkoutDate = checkoutDate;
			state = STATE_BORROWED; // 대출중 상태로 전환
			System.out.println(getBookTitle()+ "도서가 대출 처리 되었습니다");
			System.out.println("대출인:" + borrower + "\t 대출일 : " + checkoutDate);
		}
			

	
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "도서는 반납완료된 책인데 꺼져  예외다");
			return;

	}
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " 도서가 반납 완료 되었습니다");
	}

	@Override
	public void printState() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookNo() + "\t"+getBookTitle()+"\t"+getWriter()+"지음) 대출가능");
		}else if(state==STATE_BORROWED) {
			System.out.println(getBookNo() + "\t"+getBookTitle()+"\t"+getWriter()+"지음)대출중");
		}else {
			System.out.println(getBookNo() + "\t"+getBookTitle()+"\t"+getWriter()+"지음)이상해");
		}

	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public byte getState() {
		return state;
	}
}

