package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 简单的设置编码对于get请求无法生效
        req.setCharacterEncoding("UTF-8");

        // 在filter传递request之前进行 request的getParameter方法增强
        /**
         * 使用装饰者模式
         * 1. 增强类与被增强的类实现统一接口
         * 2. 在增强类中传入被增强类的
         * 3. 需要增强的方法重写 不需要的方法调用被增强对象的
         */

        // 被增强对象
        HttpServletRequest request = (HttpServletRequest) req;
        // 增强对象---装饰者
        EnhanceRequest enhanceRequest = new EnhanceRequest(request);

        chain.doFilter(enhanceRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
class EnhanceRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public EnhanceRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String parameter = request.getParameter(name);
        System.out.println("before Enhance getParameter: " + parameter);
        try {
            parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("after Enhance  getParameter: " + parameter);
        return parameter;
    }
}

