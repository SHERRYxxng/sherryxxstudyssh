package sherry.Spring.beforAOP;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName:MyLogging
 * @Description:创建一个工具类用于横向提取CalcImpl(计算器实现类)中的方法调用的日志代码
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 22:27
 **/
@Component      //将当前类标识为一个组件
@Aspect         //将当前类标识为【切面类】【非核心业务提取类】
public class MyLogging {
    public static void beforeMethod(String methodName,Object [] args){

        System.out.println("==>Calc中"+methodName+"方法(),参数为"+Arrays.toString(args));
    }
    public static void afterMethod(String methodName,Object rs){
        System.out.println("==>Calc中"+methodName+"方法(),结果为"+rs);
    }
}
