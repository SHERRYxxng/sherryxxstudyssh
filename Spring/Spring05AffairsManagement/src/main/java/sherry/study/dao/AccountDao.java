package sherry.study.dao;

/**
 * @ClassName:AccountDao
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 10:29
 **/
    public interface AccountDao{
        //转出金额
        void inmoney(int userId , Double money);
        //转入金额
        void outmoney(int userId , Double money);
    }

