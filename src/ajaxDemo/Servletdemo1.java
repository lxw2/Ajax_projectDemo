package ajaxDemo;

import JDBCutils.jdbcutils;
import com.alibaba.druid.util.JdbcUtils;
import userinfo.userInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servletdemo1")
public class Servletdemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取输出编码格式初始化
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //读取参数
        System.out.println(123);
        String username = request.getParameter("message");
        //调用数据中的数据
        userInfo userinfo = jdbcutils.getUserinfo(username);
        StringBuilder sb = new StringBuilder();
        sb.append("姓名"+userinfo.getName()+"</br>");
        sb.append("生日"+userinfo.getBirthday()+"</br>");
        sb.append("性别"+userinfo.getSex()+"</br>");
        sb.append("状态"+userinfo.getStatue()+"</br>");
        String string = sb.toString();

        //将信息添加到响应中去
        response.getWriter().write("用户信息为</br>"+string);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
