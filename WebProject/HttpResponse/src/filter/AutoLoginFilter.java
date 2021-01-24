package filter;

import com.sun.deploy.net.HttpResponse;
import filter.domain.User;
import filter.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("autoLoginFilter....");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String cookie_username = null;
        String cookie_password = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("cookie_username".equals(cookie.getName())){
                    cookie_username = URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
                if("cookie_password".equals(cookie.getName())){
                    cookie_password = URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }

        if(cookie_username != null && cookie_password != null ){
            UserService service = new UserService();
            User user = null;
            try {
                user = service.login(cookie_username,cookie_password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
