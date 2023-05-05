package sherry.studylogger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:loggerTest
 * @Description:这个类是为了测试log4j2是否加锁了,用来体验log4j2和sout的区别
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/5 10:34
 **/
public class loggerTest {
    //切记导包Logger需要用包是org.slf4j的logger,不要导错包了
    //这句话的含义是loggerJlq(日志记录器)是用来记录loggerTest这个类的日志的
    Logger loggerJlq= LoggerFactory.getLogger(loggerTest.class);
    @Test
    public void test1(){
        //可以看到我们再log4j2.xml文件中修改日志级别会使不同级别的打印
        loggerJlq.error("test1 error");
        loggerJlq.warn("test1 warn");
        loggerJlq.info("test1 info");
        loggerJlq.debug("test1 debug");
    }
}
