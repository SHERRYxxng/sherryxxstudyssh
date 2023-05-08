package sherry.controller;

import org.springframework.beans.factory.BeanFactory;
import sherry.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:FindAllUserController2
 * @Description:   第二版 方案一 第一次请求时, 创建BeanFactory对象并将其保存到应用域(ServletContext), 第二次请求时, 复用之前保存的BeanFactory对象.
 * <br>解决方案当服务器启动时(ServletContextListener), 创建BeanFactory对象并将其保存到应用域(ServletContext) ; 第一次请求时,复用之前保存的BeanFactory对象.第二次请求, ...
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/5 18:15
 **/
public class FindAllUserController2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BeanFactory beanFactory=(BeanFactory) getServletContext().getAttribute(
                "applicationContext");
        UserService userService=beanFactory.getBean(UserService.class);
        userService.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
