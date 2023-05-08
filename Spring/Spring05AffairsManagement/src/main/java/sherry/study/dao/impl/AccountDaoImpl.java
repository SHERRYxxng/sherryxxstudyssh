package sherry.study.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import sherry.study.dao.AccountDao;

/**
 * @ClassName:AccountDaoImpl
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 10:32
 **/
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void inmoney(int userId, Double money) {
        String sql="update account set balance=balance+? where id=?";
        jdbcTemplate.update(sql,money,userId);
    }

    @Override
    public void outmoney(int userId, Double money) {
        String sql="update account set balance=balance-? where id=?";
        jdbcTemplate.update(sql,money,userId);
    }
}
