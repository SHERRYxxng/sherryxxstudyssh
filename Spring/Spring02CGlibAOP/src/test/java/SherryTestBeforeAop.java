import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.Spring.beforAOP.Calc;
import sherry.Spring.beforAOP.MyProxy;

/**
 * @ClassName:testBeforeAop
 * @Description:动态代理的JDK实现的测试类
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 23:14
 **/
@ContextConfiguration(locations = "classpath:sherrySpring_beforeAop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SherryTestBeforeAop {
    @Autowired
    private Calc calc;
    @Test
    public void testBeforeAop(){
        //判断是否自动装配成功
        //System.out.println(calc);
        //创建需要被动态代理的目标对象
//      Calc calc1=new CalcImpl();
        //创建动态代理对象->中介,将被动态代理的对象带到里面去
//      MyProxy myProxy1 = new MyProxy(calc1);
        MyProxy myProxy = new MyProxy(calc);
        //执行动态代理方法
        //下面第一行这种写法是错误的这是代理对象不是对象代理对象与对象是兄弟关系无法相互转换
//        CalcImpl calcProxy = (CalcImpl) myProxy.getProxyObject();
        Calc calcProxy = (Calc) myProxy.getProxyObject();
        int add=calcProxy.add(1,2);
    }
}
