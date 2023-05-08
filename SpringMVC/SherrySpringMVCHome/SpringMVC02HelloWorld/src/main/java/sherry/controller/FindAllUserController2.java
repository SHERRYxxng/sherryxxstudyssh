package sherry.controller;

import org.springframework.context.ApplicationContext;
import sherry.service.UserService;
import sherry.mvc.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:FindAllUserController2
 * @Description:第二版 方案二
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/5 18:15
 **/
@WebServlet("/user/findAll")

public class FindAllUserController2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
