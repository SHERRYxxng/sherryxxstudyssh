package sherry.mvc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName:MyContextLoaderListener
 * @Description:解决方案二中的两个问题
 * <br>1.字符串硬编码问题代码BeanFactory beanFactory = new ClassPathXmlApplicationContext("springmvc.xml");
 * 中的"springmvc.xml"写死了
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/5 16:14
 **/
public class MyContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      //服务器启动
        System.out.println("服务器启动");
        //实际上创建了一个ApplicationContext对象，而不是BeanFactory对象。这是由于ClassPathXmlApplicationContext类本身就是ApplicationContext的实现类
        // ，它继承了AbstractApplicationContext抽象类并实现了ConfigurableApplicationContext接口。
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("springmvc.xml");
        //sce.getServletContext().setAttribute()用于向Servlet容器的全局作用域中添加属性。
        // 由于ServletContext是整个Web应用程序共享的一个对象，因此可以将ApplicationContext存储在其中，以便在整个应用程序生命周期中都能够访问它。
        //前面的applicationContext只是存储用的键.只要键一样就行
        sce.getServletContext().setAttribute("applicationContext",beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    //服务器关闭
    }
}
