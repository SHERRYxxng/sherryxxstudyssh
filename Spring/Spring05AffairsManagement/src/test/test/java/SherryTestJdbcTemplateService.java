import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.study.JdbcTemplate.pojo.Department;
import sherry.study.JdbcTemplate.service.DepartmentService;

/**
 * @ClassName:SherryTestJdbcTemplateService
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 19:25
 **/
@ContextConfiguration(locations = "classpath:SpringJdbcTemplate.xml")//classpath:"这里面写spring配置文件路径"
//指定spring运行器的版本
@RunWith(SpringJUnit4ClassRunner.class)
public class SherryTestJdbcTemplateService {
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void testService(){
        for (Department allDept : departmentService.getAllDepts()) {
            System.out.println("allDept = " + allDept);
        }
    }

}
