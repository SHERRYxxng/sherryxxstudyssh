package sherry.Spring.beforAOP;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName:MyCGlib
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 14:19
 **/
public class MyCGlib  {
    public static void main(String[] args) {
        Calc calc=new CalcImpl();
        // 使用cglib 生成 p对象的一个子类对象
        Enhancer en =new Enhancer();  // 获取 Enhancer 对象  用于生成代理对象的工具
        en.setSuperclass(calc.getClass());// 设置父类的字节码
        class MyMethodIntercepter implements MethodInterceptor {
            @Override    //  invoked
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                /*
                Object o  生成之后的代理对象  子类对象 personProxy
                method    父类中原本要执行的方法   Person >>>> eat
                objects   父类方法在执行时 传入的参数数组
                methodProxy  子类对象中 重写的父类的方法  personProxy >>>> eat()
                 */
                // 执行其父类中原本的方法
                System.out.println(method.getName());
                System.out.println("吃饭之前先洗手");
                Object res =methodProxy.invokeSuper(o,objects);// 执行子类对象中的方法 子类对象方法在执行时 一定会调用父类的方法
                System.out.println("饭后刷碗");
                return res;
            }
        }
        en.setCallback(new MyMethodIntercepter()); // 用于定义增强父类方法中细节
        Calc calc1 =(Calc) en.create();// 生成了一个代理对象 本质上就是 Person类的一个子类对象
        calc1.add(1, 3);
    }

}
