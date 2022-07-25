package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "join";
	}
	@RequestMapping(value = "textMail", method= RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage(); // textMail에서 필요한 아이 
		message.setFrom("aa01096030024@gmail.com"); // 관리자메일 보내는 사람메일
		message.setTo(email); //받는 사람 메일
		message.setSubject("[TEXT 가입인사]" + name +"님 회원가입 감사합니다"); // 보낼 메일에 제목
		String content = name + "님 회원가입 감사합니다\n <h1>태그 안먹음</h1>"; // 글내용 기니까 String으로 먼저 받아주고 
		message.setText(content); // 매일 본문 내용
		
		mailSender.send(message); // 메일 보내기  
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다");
		return "sendResult";
	}
	@RequestMapping(value = "htmlMail", method = RequestMethod.GET)
	public String htmlMail(final String name,final String email, Model model) {
		// name에게 email 주소로 html 내용 보내기 
		MimeMessagePreparator message = new MimeMessagePreparator() {
			//메일 내용(html)
			String content = "<div style=\"width:500px; margin: 0 auto; text-align : center\">\n" + 
					"<h1 style=\"color:blue;\">"+ name +"님 회원가입 감사합니다</h1>\n" + 
					"   <div>\n" + 
					"     <p>이 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"     <p>\n" + 
					"        <img src=\"http://localhost:8090/ch18/resources/coupon.jpg\">\n" + 
					"   </div>\n" + 
					"	<div>\n" + 
					"	  <p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"	  <p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"	  <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\">\n" + 
					"	</div>\n" + 
					"	<p>서울시 강남구 언주로 xx로 </p>\n" + 
					"</div>"; 
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 보내는 메일, 받는 메일 , 메일 제목 , utf-8
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress("aa01096030024@gmail.com"));
				mimeMessage.setSubject("[HTML가입인사]" + name + "님 회원가입 감사합니다");
				mimeMessage.setText(content, "utf-8", "html");
				
			}
		}; // 
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML 메일이 발송되었습니다");
		return "sendResult";
	}
}







