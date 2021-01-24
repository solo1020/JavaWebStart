package mail;

import javax.mail.MessagingException;

/**
 * @ClassName SendMailTest
 * @description:
 * @author: isquz
 * @time: 2021/1/20 23:19
 */
public class SendMailTest {
    public static void main(String[] args) throws MessagingException {
        MailUtils.sendMail("271******10@qq.com","测试邮件", "这是一封测试邮件");
    }
}
