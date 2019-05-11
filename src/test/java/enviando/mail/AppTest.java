package enviando.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	
	private String userName = "matheuseason2019@gmail.com";
	private String senha = "season2019";

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
			
//			Estabelecendo pra quem vai ser enviado - no caso 3 destinatários
			Address[] toUser = InternetAddress.parse("matheus.ads.study@gmail.com, matheus.sungoddess@gmail.com, matheuseason2019@gmail.com");
			
//			Será nossa mensagem:
			Message message = new MimeMessage(session);
			
//			Quem esta enviando?
			message.setFrom(new InternetAddress(userName));
			
//			Pra quem está enviando - que será a lista de emails
			message.setRecipients(Message.RecipientType.TO, toUser);
			
//			Assunto do Email:
			message.setSubject("Chegou o e-mail enviado com java");
			
//			Corpo do Email
			message.setText("Olá programador, voce acada de receber um email");
			
//			Transportar
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
