package register;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/8/22 14:50
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 防止中文参数乱码 设置request 编码 --只限于post请求
        request.setCharacterEncoding("UTF-8");

        // get请求
//        String username = request.getParameter("username");
//        // 先用ISO8859-1编码
//        username = new String(username.getBytes("iso8859-1"),"UTF-8");

        // 获取数据
        // 多个参数时下面的方式太繁琐，使用BeanUtils解决
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        // 将原始数据封装到JavaBean中
        // 多个参数时下面的方式太繁琐，使用BeanUtils解决
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);

        // 使用BeanUtils自动进行映射封装
        // 工作原理：将map中数据 根据key 与实体类的属性对应关系进行封装
        // 只要key的名字和尸体属性名一样，就自动封装
        Map<String,String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 此时 user对象已经封装完毕
        // 手动封装uid--使用uuid--32位随机不重复字符串 加 四位的短划线 生成的Java代码是36位
        user.setUid(UUID.randomUUID().toString());

        // 将参数传递给业务操作方法
        try {
            regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 注册成功跳转登录页面,不推荐用请求转发，需要让用户看到跳转的地址变化，使用重定向
//        response.sendRedirect("/login.jsp");
        response.sendRedirect(request.getContextPath() + "/login.jsp");



    }

    // 注册方法
    public void regist(User user) throws SQLException {
        // 操作数据库
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user_tbl values(?,?,?,?,?,?,?,?,?,?)";
        runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(), user.getEmail(),null,user.getBirthday(),
                user.getSex(),null,null);
    }
}
