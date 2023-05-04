package sherry.Spring.beforAOP;

import org.springframework.stereotype.Component;

/**
 * @ClassName:CalcImpl(计算器接口的实体类)
 * @Description: 一个普通的加法,在加法方法中有一个日志功能,计算前记录日志,计算后记录日志,<br>实验后发现问题如下:日志代码比较分散,可以提权出一个日志类,
 * 日志代码比较混乱,
 *      日志代码[非和兴业务代码]与加减乘除方法[核心业务代码]书写一处,所以我们想要把他们分离<br><br><br>
 *      总结:在核心业代码中,需要添加日志功能,但不期望在核心业务代码中书写日志<br>
 *      解决方案:将日志代码横向提取到日志类中,再动态植入到业务代码中<br>
 *      横向提取:这里的解决方案是写一个工具类
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 22:07
 **/
@Component("calc")
public class CalcImpl implements Calc{

    @Override
    public int add(int a, int b) {
        /*这里是手动植入,我们现在需要自动植入,找代理绑我们做,也就是前面的租房中介*/
//         MyLogging.beforeMethod("add",new Object[]{a,b});
        int result=a+b;
        System.out.println("add正在计算中");
//        MyLogging.afterMethod("add",result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub正在计算中");
        int result=a-b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul正在计算中");
        int result=a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div正在计算中");
        int result=a/b;
        return result;
    }
}
