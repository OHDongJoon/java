package Test;
// checkOut
public interface ILendable2 {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkOut(String borrower , String checkoutDate);
	public void checkIn();
	public void printState();
}
