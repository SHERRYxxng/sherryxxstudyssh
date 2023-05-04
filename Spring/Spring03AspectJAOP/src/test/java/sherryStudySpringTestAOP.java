import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sherry.Spring.beforAOP.Calc;

/**
 * @ClassName:sherryStudySpringTestAOP
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/3 17:32
 **/
public class sherryStudySpringTestAOP {
    @Test
    public void testAOP(){
        ApplicationContext context=new ClassPathXmlApplicationContext("sherrySpring_beforeAop.xml");
        Calc calc = context.getBean("calc", Calc.class);
        calc.add(1,2);
        System.out.println("====================================");
        calc.div(9,1);
    }
}
