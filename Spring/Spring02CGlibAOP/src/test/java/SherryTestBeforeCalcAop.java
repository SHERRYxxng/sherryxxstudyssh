import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.Spring.beforAOP.Calc;

/**
 * @ClassName:TestBeforeCalc
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 22:53
 **/
@ContextConfiguration(locations = "classpath:sherrySpring_beforeAop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SherryTestBeforeCalcAop {
    //自动扫描->使用前提需要在xml中配置自动扫描的包,我们这里面只有自动装配缺没有自动代理也就是没有日志的编入和织出
    @Autowired
    private Calc calc;
    @Test
    public void testBeforeAop(){
        //这里是没有使用动态代理的,需要打开手动代理在CalcImpl类中的add方法中的两个注释
        int add=calc.add(1,2);
    }
}
