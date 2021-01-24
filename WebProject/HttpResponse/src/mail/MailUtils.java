package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	/**
	 * @description:
	 * @param: email 邮件目标地址
	 * @param: subject 邮件主题
	 * @param: emailMsg 邮件内容
	 * @return: void
	 * @author: isquz
	 * @date: 2021/1/20 23:21
	 */
	public static void sendMail(String email, String subject, String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
//		props.setProperty("mail.host", "smtp.126.com");
//		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.host", "localhost");
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// 发件邮箱账户密码
				return new PasswordAuthentication("1819*********", "*****");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		// 设置邮件的发件人信息
		message.setFrom(new InternetAddress("18****@qq.com")); // 设置发送者

		// 设置邮件收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject(subject);
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}
