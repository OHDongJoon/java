package com.lec.ch03.ex1;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class StudentInfo {
	@Autowired // Student  달라 붙게 
	private Student student; // 의존 받아 

}
