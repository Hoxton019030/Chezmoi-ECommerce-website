package com.finalProject.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderSerivce{
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,
						  String subject,
						  String body) {
		SimpleMailMessage message = new SimpleMailMessage()	;
		message.setFrom("cdo106046@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Mail sent succseefully...");
	}
	
//	public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
//
//        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
//
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
//        mimeMessageHelper.setTo(to);
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setText(content,true);
//
//        try {
//            mailSender.send(mimeMailMessage);
//        } catch (MailException e) {
//        }
//    }
			
					
	
}
