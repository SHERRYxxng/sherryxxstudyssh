package sherry.Spring.beforAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName:MyLoggin1
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 11:20
 **/
@Component      //将当前类标识为一个组件
@Aspect         //将当前类标识为【切面类】【非核心业务提取类】
@Order(value = 3)//这里面设置了优先级,相同的通知按照从小到大执行顺序这样可以在前面添加检查
public class MyLoggin1 {
    /*
     * @Description sherry初次体验通过Aspectj自动代理的方式写代理日志有方法前和方法后日志,这里有两种写法,同一种方式实现其实<br>
     *              第一种方式为 sherry.Spring.beforAOP.Calc.add指定特定的方法运行前添加日志<br>
     *              第二种方式为:sherry.Spring.beforAOP.*或者sherry.Spring.beforAOP.Calc
     * .*其实就是*代表所有里面的所有类的所有方法或者指定类的所有方法,他们的本质是一样的这里说两种写法是为了初学者了解
     *
     * @Date  2023/5/3
     * @Param [int a,int b]
     * @return void
     * @Author SHERRY
     * @Version 1.0
     **/

    //    @Before(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
    /*
     * @Description 这是一个可重复利用的切入表达式需要给这个类声明一个注解为Pointcut(切入点)->测试重用切入点
     * @Date  2023/5/3
     * @Param []
     * @return void
     * @Author SHERRY
     * @Version 1.0
     **/
    @Pointcut(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
    //其他地方的用法    @Around(value ="myPointCut()")
    public void myPointCut(){}
    //    @Before(value = "execution(* * (int,int))")
    @Before(value ="myPointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        Object [] args=joinPoint.getArgs();
        System.out.println("[before的前置通知]==>Calc1中"+methodName+"方法(),参数为"+ Arrays.toString(args));
    }
    @AfterReturning(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))",
            returning="result")
//    @AfterReturning(value = "myPointCut()",returning ="result")
    public static void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("[AfterReturning的后置通知]==>Calc1中"+methodName+"方法(),返回结果执行!结果为"+result);
    }
    @After(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
//    @AfterReturning(value = "myPointCut()",returning ="result")
    public static void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("[After的最终通知]==>Calc1中"+methodName+"方法(),最终通知执行!");
    }
    /*
     * @Description 如何接收到这个异常?<br>
     *              在@AfterThrowing中的参数throwing与e不一致
     * @Date  2023/5/3
     * @Param [joinPoint]
     * @return void
     * @Author SHERRY
     * @Version 1.0
     **/
    @AfterThrowing(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))",
            throwing = "e")
//    @AfterReturning(value = "myPointCut()",returning ="result")
    public static void afterThrowingMethod(JoinPoint joinPoint,Throwable e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("[AfterThrowing的异常通知]==>Calc1中"+methodName+"方法(),异常通知执行!异常为"+e);
    }
}
