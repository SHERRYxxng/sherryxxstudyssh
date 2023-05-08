import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sherry.study.service.AccountService;

/**
 * @ClassName:TestAccount
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 10:35
 **/
public class TestAccount {
    @Test
    public void testaccount(){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService=(AccountService) applicationContext.getBean("accountServiceImpl");
        accountService.zhuanzhang(1,2,10d);
    }

    public static void main(String[] args) {
        new TestAccount().testaccount();
    }
}
