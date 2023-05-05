package sherry.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sherry.controller.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:FindAllUserController
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/5 14:16
 **/

@WebServlet("/user/findAll")
public class FindAllUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*方案一:与应用域进行绑定->创建BeanFactory对象并保存到应用域ServletContext,
        之后请求复用之前保存应用域ServletContext中的对象问题第一次请求耗时较长*/
        BeanFactory beanFactory=(BeanFactory) getServletContext().getAttribute("applicationContext");
        /*方案二:与服务器启动进行绑定->当服务器启动时(ServletContextListener), 创建BeanFactory对象并将其保存到应用域(ServletContext) ;
        第一次请求时,复用之前保存的BeanFactory对象.第二次请求, ...*/

        UserService userService = beanFactory.getBean(UserService.class);
        userService.findAll();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}