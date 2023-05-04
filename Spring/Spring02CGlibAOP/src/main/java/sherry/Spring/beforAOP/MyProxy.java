package sherry.Spring.beforAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName:MyProxy
 * @Description:sherry初次体验自动代理
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 23:22
 **/
public class MyProxy{
    /*目标对象[目标客户] 需要使用动态代理的客户*/
    private Object target;
    public MyProxy(Object target){
        //这里面是获取传入的对象
        this.target=target;
    }
    public Object getProxyObject() {
        Object proxyObj = null;
        //我们需要通过反射获取对象的三个属性,分别是类加载器,目标对象实现的所有接口,目标对象的匿名内部类的
        /*ClassLoader loader, 类加载器,目标对象的类加载
        Class<?>[] interfaces,目标对象实现的所有接口
        InvocationHandler h*/
        //注意这个InvocationHandler是个接口我们需要传入这个接口之前需要创建一个实现类,这里直接用的是匿名内部类因为他只在这用

        //获取target对象的类加载器->也就是target所属类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //获取target对象的所有接口->也就是target所属类的所实现的所有接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //这里面第三个参实现了InvocationHandler接口创建了匿名内部类直接传参

        //其实第三个参数才是动态代理的核心实现,他有点像我们前面所学的线程类的Thread的Runable接口
        //这里面我们是实现InvocationHandler接口中的invoke方法,这个方法是与我们之前在反射中的invoke方法有很大区别的
       /*
        * @Description  /**@结论 不完全一样。<br>

         @内容 在Java反射中，invoke方法是Method类和Constructor类的方法，用于调用特定对象的特定方法或构造函数。<br>

         而在动态代理中，InvocationHandler接口中的invoke方法是用于处理代理对象方法调用的方法，它会被代理对象调用，而代理对象会把方法调用转发给InvocationHandler来处理。<br>

         虽然它们都叫做invoke方法，但是它们的作用和使用场景是不同的。在反射中，invoke方法是用于调用特定对象的方法，而在动态代理中，invoke方法是用于处理代理对象方法调用的方法。<br>
        * @Date  2023/5/4 
        * @Param []
        * @return java.lang.Object
        * @Author SHERRY       
        * @Version 1.0
        **/

        proxyObj=Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            //执行invoke()实现动态织入效果
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取方法名[目标对象]
                String name = method.getName();
                //执行之前,添加日志
                MyLogging.beforeMethod(name,args);
                //触发目标对象目标方法
                Object rs=method.invoke(target,args);
                //执行之前,添加日志
                MyLogging.afterMethod(name,args);
                return rs;
            }
        });
        return proxyObj;

    }
}
