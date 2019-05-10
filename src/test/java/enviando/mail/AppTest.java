package enviando.mail;
import java.util.Properties;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	
	@Test
	public void testeEmail() {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");//Autorização.
		properties.put("mail.smtp.starttls", "true"); //Referente a parte de segurança - Autenticação.
		properties.put("mail.smtp.host", "smtp.gmail.com");//Servidor do Gmail Google.
		properties.put("mail.smtp.port", "465"); //Porta do servidor - caminho de entrada pro servidor

//		Definindo um ponto final de fluxo comunicação
		properties.put("mail.smtp.socketFactory.port", "465"); //Especifica a porta a ser conectada pela socket
		
//		Classe do Java que vai usar pra fazer esse tipo de connection
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexao ao SMTP
		
	}
   
}
