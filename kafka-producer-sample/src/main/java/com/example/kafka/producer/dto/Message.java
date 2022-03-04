package com.example.kafka.producer.dto;

//데이터 전송 개체 클래스 만들기
public class Message {

	private String content;
	private String senderId;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	

}
