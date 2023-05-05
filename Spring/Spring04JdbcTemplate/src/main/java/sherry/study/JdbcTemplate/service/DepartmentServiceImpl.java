package sherry.study.JdbcTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sherry.study.JdbcTemplate.dao.DepartmentDao;
import sherry.study.JdbcTemplate.pojo.Department;

import java.util.List;

/**
 * @ClassName:DepartmentServiceImpl
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 19:15
 **/
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    @Qualifier("departmentDaoImpl")
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getAllDepts() {
        return departmentDao.selectAllDepts();
    }
}
