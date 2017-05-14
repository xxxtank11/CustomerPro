package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务端检查验证码
 * Created by Administrator on 2017/5/13.
 */
public class ServletDemo_CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientCheckCode = req.getParameter("validateCode");
        System.out.println("clientCheckCode: " + clientCheckCode);
        String serverCheckCode = (String) req.getSession().getAttribute("checkcode");
        System.out.println("serverCheckCode: " + serverCheckCode);
        if (serverCheckCode.equals(clientCheckCode)) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

