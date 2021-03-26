package br.edu.ifpb.padroes.service.mail;

import java.io.File;

import br.edu.ifpb.padroes.domain.Customer;

public class EmailNotificationListener implements EventListener {

	public EmailNotificationListener() {
		
	}

	private String email;

	public EmailNotificationListener(String email,String message, Customer customer) {
		System.out.println("send mail notification to "+ email);
		this.email = email;
	}

    public EmailNotificationListener(String email, String message) {
        System.out.println("send mail notification to ="+email);
    }

	@Override
	public void update(String eventType, File file) {
		System.out.println("Email to " + email + ": Someone has performed " + eventType
				+ " operation with the following file: " + file.getName());
	}

}