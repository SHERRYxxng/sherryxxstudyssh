package sherry.mvc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @ClassName:WebApplicationContextUtils
 * @Description: 这个工具类只是用来提供BeanFactory对象或者ApplicationContext对象用于解决
 * <br>②`FindAllUserController类`和`MyContextLoaderListener类`的"applicationContext"字符串存在高耦合
 * <br>虽然这种也导致了工具类和MyContextLoaderListener类的耦合,但是这是一个团队一拨人的耦合,而FindAllUserController类是普通程序员写的耦合
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/5 18:55
 **/
public class WebApplicationContextUtils {
    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        ApplicationContext applicationContext=
                (ApplicationContext)servletContext.getAttribute(ApplicationContextConstant.SERVLET_CONTEXT_KEY_APPLICATIONCONTEXT);
        return applicationContext;

    }
}
