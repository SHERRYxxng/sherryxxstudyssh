package sherry.Spring.beforAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName:MyLogging
 * @Description:初次体验Aspectj自动代理<br>
 *              Aspectj自动代理的参数有以下这这些
 *              @@Before: 前置通知, 在方法执行之前执行
 *              @@After: 后置通知, 在方法执行之后执行 。
 *              @@AfterRunning: 返回通知, 在方法返回结果之后执行
 *              @@AfterThrowing: 异常通知, 在方法抛出异常之后
 *              @@Around: 环绕通知, 围绕着方法执行
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 22:27
 **/
@Component      //将当前类标识为一个组件
@Aspect         //将当前类标识为【切面类】【非核心业务提取类】
@Order(value = 2)
public class MyLogging {
//    /*
//     * @Description sherry初次体验通过Aspectj自动代理的方式写代理日志有方法前和方法后日志,这里有两种写法,同一种方式实现其实<br>
//     *              第一种方式为 sherry.Spring.beforAOP.Calc.add指定特定的方法运行前添加日志<br>
//     *              第二种方式为:sherry.Spring.beforAOP.*或者sherry.Spring.beforAOP.Calc
//     * .*其实就是*代表所有里面的所有类的所有方法或者指定类的所有方法,他们的本质是一样的这里说两种写法是为了初学者了解
//     *
//     * @Date  2023/5/3
//     * @Param [int a,int b]
//     * @return void
//     * @Author SHERRY
//     * @Version 1.0
//     **/
//
////    @Before(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
//    /*
//     * @Description 这是一个可重复利用的切入表达式需要给这个类声明一个注解为Pointcut(切入点)->测试重用切入点
//     * @Date  2023/5/3
//     * @Param []
//     * @return void
//     * @Author SHERRY
//     * @Version 1.0
//     **/
    @Pointcut(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
    //其他地方的用法    @Around(value ="myPointCut()")
    public void myPointCut(){}
////    @Before(value = "execution(* * (int,int))")
//    @Before(value ="myPointCut()")
//    public void beforeMethod(JoinPoint joinPoint){
//        String methodName=joinPoint.getSignature().getName();
//        Object [] args=joinPoint.getArgs();
//        System.out.println("[前置通知]==>Calc中"+methodName+"方法(),参数为"+Arrays.toString(args));
//    }
//    @AfterReturning(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))",
//            returning="result")
////    @AfterReturning(value = "myPointCut()",returning ="result")
//    public static void afterReturningMethod(JoinPoint joinPoint, Object result){
//        String methodName=joinPoint.getSignature().getName();
//        System.out.println("[后置通知]==>Calc中"+methodName+"方法(),返回结果执行!结果为"+result);
//    }
//    @After(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))")
////    @AfterReturning(value = "myPointCut()",returning ="result")
//    public static void afterMethod(JoinPoint joinPoint){
//        String methodName=joinPoint.getSignature().getName();
//        System.out.println("[最终通知]==>Calc中"+methodName+"方法(),最终通知执行!");
//    }
//    /*
//     * @Description 如何接收到这个异常?<br>
//     *              在@AfterThrowing中的参数throwing与e不一致
//     * @Date  2023/5/3
//     * @Param [joinPoint]
//     * @return void
//     * @Author SHERRY
//     * @Version 1.0
//     **/
//    @AfterThrowing(value = "execution(public int sherry.Spring.beforAOP.Calc.*(int,int))",
//            throwing = "e")
////    @AfterReturning(value = "myPointCut()",returning ="result")
//    public static void afterThrowingMethod(JoinPoint joinPoint,Throwable e){
//        String methodName=joinPoint.getSignature().getName();
//        System.out.println("[异常通知]==>Calc中"+methodName+"方法(),异常通知执行!异常为"+e);
//    }
    @Around(value ="myPointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjp){
        String  methodName=pjp.getSignature().getName();
        Object [] args=pjp.getArgs();
        Object result=null;
        try{
            System.out.println("[Around环绕的前置通知]==>Calc中"+methodName+"方法(),参数为"+Arrays.toString(args));
            result=pjp.proceed();
            System.out.println("[Around环绕的后置通知]==>Calc中"+methodName+"方法(),返回结果执行!结果为"+result);

        }catch (Throwable throwable) {
           throwable.printStackTrace();
           System.out.println("[Around环绕的异常通知]==>Calc中"+methodName+"方法(),异常通知执行!异常为"+throwable);
        } finally {
            System.out.println("[Around环绕的最终通知]==>Calc中"+methodName+"方法(),最终通知执行!");
        }
        return result;
    }
}
