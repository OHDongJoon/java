package com.lec.ex;
//tudent (String 학번, 이름, int 학년, char 반, int 점수)정보 데이터 받기
public class Student {
	private String haknum; //학번
	private String name; // 이름
	private int    level;// 학년
	private char   ban; // 반
	private int		score;//점수
	public String getHaknum() {
		return haknum;
	}
	public void setHaknum(String haknum) {
		this.haknum = haknum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public char getBan() {
		return ban;
	}
	public void setBan(char ban) {
		this.ban = ban;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
