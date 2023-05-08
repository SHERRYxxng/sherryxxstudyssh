package sherry.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName:UserServiceImpl
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/5 14:19
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void findAll() {
        System.out.println("UserService findAll");
    }

    @Override
    public void Delete() {
        System.out.println("UserService Delete");
    }

    @Override
    public void Insert() {
        System.out.println("UserService insert");
    }
}
