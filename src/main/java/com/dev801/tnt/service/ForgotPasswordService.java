package com.dev801.tnt.service;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev801.tnt.data.User;
import com.dev801.tnt.repositories.UsersRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class ForgotPasswordService {
	private static final Random RANDOM = new Random(new Date().getTime());
	private static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordService.class);

	@Autowired
	UsersRepository usersRepository;

	public void resetPassword(String username) {
		LOGGER.info(username);

		User user = usersRepository.findUserByUsername(username);

		if (user != null) {
			String newPassword = generateRandomPassword();

			LOGGER.info(username + " :: " + newPassword + " :: " + user.getEmailAddress());
			user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
			usersRepository.save(user);

			Email from = new Email("help@801dev.com");
			String subject = "TNT Password Reset";
			Email to = new Email(user.getEmailAddress());
			Content content = new Content("text/plain",
					"You've requested a password reset.  Your new password is: " + newPassword);
			Mail mail = new Mail(from, subject, to, content);

			SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
			Request request = new Request();
			try {
				request.setMethod(Method.POST);
				request.setEndpoint("mail/send");
				request.setBody(mail.build());
				Response response = sg.api(request);
				LOGGER.info("Response status code: " + response.getStatusCode());
				LOGGER.info("Reponse body: " + response.getBody());
				LOGGER.info("Response headers: " + response.getHeaders());
			} catch (IOException ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		} else {
			LOGGER.info("No user found");
		}
	}

	private String generateRandomPassword() {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
		var randomString = new StringBuilder("");
		for (int i = 1; i <= 6; i++) {
			int x = RANDOM.nextInt(chars.length());
			randomString.append(chars.substring(x, x + 1));
		}

		return randomString.toString();
	}
}
