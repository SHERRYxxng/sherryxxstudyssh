package sherry.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import sherry.mvc.WebApplicationContextUtils;
import sherry.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/user/findAll")

public class FindAllUserController2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了FindAllUserController2");
        ApplicationContext applicationContext=
                WebApplicationContextUtils.getApplicationContext(getServletContext());
        //        BeanFactory beanFactory=(BeanFactory) getServletContext().getAttribute(
//                "applicationContext");
        UserService userService=applicationContext.getBean(UserService.class);
        userService.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
