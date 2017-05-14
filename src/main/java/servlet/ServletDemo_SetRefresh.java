package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/12.
 */
@WebServlet("/ServletDemo_SetRefresh")
public class ServletDemo_SetRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置每隔3秒自动刷新
        //resp.setHeader("refresh", "3");

        //设置refresh响应头，让浏览器3秒后跳到www.baidu.com
        resp.setHeader("refresh", "3;url='http://www.sina.com.cn'");
        resp.getWriter().write("DSAGDG");

        //设置content-disposition响应头，让浏览器下载文件
        //resp.setHeader("content-disposition", "attachment;filename=xxx.jpg");
    }
}
