package com.lec.ex06_volume;

public interface IVolume {
	public void volumUp();
	public void volumUp(int level);
	public void volumDown();
	public void volumDown(int level);
	public default void setMute(boolean mute) {
		if(mute)
			System.out.println("���� ó���մϴ�");
		else
			System.out.println("���� ���� �մϴ�");
	}
}
