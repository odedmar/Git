package com.carkyp.service.email.model;

import org.springframework.beans.factory.annotation.Value;

public class MailRequest {
	
	@Value( "${mail.sender}" )
	private String from;
	private String To;
	private String subject;
	private String sourceMail;
	private String Name;
	private String lastName;
	private String text;
	
	public MailRequest(){
		
	}
	
	
	public final String getFrom() {
		return from;
	}
	
	
	
	public final void setFrom(String from) {
		this.from = from;
	}


	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getTo() {
		return To;
	}

	public final String getSourceMail() {
		return sourceMail;
	}

	public final void setSourceMail(String sourceMail) {
		this.sourceMail = sourceMail;
	}

	

	public final String getName() {
		return Name;
	}

	public final void setName(String name) {
		Name = name;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
 
	public final void setTo(String to) {
		To = to;
	}
	
	


	public final String getText() {
		return text;
	}


	public final void setText(String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return "MailRequest [from=" + from + ", To=" + To + ", subject="
				+ subject + ", sourceMail=" + sourceMail + ", Name=" + Name
				+ ", lastName=" + lastName + ", text=" + text + "]";
	}


	


	
	
	

}
