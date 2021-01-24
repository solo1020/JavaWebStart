package listener;

import listener.domian.Customer;
import mail.MailUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName BirthdayListener
 * @description:
 * @author: isquz
 * @time: 2021/1/20 23:38
 */
public class BirthdayListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // web应用启动时 调度任务 ----功能是在用户生日当天发送邮件
        // 开启一个定时器
        Timer timer = new Timer();

        // 实际开发中起始时间firstTime是固定的时间
        // 实际开发中间隔时间period 是 1 天

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // 为当前今天生日用户发送邮件
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String currentDate = format.format(new Date());
                QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
                String sql = "select * from customer where birthday like ?";
                List<Customer> customerList = null;
                try {
                    customerList = runner.query(sql, new BeanListHandler<Customer>(Customer.class),"%" + currentDate+"%");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(customerList != null && customerList.size() > 0){
                    for(Customer c: customerList){
                        try {
                            MailUtils.sendMail("c.getEmail", "HappyBirthday", "Dear " + c.getName() + ": happy birthday to you!");
                            System.out.println(c.getName() + " 邮件发送完毕");
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }, new Date(), 1000 * 60);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
