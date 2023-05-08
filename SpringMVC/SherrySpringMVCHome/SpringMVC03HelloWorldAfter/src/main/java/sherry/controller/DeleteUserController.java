package sherry.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sherry.mvc.WebApplicationContextUtils;
import sherry.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:DeleteUserController
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/5 19:42
 **/
@WebServlet("/user/Delete")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteUserController");
        ApplicationContext applicationContext=
                WebApplicationContextUtils.getApplicationContext(getServletContext());
        //        BeanFactory beanFactory=(BeanFactory) getServletContext().getAttribute(
//                "applicationContext");
        UserService userService=applicationContext.getBean(UserService.class);
        userService.Delete();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
