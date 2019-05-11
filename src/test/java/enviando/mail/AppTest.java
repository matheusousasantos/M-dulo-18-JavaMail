package enviando.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	
	private String userName = "matheuseason2019@gmail.com";
	private String senha = "seanson2019";

	@Test
	public void testeEmail() {

		try {

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}
			});
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
