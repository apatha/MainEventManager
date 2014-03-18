package com.nisum.eventmanager.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Harsha... This class is useful for sending the Mails...... I am
 *         calling methods of this class from Controller...
 */
public class MailSenders {

	private MailSender mailSender;
	String toMail[] = new String[10];
	String eventName;
	String subject;
	String body;
	String from;
	String tooMail;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * This Method is useful for Creating the Schedule.... I am calling this
	 * method from com.nisum.schudule.schuduling.CreateSchudule Mainly I am
	 * Using this method for calling the
	 * "sendMail( toMail, subject, body)".....Which is sending mails....
	 */
	
	
	public void createMethod(String toMail[], String subject, String body,
			String eventName) {
		// TODO Auto-generated method stub
		this.toMail = toMail;
		this.subject = subject;
		this.body = body;
		this.eventName = eventName;
	}
	
	public void createMethod(String tooMail, String subject, String body) {
		// TODO Auto-generated method stub
		System.out.println("in create method");
		System.out.println(tooMail+subject+body+"db values");
		this.tooMail = tooMail;
		this.subject = subject;
		this.body = body;

	}
	
	public void performAction() {

		sendMail(toMail, subject, body, eventName);
	}

	// String to=
	/**
	 * @param to
	 *            means to whom we are sending mails....
	 * @param subject
	 *            means what is the agenda....
	 * @param msg
	 *            means the body or what we wants to send....
	 * @param eventName
	 */
	public void sendMail(String[] toMail, String subject, String msg,
			String eventName) {

		System.out.println(toMail+subject+msg+eventName+   "This is from sendmail testing details....... ");
		
		SimpleMailMessage message = new SimpleMailMessage();// Pre-defined class
															// which is useful
															// for setting and
															// sending the
															// mails..

		message.setFrom(from);
		message.setTo(toMail);
		message.setSubject(subject);
		//msg = msg + " http://192.168.18.103:8080/" + eventName == null ? "Test"
			//	: eventName + "/";
		msg = msg + " http://192.168.18.103:8080/" + eventName +"/";
		message.setText(msg);

		System.out.println(message+"This is from message....");
		try {
			mailSender.send(message);// Calling the method....Which is
										// predefined and with our own
										// properties...
		} catch (Exception e) {
			System.out.println("Mail is not sent due to");
			e.printStackTrace();
		}
	}

	

	/*
	 * private void send(SimpleMailMessage message) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

	
}
