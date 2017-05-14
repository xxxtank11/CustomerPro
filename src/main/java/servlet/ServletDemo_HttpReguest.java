package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;

/**
 *  获取客户端通过Form表单提交上来的参数
 * Created by Administrator on 2017/5/13.
 */
public class ServletDemo_HttpReguest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //使用getParameter方法和getParameterValues方法接收表单参数
        String userId = req.getParameter("userId");
        String[] inst = req.getParameterValues("inst");
        System.out.println(MessageFormat.format("userId={0}", userId));

        //使用getParameterNames方法接收表单参数
        Enumeration<String> paramNames = req.getHeaderNames();
        while (paramNames.hasMoreElements()){
            //得到参数名
            System.out.println(paramNames.nextElement());
        }

        //使用getParameterMap方法接收表单参数
        Map<String, String[]> paramMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String name = entry.getKey();
            String[] values = entry.getValue();
        }

        /**
         * 对于以get方式传输的数据，request即使设置了以指定的编码接收数据也是无效的(至于为什么无效我也没有弄明白)，
         * 默认的还是使用ISO8859-1这个字符编码来接收数据，客户端以UTF-8的编码传输数据到服务器端，
         * 而服务器端的request对象使用的是ISO8859-1这个字符编码来接收数据，服务器和客户端沟通的编码不一致因此才会产生中文乱码的。
         * 解决办法：在接收到数据后，先获取request对象以ISO8859-1字符编码接收到的原始数据的字节数组，
         * 然后通过字节数组以指定的编码构建字符串，解决乱码问题。
         */
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO8859-1"), "UTF-8");

        /**
         * 通过ServletContext的getRequestDispatcher(String path)方法，
         * 该方法返回一个RequestDispatcher对象，调用这个对象的forward方法可以实现请求转发。
         */
        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/request_dispatcher_test.jsp");
        requestDispatcher.forward(req, resp);

        /**
         * 通过request对象提供的getRequestDispatche(String path)方法，
         * 该方法返回一个RequestDispatcher对象，调用这个对象的forward方法可以实现请求转发。
         */
        String message = "hi, this is a test";
        req.setAttribute("message", message);
        req.getRequestDispatcher("/request_dispatcher_test.jsp");

        /**
         * 请求重定向和请求转发的区别
         * 一个web资源收到客户端请求后，通知服务器去调用另外一个web资源进行处理，称之为请求转发/307。
         * 一个web资源收到客户端请求后，通知浏览器去访问另外一个web资源进行处理，称之为请求重定向/302。
         */
        //请求重定向
        String resourse = req.getContextPath() + "/test.jsp";
        resp.sendRedirect(resourse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
