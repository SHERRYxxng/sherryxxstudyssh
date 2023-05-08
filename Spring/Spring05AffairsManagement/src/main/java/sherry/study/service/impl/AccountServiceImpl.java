package sherry.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sherry.study.dao.AccountDao;
import sherry.study.service.AccountService;

/**
 * @ClassName:AccountServiceImpl
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 10:30
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
//    @Transactional
    public void zhuanzhang(int inuserid, int outuserid, Double money) {
        accountDao.outmoney(inuserid, money);
        System.out.println(5/0);
        accountDao.inmoney(outuserid, money);
    }
}