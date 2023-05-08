package sherry.study.service;

/**
 * @ClassName:AccountService
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 10:30
 **/

    public interface AccountService {
        //转账
        void zhuanzhang(int inuserid ,int outuserid ,Double money);
    }

