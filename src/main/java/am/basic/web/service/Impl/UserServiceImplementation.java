package am.basic.web.service.Impl;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositor;
import am.basic.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class UserServiceImplementation implements UserService {
@Autowired
    private UserRepositor userRepositoryImpl;

    public void init() {
        System.out.println("UserServiceImpl");
    }
    @Override
    public UserRepositor getUserRepositoryImpl() {
        return userRepositoryImpl;
    }

    @Override
    public User getbyUsername(String username) throws SQLException {
        return userRepositoryImpl.getByUsername("agfcvs");

    }


    public UserServiceImplementation(UserRepositor userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }
}
//changing test