package sherry.controller;

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
 * @ClassName:InsertUserController
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/5 19:43
 **/
@WebServlet("/user/insert")
public class InsertUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InsertUserController");
        ApplicationContext applicationContext=
                WebApplicationContextUtils.getApplicationContext(getServletContext());
        //        BeanFactory beanFactory=(BeanFactory) getServletContext().getAttribute(
//                "applicationContext");
        UserService userService=applicationContext.getBean(UserService.class);
        userService.Insert();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}