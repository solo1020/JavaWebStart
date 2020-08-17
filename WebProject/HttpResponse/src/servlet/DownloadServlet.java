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

@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取待下载文件名称
        String fileName = request.getParameter("filename");

        // 中文的文件名需要进行编码转换
        fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");


        // 客户端通过文件的MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(fileName));

        // 告诉客户端浏览器 不要直接解析，以附件形式下载
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);

        // 获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/"+fileName);
        System.out.println("local file path: " + path);
        // 获取该文件的输入流
        InputStream in = new FileInputStream(path);
        // 获取输出流--通过response的输出流用于向客户端写数据
        ServletOutputStream out = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while ( (len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();

    }
}
