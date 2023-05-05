package sherry.controller;

import org.springframework.beans.factory.BeanFactory;
import sherry.controller.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:FindAllUserController2
 * @Description:
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
