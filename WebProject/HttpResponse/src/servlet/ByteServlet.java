package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ${NAME}
 * @description: response写字节数据
 * @author: tf
 * @time: 2020/8/16 11:34
 */
//@WebServlet(name = "ByteServlet")
public class ByteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("image/jpg");
        // 使用response获取字节输出流
        ServletOutputStream stream = response.getOutputStream();
        //获取服务器上的图片 先获取绝对路径
//        String picPath = this.getServletContext().getRealPath("imgs/aa.jpg");
        String picPath = this.getServletContext().getRealPath("b.jpg");
        System.out.println(picPath);
        System.out.println(this.getServletContext().getRealPath("/"));
        InputStream in = new FileInputStream(picPath);

//        InputStream in = this.getServletContext().getResourceAsStream("/aa.jpg");

        int len = 0;
        byte[] buffer = new byte[1024];
        while ( (len = in.read(buffer)) > 0){
            stream.write(buffer,0,len);
        }
        in.close();
        stream.close();
    }
}
