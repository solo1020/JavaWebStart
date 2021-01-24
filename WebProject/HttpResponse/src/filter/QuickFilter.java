package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName QuickFilter
 * @description:
 * @author: isquz
 * @time: 2021/1/21 0:05
 */
public class QuickFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("quickFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("quickFilter running...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("quickFilter destroy...");
    }
}
