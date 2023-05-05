package sherry.mvc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName:MyContextLoaderListener
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/5 16:14
 **/
public class MyContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      //服务器启动
        System.out.println("服务器启动");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("springmvc.xml");
        sce.getServletContext().setAttribute("applicationContext",beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    //服务器关闭
    }
}
