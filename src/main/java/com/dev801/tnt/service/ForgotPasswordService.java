package com.dev801.tnt.service;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev801.tnt.data.User;
import com.dev801.tnt.repositories.UsersRepository;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class ForgotPasswordService {
	private static final Random RANDOM = new Random(new Date().getTime());
	private static final Logger LOGGER = Logger.getLogger(ForgotPasswordService.class);

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
				request.method = Method.POST;
				request.endpoint = "mail/send";
				request.body = mail.build();
				Response response = sg.api(request);
				LOGGER.info("Response status code: " + response.statusCode);
				LOGGER.info("Reponse body: " + response.body);
				LOGGER.info("Response headers: " + response.headers);
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
