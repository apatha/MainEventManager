package com.nisum.eventmanager.schedular;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.eventmanager.mail.MailSenders;

public class BootstrapClass {
	@Autowired
	GetDbClass getDbClass;

	@Autowired
	MailSenders mailMail;

	public GetDbClass getGetDbClass() {
		return getDbClass;
	}

	public void setGetDbClass(GetDbClass getDbClass) {
		this.getDbClass = getDbClass;
	}

	public MailSenders getMailMail() {
		return mailMail;
	}

	public void setMailMail(MailSenders mailMail) {
		this.mailMail = mailMail;
	}

	public void alertServiceStartup() {
		String[] to = { "pallada@nisum.com" };
		mailMail.sendMail(to, "alert", "Server Restarted", "TOMCAT");
	}

	public void dbCall() {
		System.out.println("pravallika allada");

		getDbClass.getDbMethod();

		System.out.println("completed successfully");
	}

}
