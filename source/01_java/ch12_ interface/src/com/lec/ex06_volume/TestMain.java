package com.lec.ex06_volume;

public class TestMain {
	public static void main(String[] args) {
		IVolume[] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(7)};
		for(IVolume temp : volumes) {
			temp.volumDown();
			temp.volumDown(20);
			temp.volumUp(10);
			temp.volumUp(45);
			temp.setMute(true);
			System.out.println("--------------");
		}
	}
}
