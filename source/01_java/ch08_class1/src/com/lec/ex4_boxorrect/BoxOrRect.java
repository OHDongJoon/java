package com.lec.ex4_boxorrect;

import javax.swing.Box;

public class BoxOrRect {
	// 데이터
	private int width;
	private int height;
	private int depth; // box 경우 깊이, rect일 경우는 0
	private int volume; // box경우 부피, rect일 경우 넓이

	public BoxOrRect() {
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth;
	}

	public int getVolume() {
		return volume;
	}

	public void vPrint() {
		if (depth != 0) {
			System.out.println("부피는" + volume);
		} else {
			System.out.println("넓이는" + volume);
		}
	}

}
