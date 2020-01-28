package am.basic.web.service;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositor;

import java.sql.SQLException;

public interface UserService {

    UserRepositor getUserRepositoryImpl();

    User getbyUsername(String username) throws SQLException;
}
