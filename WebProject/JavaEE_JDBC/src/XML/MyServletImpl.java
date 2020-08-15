package XML;

/**
 * @ClassName MyServletImpl
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/27 22:08
 * @Version 1.0
 **/
public class MyServletImpl implements MyServlet{
    @Override
    public void init() {
        System.out.println("啊哈我来也");
    }

    @Override
    public void service() {
        System.out.println("我可以为你服务");
    }

    @Override
    public void destory() {

        System.out.println("俺老孙去也");
    }
}
