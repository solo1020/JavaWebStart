package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName QuickFilter2
 * @description:
 * @author: isquz
 * @time: 2021/1/21 20:59
 */
public class QuickFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("QuickFilter2 running...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
